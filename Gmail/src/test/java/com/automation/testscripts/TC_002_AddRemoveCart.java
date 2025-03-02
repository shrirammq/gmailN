package com.automation.testscripts;

import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.LogoutPage;

public class TC_002_AddRemoveCart extends FrameworkScript {

	@Test
	public void addRemoveCart() throws Exception {

		// Login
		driver.get("https://www.saucedemo.com/");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");

		// Add & Remove
		HomePage homePage = new HomePage(driver);
		homePage.addRemove();

		// Logout

		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.logout();

	}

}
