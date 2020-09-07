package com.qa.hubspot.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIME_OUT);
	}
	
	public boolean waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}
	
	public boolean waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}

	public boolean waitForTitlePresent(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}
	
	
	public String doGetTitle() {
		try {
			return driver.getTitle();
		}catch(Exception e){
			System.out.println("Some exception occurred while fetching the title of the page.");
			e.printStackTrace();
		}
		return null;
	}
	
	public WebElement doGetElement(By locator) {
	
		WebElement element = null;
		try {
		element = driver.findElement(locator);
	}catch(Exception e) {
		System.out.println("Some exception occurred while creating element....");
		e.printStackTrace();
	}
		return element;
	}

	public void doClick(By locator) {
		try {
			driver.findElement(locator).click();
		}catch(Exception e) {
			System.out.println("Some exception occurred while clicking on the web element");
			e.printStackTrace();
		}
	}
	
	public void doSendKeys(By locator, String value) {
		try {
			WebElement ele = driver.findElement(locator);
			ele.clear();
			ele.sendKeys(value);
		}catch(Exception e) {	
			System.out.println("Some exception occurred while entering the value in the text field");
			e.printStackTrace();
		}
	}
	
	public boolean doIsDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}catch(Exception e) {
			System.out.println("Some exception occurred while displaying the field");
			e.printStackTrace();
		}
		return false;
	}
	
	public String doGetText(By locator) {
		try {
			return driver.findElement(locator).getText();
		}catch(Exception e) {
			System.out.println("Some exception occurred while getting text of the Web Element");
			e.printStackTrace();
		}
		return null;
	}


}