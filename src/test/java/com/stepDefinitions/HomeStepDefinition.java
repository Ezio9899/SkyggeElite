package com.stepDefinitions;

import com.pages.HomePage;

import io.cucumber.java.en.Then;

public class HomeStepDefinition {

	public HomePage homePage = new HomePage();

	@Then("user clicks on Customer Profile")
	public void clickOnCustomerProfile() {
		homePage.clickOnCustomerProfile();
	}
}
