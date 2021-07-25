package com.stepDefinitions;

import com.pages.CustomerProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class customerSetpDefinitions {
	CustomerProfilePage customerProfilePage = new CustomerProfilePage();

	@And("user clicks on Plus icon")
	public void clickOnPlusIcon() {
		customerProfilePage.clickOnPlusIcon();
	}

	@And("user clicks on edit customer profile button")
	public void clickOnEditCustomerBtn() {
		customerProfilePage.clickOnEditCustomerProfile();
	}

	@And("user fills customer details")
	public void fillCustomerDetails() {
		customerProfilePage.fillOutletDetails();
	}
	
	@Then("user clicks on save button")
	public void clickOnSaveBtn() {
		customerProfilePage.clickOnSaveBtn();
	}
}
