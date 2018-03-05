package utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class SupportClass {
	public static AppiumDriver<MobileElement>driver;
	@SuppressWarnings("deprecation")
	public void tap(String element)
	{
		MobileElement Element=driver.findElement(By.xpath(element));
		TouchAction actions=new TouchAction(driver);
		try {
			actions.tap(Element);
			actions.perform();
			Log.info("Click Successful");
		}
		catch(Exception e){
			Log.error("Click not successful");
		}
	}

}
