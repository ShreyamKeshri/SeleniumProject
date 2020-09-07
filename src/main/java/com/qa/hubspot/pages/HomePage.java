package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.utilities.AppConstants;
import com.qa.hubspot.utilities.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	By header = By.className("dashboard-selector__title");
	By addReport = By.id("add-report");
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	public String getHomePageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.HOME_PAGE_TITLE);
		return elementUtil.doGetTitle();
	}
	
	public String getHomePageHeader() {
		elementUtil.waitForElementPresent(header);
		String pageHeader = elementUtil.doGetText(header);
		return pageHeader;
	}
	
	public boolean checkAddReports() {
		elementUtil.waitForElementPresent(addReport);
		return elementUtil.doIsDisplayed(addReport);
	}
	
}
