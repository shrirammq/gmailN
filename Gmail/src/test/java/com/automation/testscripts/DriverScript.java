package com.automation.testscripts;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.core.FrameworkScript;
import com.automation.helper.ExcelHelper;

public class DriverScript extends FrameworkScript {

	@DataProvider(name = "getTestdata")
	public String[][] getTestdata() throws Exception {
		return ExcelHelper.getTestdata("E:\\Keyworddriven.xlsx", "Sheet2");
	}

	@Test(dataProvider = "getTestdata")
	public void execute(String tcName, String description, String action, String properties, String data) {

		WebElement element = null;

		// Find Element
		if (ObjectUtils.isNotEmpty(properties)) {

			String locatorType = properties.split("=")[0];
			String locatorValue = properties.split("=")[1];

			switch (locatorType) {
			case "id":
				element = driver.findElement(By.id(locatorValue));
				break;
			case "name":
				element = driver.findElement(By.name(locatorValue));
				break;
			case "className":
				element = driver.findElement(By.className(locatorValue));
				break;
			case "tagName":
				element = driver.findElement(By.tagName(locatorValue));
				break;
			case "xpath":
				element = driver.findElement(By.xpath(locatorValue));
				break;
			case "cssSelector":
				element = driver.findElement(By.cssSelector(locatorValue));
				break;
			}

		}

		// Action

		switch (action) {
		case "visit":
			driver.get(data);
			break;
		case "setValue":
			element.sendKeys(data);
			break;
		case "click":
			element.click();
			break;
		case "doubleClick":
			Actions actions = new Actions(driver);
			actions.doubleClick(element).perform();
			break;
		
		}

	}

}
