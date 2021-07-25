package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class HomePage extends TestBase{
	@FindBy(xpath = "//*[contains(@resource-id,'id/dashbordmenugrid')]")
	WebElement homePageDashboard;
	
	@FindBy(xpath = "//*[contains(@resource-id,'id/idMenuTitle') and contains(@text,'Customer Profile')]")
	WebElement customerProfileBtn;
	
	public WebElement getCustomerProfileBtn() {
		return customerProfileBtn;
	}

	public WebElement getHomePageDashboard() {
		return homePageDashboard;
	}
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean checkIfUserIsOnHomePage() {
		return getHomePageDashboard().isDisplayed();
	}
	
	public void clickOnCustomerProfile() {
		getCustomerProfileBtn().click();
	}
}
