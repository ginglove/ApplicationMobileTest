package ApplicationTest;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utility.Log;
import utility.SupportClass;

import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class NewTest {
	public static AndroidDriver<MobileElement> driver;
  @Test
  public void ApplicationTest() throws Exception {
	  Properties obj = new Properties();   
	  FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\object repository\\objects.properties");
	  obj.load(objfile); 
  }
  @BeforeTest
  public void beforeTest() throws MalformedURLException, InterruptedException {
	  DesiredCapabilities capabilities=new DesiredCapabilities();
	  capabilities.setCapability("deviceName", "Pixel_API_24");
	  capabilities.setCapability("platformVersion", "7.0");
	  capabilities.setCapability("platformName", "Android");	  
	  capabilities.setCapability("automationName", "UiAutomator2");
	  capabilities.setCapability("udid", "emulator-5554");
	  /*capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
	  /*capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");*/
	  driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
