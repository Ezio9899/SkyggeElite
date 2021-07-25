package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.messages.internal.com.google.gson.Gson;

public class TestBase {
	public static AppiumDriver<WebElement> driver;
	public static Properties configProp = new Properties();
	public static WebDriverWait wait;

	public TestBase() {
		try {
			FileInputStream fip = new FileInputStream("resources/config.properties");
			TestBase.configProp.load(fip);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void setupDriver(String platform) {
		try {
			URL remoteURL = new URL(configProp.getProperty("serverURL").toString());
			int implicitWait = Integer.parseInt(configProp.getProperty("implicitWait"));
			
			switch (platform) {
			case "android":
				DesiredCapabilities desiredCap = new DesiredCapabilities(getCapabilities(platform));
				TestBase.driver = new AndroidDriver<WebElement>(remoteURL, desiredCap);
				break;
				
			case "iOS":
				DesiredCapabilities desiredCapiOS = new DesiredCapabilities(getCapabilities(platform));
				TestBase.driver = new IOSDriver<WebElement>(remoteURL, desiredCapiOS);
				break;

			default:
				break;
			}
			TestBase.driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 30);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// To get capabilities from xml file
	public HashMap<String, String> getCapabilities(String platform) {
		HashMap<String, String> capabilities = null;
		if (platform.contentEquals("android")) {
			Gson gson = new Gson();
			String jsonString = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("desiredCapabilities");
			capabilities = gson.fromJson(jsonString, HashMap.class);
			String appAbsolutePath = getAppAbsolutePath(capabilities.get("app"));
			capabilities.put("app", appAbsolutePath);
		} else if (platform.contentEquals("iOS")) {
			Gson gson = new Gson();
			String jsonString = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("desiredCapabilities");
			capabilities = gson.fromJson(jsonString, HashMap.class);
			String appAbsolutePath = getAppAbsolutePath(capabilities.get("app"));
			capabilities.put("app", appAbsolutePath);
		}
		return capabilities;
	}
	
	public String getAppAbsolutePath(String path) {
		File file = new File(path);
		return file.getAbsolutePath();
	}

}
