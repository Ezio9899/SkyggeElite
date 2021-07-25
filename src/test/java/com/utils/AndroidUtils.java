package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import com.base.TestBase;

import io.appium.java_client.TouchAction;


public class AndroidUtils extends TestBase{
	
	public static void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        
        new TouchAction(driver)
            .press(point(anchor, startPoint))
            .waitAction(waitOptions(ofMillis(1000)))
            .moveTo(point(anchor, endPoint))
            .release().perform();
    }
	
	public static void updateImplicitWaitTime(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public static void resetImplicitWaitTime() {
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(configProp.getProperty("implicitWait")), TimeUnit.SECONDS);
	}
	
	public static WebElement getElementByDynamicText(String text) {
		return driver.findElement(By.xpath("//*[contains(@text,'"+text+"')]"));
	}
}
