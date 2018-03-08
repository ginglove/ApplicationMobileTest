package pageobject;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TimeLine {
	private AndroidDriver driver; 
	public By btnCancel;
	public By itemLine1;
	public By btnSearch;
	public TimeLine(AndroidDriver driver) {  
	    this.driver = driver;  
		PageFactory.initElements((WebDriver) new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }  

    public void clickBtnCancel(){   
    	Properties prop = Utils.loadProperties("ObjectRepo/TimeLine.properties");
    	btnCancel=By.xpath(prop.getProperty("Mercari.TimeLine.buttonPanel.btnCancel"));
	    Utils.checkElementExist(btnCancel);
	    Utils.checkElementDisplay(btnCancel);
	    Utils.getElement(btnCancel).click();
}
    public void clickItemLine1(){
    	Properties prop = Utils.loadProperties("ObjectRepo/TimeLine.properties");
    	itemLine1=By.xpath(prop.getProperty("Mercari.TimeLine.itemLine1.btnItem"));
	    Utils.checkElementExist(itemLine1);
	    Utils.checkElementDisplay(itemLine1);
	    Utils.getElement(itemLine1).click();    
    }
    public void clickBtnSearch(){
    	Properties prop = Utils.loadProperties("ObjectRepo/TimeLine.properties");
    	btnSearch=By.xpath(prop.getProperty("Mercari.TimeLine.btnSearch"));
    	Utils.checkElementDisplay(btnSearch);
    	Utils.getElement(btnSearch);
    }
}
