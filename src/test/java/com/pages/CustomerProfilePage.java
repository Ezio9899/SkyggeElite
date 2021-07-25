package com.pages;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.utils.AndroidUtils;

public class CustomerProfilePage extends TestBase {
	
	@FindBy(xpath = "//*[@class='android.widget.ImageButton']")
	WebElement plusIconBtn;
	@FindBy(xpath = "//*[contains(@resource-id,'id/editcustpro')]")
	WebElement editCustomerDetailsBtn;
	@FindBy(xpath = "//*[contains(@resource-id,'id/outletname')]")
	WebElement outletNameField;
	@FindBy(xpath = "//*[contains(@resource-id,'id/outletdistributorname')]")
	WebElement outletDistributorNameDropdown;
	@FindBy(xpath = "//*[contains(@resource-id,'id/routename')]")
	WebElement routeNameField;
	@FindBy(xpath = "//*[contains(@resource-id,'id/outlettype')]")
	WebElement outletTypeDropdown;
	@FindBy(xpath = "//*[contains(@resource-id,'id/outletsubtype')]")
	WebElement outletSubTypeDropdown;
	@FindBy(xpath = "//*[contains(@resource-id,'id/outletaddress')]")
	WebElement outletAddressField;
	@FindBy(xpath = "//*[@class='android.widget.CheckedTextView']")
	List<WebElement> dropdownOptions;
	@FindBy(xpath = "//*[contains(@resource-id,'id/newLeadupdate')]")
	WebElement saveBtn;
	
	public List<WebElement> getDropdownOptions() {
		return dropdownOptions;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public CustomerProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOutletNameField() {
		return outletNameField;
	}

	public WebElement getOutletDistributorNameDropdown() {
		return outletDistributorNameDropdown;
	}

	public WebElement getRouteNameField() {
		return routeNameField;
	}

	public WebElement getOutletTypeDropdown() {
		return outletTypeDropdown;
	}

	public WebElement getOutletSubTypeDropdown() {
		return outletSubTypeDropdown;
	}

	public WebElement getOutletAddressField() {
		return outletAddressField;
	}
	
	public WebElement getPlusIconBtn() {
		return plusIconBtn;
	}

	public WebElement getEditCustomerDetailsBtn() {
		return editCustomerDetailsBtn;
	}
	
	public void clickOnPlusIcon() {
		getPlusIconBtn().click();
	}
	
	public void clickOnEditCustomerProfile() {
		getEditCustomerDetailsBtn().click();
	}
	
	public void fillOutletDetails() {
		getOutletNameField().sendKeys(RandomStringUtils.randomAlphabetic(8));
		//getRouteNameField().sendKeys(RandomStringUtils.randomAlphabetic(10));
		getOutletAddressField().sendKeys(RandomStringUtils.randomAlphabetic(12));
	}
	
	public void clickOnSaveBtn() {
		AndroidUtils andUtils = new AndroidUtils();
		andUtils.scroll(getSaveBtn());
	}
}
