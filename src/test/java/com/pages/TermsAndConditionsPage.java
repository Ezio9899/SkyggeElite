package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class TermsAndConditionsPage extends TestBase{
	@FindBy(xpath = "//*[contains(@resource-id,'id/accept')]")
	WebElement termsAndConditionPageAcceptBtn;
	
	public TermsAndConditionsPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTermsAndConditionPageAcceptBtn() {
		return termsAndConditionPageAcceptBtn;
	}
	
	public void clickOnAcceptBtn() {
		termsAndConditionPageAcceptBtn.click();
	}
	
	public Boolean checkIfAlreadyLogin() {
		return getTermsAndConditionPageAcceptBtn().isDisplayed();
	}
	
}
