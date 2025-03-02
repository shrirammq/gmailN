package com.automation.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.helper.ExcelHelper;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.LogoutPage;

public class TC_003_AddRemoveCart extends FrameworkScript {

	@DataProvider(name = "getTestdata")
	public String[][] getTestdata() throws Exception {
		return ExcelHelper.getTestdata("E:\\Testdata.xlsx","Sheet1");
	}
	
	@Test(dataProvider = "getTestdata")
	public void addRemoveCart(String userName,String password) throws Exception {

		// Login
		driver.get("https://www.saucedemo.com/");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName, password);

		// Add & Remove
		HomePage homePage = new HomePage(driver);
		homePage.addRemove();

		// Logout

		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.logout();

	}

}
