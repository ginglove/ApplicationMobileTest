package Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Utils {
private static AndroidDriver driver;
public static void main(String args[]) throws MalformedURLException, InterruptedException{
		  DesiredCapabilities capabilities=new DesiredCapabilities();
		  capabilities.setCapability("deviceName", "Pixel_API_24");
		  capabilities.setCapability("platformVersion", "7.0");
		  capabilities.setCapability("platformName", "Android");	  
		  capabilities.setCapability("automationName", "UiAutomator2");
		  capabilities.setCapability("udid", "emulator-5554");
		  capabilities.setCapability("appPackage", "com.mercariapp.mercari");
		  capabilities.setCapability("appActivity","com.mercari.ramen.signup.SignUpSelectActivity");
		  driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}

	@SuppressWarnings("unchecked")
	public static String getAbsoluteFilePath(String relativeFilepath) {
		String curDir = System.getProperty("user.dir");
		String absolutePath = curDir + "/src/main/resources/" + relativeFilepath;
		return absolutePath;
	}

	public static Properties loadProperties(String fileName) {
		Properties configProperies = null;
		FileReader in;
		try {
			in = new FileReader(getAbsoluteFilePath(fileName));
			configProperies = new Properties();
			configProperies.load(in);
			in.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return configProperies;
	}
	
	public static void captureScreen(WebDriver driver, String testcase, String fileName) {
		System.out.println("Capture Screenshoot " + fileName);
		String path;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String curDir = System.getProperty("user.dir");
		Date date = new Date();
		path = curDir + "/target/screenshoot/" + testcase + "/"
				+ date.getTime() + "_";
		File f = new File(path);
		if (!f.exists())
			f.mkdirs();
		String filePath = path + fileName + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static void swipeMobileUp(AndroidDriver<MobileElement> driver) {
		
		Dimension size = driver.manage().window().getSize();
		int x = size.width / 2;
		TouchAction action = new TouchAction(driver);
		action.press(x, size.height/2).moveTo(x, 110).release().perform();
	}
	
	@SuppressWarnings("unchecked")
	public static void swipeMobileDown(AndroidDriver<MobileElement> driver)
	{	
		Dimension size=driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		TouchAction action = new TouchAction(driver);
		action.press(startx, starty).moveTo(startx, endy).release().perform();
	}
	public static void swipeMobileDown20percent(AndroidDriver<MobileElement> driver)
	{	
		Dimension size=driver.manage().window().getSize();
		int starty = (int) (size.height * 0.60);
		int endy = (int) (size.height * 0.40);
		int startx = size.width / 2;
		TouchAction action = new TouchAction(driver);
		action.press(startx, starty).moveTo(startx, endy).release().perform();
	}	
	@SuppressWarnings("unchecked")
	public static void swipeMobileLeft(AndroidDriver<MobileElement>driver)
	{
		Dimension size =driver.manage().window().getSize();
		int startx = (int) (size.width * 0.70);
		int endx = (int) (size.width * 0.30);
		int starty = size.height / 2;
		TouchAction action = new TouchAction(driver);
		action.press(startx, starty).moveTo(endx, starty).release().perform();
	}
	@SuppressWarnings("unchecked")
	public static void swipeMobileRight(AndroidDriver<MobileElement>driver)
	{
		Dimension size=driver.manage().window().getSize();
		int startx = (int) (size.width * 0.70);
		int endx = (int) (size.width * 0.30);
		int starty = size.height / 2;
		TouchAction action = new TouchAction(driver);
		action.press(endx, starty).moveTo(starty, starty).release().perform();
	}
	public static WebElement getElement(By loc) {
		WebElement ele = null;
		try {
			ele = driver.findElement(loc);
		} catch (Exception e) {
			System.out.println("Can not find Element with locator : " + loc);
			e.printStackTrace();
		}
		return ele;
	}
	public static void checkElementExist(By loc) {
		if (getElement(loc) != null) {
			System.out.println("Element with locator : " + loc + " is exist");
			Utils.captureScreen(driver, "GuruTest", "Element is exist");
			Assert.assertTrue(true);
		} else {
			System.out.println("Element with locator : " + loc + " is not exist");
			Utils.captureScreen(driver, "GuruTest", "Element is not exist");
			Assert.assertTrue(true);
		}
	}
	public static Boolean checkElementDisplay(By loc){
		Boolean r = false;
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
		if (element != null)
			r = true;
		if (r == true)
			Reporter.log("Find element successful:"+loc);
		else
			Reporter.log("Cannot find element: "+loc);

		return r;
	}
	public static void waitTimeSecond(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
