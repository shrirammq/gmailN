package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement btnAdd = null;

	@FindBy(id = "remove-sauce-labs-backpack")
	private WebElement btnRemove = null;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void addRemove() {
		btnAdd.click();
		btnRemove.click();
	}

}
