package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.utilities.AppConstants;
import com.qa.hubspot.utilities.ElementUtil;


public class ContactsPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	By addContacts = By.xpath("//button[@class='uiButton private-button private-button--primary private-button--default add-obj private-button--non-link']"); 
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	By phoneNumber = By.xpath("//input[@data-field='phone']");
	By createContactButton =  By.xpath("(//button[@type='button']//span[text()='Create contact'])[position()=2]");
	By backToContactsPage = By.xpath("(//i18n-string[@data-key='profileHeader.backButton.CONTACT'])[2]");
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getTitle() {
		elementUtil.waitForTitlePresent(AppConstants.CONTACT_PAGE_TITLE);
		return elementUtil.doGetTitle();
	}
	
	public void addContacts(String EM, String FN, String LN, String titleOfJob, String phoneNo) {
		elementUtil.waitForElementPresent(addContacts);
		elementUtil.doClick(addContacts);
		
		elementUtil.waitForElementPresent(email);
		elementUtil.doSendKeys(email, EM);
		elementUtil.waitForElementPresent(firstName);
		elementUtil.doSendKeys(firstName, FN);
		elementUtil.waitForElementPresent(lastName);
		elementUtil.doSendKeys(lastName, LN);
		elementUtil.waitForElementPresent(jobTitle);
		elementUtil.doSendKeys(jobTitle, titleOfJob);
		elementUtil.waitForElementPresent(phoneNumber);
		elementUtil.doSendKeys(phoneNumber, phoneNo);
		elementUtil.waitForElementVisible(createContactButton);
		elementUtil.doClick(createContactButton);
		elementUtil.waitForElementPresent(backToContactsPage);
		elementUtil.doClick(backToContactsPage);
		
	}
	

}
