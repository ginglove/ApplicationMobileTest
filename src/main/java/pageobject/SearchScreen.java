package pageobject;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchScreen {
	private AndroidDriver driver; 
	public By txtSearchBox;
	public By txtSuggest;
	public By itemRow5;
	public SearchScreen(AndroidDriver driver) {  
	    this.driver = driver;  
		PageFactory.initElements((WebDriver) new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }  
    public void inputTextIntoSearchBox(String text){   
    	Properties prop = Utils.loadProperties("ObjectRepo/SearchScreen.properties");
    	txtSearchBox=By.xpath(prop.getProperty("Mercari.SearchScreen.txtSearchBox"));
    	Utils.checkElementDisplay(txtSearchBox);
    	Utils.getElement(txtSearchBox).sendKeys(text); 	
    }
    public void clickTxtSuggest(){
    	Properties prop = Utils.loadProperties("ObjectRepo/SearchScreen.properties");
    	txtSuggest=By.xpath(prop.getProperty("Mercari.SearchScreen.txtSuggest"));
    	Utils.checkElementDisplay(txtSuggest);
    	Utils.getElement(txtSuggest).click();
    }
    public void clickSearchResultItemAt5thRow(){
    	Properties prop = Utils.loadProperties("ObjectRepo/SearchScreen.properties");
    	itemRow5=By.xpath(prop.getProperty("Mercari.SearchResultScreen.lbItem5"));
    	Utils.swipeMobileDown20percent(driver);
    	Utils.checkElementExist(itemRow5);
    	Utils.getElement(itemRow5).click();
    }
}
