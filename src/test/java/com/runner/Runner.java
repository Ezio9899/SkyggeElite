package com.runner;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.base.TestBase;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "feature",
		glue = {"com.stepDefinitions", "com.hooks"},
        plugin = "json:target/cucumber-reports/CucumberTestReport.json",
        monochrome = true,
        tags = "@customer"
		)

public class Runner extends AbstractTestNGCucumberTests{
	
}
