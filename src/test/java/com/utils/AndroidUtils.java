package com.utils;

import org.openqa.selenium.WebElement;

import com.base.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidUtils extends TestBase{
	
	public void scroll(WebElement ele) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(PointOption.point(0, 0)).moveTo(ElementOption.element(ele)).release().perform();
	}
}
