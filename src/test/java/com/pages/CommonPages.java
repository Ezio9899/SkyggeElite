package com.pages;

import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class CommonPages extends TestBase{
	public CommonPages() {
		PageFactory.initElements(driver, this);
	}
}
