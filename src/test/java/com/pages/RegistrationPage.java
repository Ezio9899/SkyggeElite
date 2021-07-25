package com.pages;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class RegistrationPage extends TestBase {
	
	@FindBy(xpath = "//*[contains(@resource-id,'id/input_vendid')]")
	WebElement registrationPageVendorIdField;

	@FindBy(xpath = "//*[contains(@resource-id,'id/input_salesRepFName')]")
	WebElement registrationPageFirstNameField;
	
	@FindBy(xpath = "//*[contains(@resource-id,'id/input_salesRepLName')]")
	WebElement registrationPageLastNameField;
	
	@FindBy(xpath = "//*[contains(@resource-id,'id/input_phone')]")
	WebElement registrationPagePhoneNoField;
	
	@FindBy(xpath = "//*[contains(@resource-id,'id/input_emailId')]")
	WebElement registrationPageEmailIdField;
	
	@FindBy(xpath = "//*[contains(@resource-id,'id/input_city')]")
	WebElement registrationPageCityField;
	
	@FindBy(xpath = "//*[contains(@resource-id,'id/btn_register')]")
	WebElement registrationPageRegisterBtn;
	
	@FindBy(xpath = "//*[contains(@resource-id,'id/txtAlreadyAccount')]")
	WebElement registrationPageAlreadyHaveAccountBtn;
	
	@FindBy(xpath = "//*[contains(@resource-id,'id/edtMobileNumber')]")
	WebElement registrationPageEditMobileNumberField;
	
	@FindBy(xpath = "//*[contains(@resource-id,'id/btnSignUpToAccount')]")
	WebElement registrationPageSignIntBtn;
	
	public WebElement getRegistrationPageEditMobileNumberField() {
		return registrationPageEditMobileNumberField;
	}

	public WebElement getRegistrationPageSignIntBtn() {
		return registrationPageSignIntBtn;
	}

	public WebElement getRegistrationPageVendorIdField() {
		return registrationPageVendorIdField;
	}

	public WebElement getRegistrationPageFirstNameField() {
		return registrationPageFirstNameField;
	}

	public WebElement getRegistrationPageLastNameField() {
		return registrationPageLastNameField;
	}

	public WebElement getRegistrationPagePhoneNoField() {
		return registrationPagePhoneNoField;
	}

	public WebElement getRegistrationPageEmailIdField() {
		return registrationPageEmailIdField;
	}

	public WebElement getRegistrationPageCityField() {
		return registrationPageCityField;
	}

	public WebElement getRegistrationPageRegisterBtn() {
		return registrationPageRegisterBtn;
	}

	public WebElement getRegistrationPageAlreadyHaveAccountBtn() {
		return registrationPageAlreadyHaveAccountBtn;
	}
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void fillRegistrationFields(int vendorId, String city) {
		getRegistrationPageVendorIdField().sendKeys(Integer.toString(vendorId));
		getRegistrationPageFirstNameField().sendKeys(RandomStringUtils.random(6));
		getRegistrationPageLastNameField().sendKeys(RandomStringUtils.random(6));
		getRegistrationPagePhoneNoField().sendKeys(RandomStringUtils.randomNumeric(10));
		getRegistrationPageEmailIdField().sendKeys(RandomStringUtils.randomAlphabetic(8)+"@mailinator.com");
		getRegistrationPageCityField().sendKeys(city);
	}
	
	public void clickOnAlreadyHaveAccountLink() {
		getRegistrationPageAlreadyHaveAccountBtn().click();
	}
	
	public void enterPhoneNo(String phoneNo) {
		getRegistrationPageEditMobileNumberField().sendKeys(phoneNo);
	}
	
	public void clickOnSignInBtn() {
		getRegistrationPageSignIntBtn().click();
	}
	
	public void login(String phoneNo) {
		TermsAndConditionsPage termsConditionPage = new TermsAndConditionsPage();
		HomePage homePage = new HomePage();
		termsConditionPage.clickOnAcceptBtn();
		clickOnAlreadyHaveAccountLink();
		enterPhoneNo(phoneNo);
		clickOnSignInBtn();
		homePage.checkIfUserIsOnHomePage();
	}
	
	public void checkIfUserIslogin(String phoneNo) {
		TermsAndConditionsPage termsConditionPage = new TermsAndConditionsPage();
		HomePage homePage = new HomePage();
		Boolean loginFlag = true;
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			termsConditionPage.checkIfAlreadyLogin();
			loginFlag = false;
		} catch (Exception e) {
			System.out.println(e);
		}
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(configProp.getProperty("implicitWait")), TimeUnit.SECONDS);
		if(loginFlag) {
			homePage.checkIfUserIsOnHomePage();
			System.out.println("Already login");
		} else {
			login(phoneNo);
		}
	}
}
