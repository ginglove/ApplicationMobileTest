package pageobject;
import Utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import Utils.Utils;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IntroPage{
	private AndroidDriver driver; 
	public By btnNext;
	public IntroPage(AndroidDriver driver) {  
	    this.driver = driver;  
		PageFactory.initElements((WebDriver) new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }  

    public void clickBtnNext(){   
    	Properties prop = Utils.loadProperties("ObjectRepo/Intro.properties");
	    btnNext=By.xpath(prop.getProperty("Mercari.IntroPage.btnNext"));
    	for(int i=0;i<5;i++)
    	{   
    		Utils.getElement(btnNext).click();
    		Utils.waitTimeSecond(5);
    	}
    }
}
