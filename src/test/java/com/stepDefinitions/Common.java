package com.stepDefinitions;

import com.pages.CommonPages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class Common {
	private CommonPages commonPage = new CommonPages();
	
	@Given("user opens the app")
	public void openApp() {
		System.out.println("App is open");
	}

}
