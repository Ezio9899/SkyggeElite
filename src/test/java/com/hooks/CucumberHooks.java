package com.hooks;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import com.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {
	TestBase testBase;
	
	// To Start the app
	@Before
	public void setup () {
		// Get the platform from xml parameter
		String platform = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platform");
		testBase = new TestBase();
		
		testBase.setupDriver(platform);
		
	}
	
	@After
	public void cleanUp() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestBase.driver.quit();
	}

}
