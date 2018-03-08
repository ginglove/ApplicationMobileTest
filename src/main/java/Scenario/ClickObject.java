package Scenario;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.IntroPage;
import pageobject.LoginPage;
import pageobject.TimeLine;
import pageobject.ItemDetails;
public class ClickObject  {
	private static AndroidDriver driver; 
	private DesiredCapabilities capabilities=new DesiredCapabilities();
	private IntroPage intropage;
	private LoginPage loginpage;
	private TimeLine timeline;
	private ItemDetails itemdetails;
	@Test
	public void ApplicationHome(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		intropage.clickBtnNext();
		loginpage.clickBtnSkip();
		timeline.clickBtnCancel();
		timeline.clickItemLine1();
		itemdetails.checkImgItemDisplays();
		itemdetails.checkbtnCommentDisplays();
		itemdetails.clickbtnComment();
	}
	@BeforeTest
	private void SetupTest() throws MalformedURLException
	{	  
		  final String URL_STRING = "http://127.0.0.1:4723/wd/hub"; 
		  URL url = new URL(URL_STRING);
		  DesiredCapabilities capabilities=new DesiredCapabilities();
		  capabilities.setCapability("deviceName", "Pixel_API_24");
		  capabilities.setCapability("platformVersion", "7.0");
		  capabilities.setCapability("platformName", "Android");	  
		  capabilities.setCapability("automationName", "UiAutomator2");
		  capabilities.setCapability("udid", "emulator-5554");
		  capabilities.setCapability("appPackage", "com.mercariapp.mercari");
		  capabilities.setCapability("appActivity","com.mercari.ramen.signup.SignUpSelectActivity");
			  driver=new AndroidDriver(url, capabilities);
	}
	@AfterTest 
	   public void tearDownAppium() throws Exception {  
	     System.out.println("\nTearing Down Driver.");  
	     driver.quit();  
	   }  
}
