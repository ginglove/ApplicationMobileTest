package pageobject;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class LoginPage{
	private AndroidDriver driver; 
	public By btnSkip;
	public LoginPage(AndroidDriver driver) {  
	    this.driver = driver;  
		PageFactory.initElements((WebDriver) new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }  

    public void clickBtnSkip(){   
    	Properties prop = Utils.loadProperties("ObjectRepo/Login.properties");
	    btnSkip=By.xpath(prop.getProperty("Mercari.LoginScreen.btnSkip"));
	    Utils.checkElementExist(btnSkip);
	    Utils.checkElementDisplay(btnSkip);
	    Utils.getElement(btnSkip).click();
}
}
