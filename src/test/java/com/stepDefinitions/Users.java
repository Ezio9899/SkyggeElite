package com.stepDefinitions;

import com.pages.RegistrationPage;
import com.pages.TermsAndConditionsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Users {
	public TermsAndConditionsPage termsAndConditionPage = new TermsAndConditionsPage();
	public RegistrationPage registerPage = new RegistrationPage();

	@When("user accepts the terms and condition")
	public void acceptTermsAndCondition() {
		termsAndConditionPage.clickOnAcceptBtn();
	}

	@Then("user is navigated to signup page")
	public void when() {
	}

	@When("user click on already have account")
	public void then() {
	}

	@And("user enters mobile number")
	public void and() {
	}

	@And("user clicks on signin button")
	public void clickOnSignin() {

	}

	@Then("user is logged in")
	public void verifyUserIsLoggedIn() {

	}
	
	@When("user fill the registartion details with ${int} ${string}")
	public void fillRegistartionDetails(int vendorId, String city) {
		System.out.println("vahjvdshjav"+vendorId+"  ---- "+city);
	}
	
	@And("user click on register button")
	public void clickRegisterBtn() {
		
	}
	
	@Then("user is on home page")
	public void verifyHomePage() {
		
	}
	
	@When("user login using ${long}")
	public void login(Long number) {
		registerPage.checkIfUserIslogin(Long.toString(number));
	}
}
