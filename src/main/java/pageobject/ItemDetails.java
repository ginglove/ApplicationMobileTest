package pageobject;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ItemDetails {
	private AndroidDriver driver; 
	public By imgItem;
	public By btnComment;
	public By btnBuy;
	public ItemDetails(AndroidDriver driver) {  
	    this.driver = driver;  
		PageFactory.initElements((WebDriver) new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    } 
	public void checkImgItemDisplays()
	{
    	Properties prop = Utils.loadProperties("ObjectRepo/ItemDetails.properties");
	    imgItem=By.xpath(prop.getProperty("Mercari.ItemDetails.imgItem"));
	    Utils.checkElementDisplay(imgItem);
	}
	public void checkbtnCommentDisplays()
	{
		Properties prop = Utils.loadProperties("ObjectRepo/ItemDetails.properties");
		btnComment=By.xpath(prop.getProperty("Mercari.ItemDetails.btnComment"));
		for(int i=0;i<2;i++)
		{
			Utils.swipeMobileDown(driver);
		}
		Utils.checkElementDisplay(btnComment);
	}
	public void clickbtnComment()
	{
		Properties prop = Utils.loadProperties("ObjectRepo/ItemDetails.properties");
		btnComment=By.xpath(prop.getProperty("Mercari.ItemDetails.btnComment"));
		Utils.checkElementDisplay(btnComment);
		Utils.getElement(btnComment).click();
	}
	public void clickbtnBuy(){
		Properties prop = Utils.loadProperties("ObjectRepo/ItemDetails.properties");
		btnBuy=By.xpath(prop.getProperty("Mercari.ItemDetails.btnBuy"));
		Utils.checkElementExist(btnBuy);
		Utils.getElement(btnBuy).click();
	}
}
