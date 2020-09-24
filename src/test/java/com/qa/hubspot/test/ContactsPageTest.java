package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utilities.AppConstants;
import com.qa.hubspot.utilities.ElementUtil;
import com.qa.hubspot.utilities.ExcelUtil;

public class ContactsPageTest {

	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	HomePage homepage;
	ElementUtil elementUtil;
	ContactsPage contactspage;
	
	@BeforeTest
	public void setup() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basepage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.navigateToContactsPage();
	}

	@Test(priority=1)
	public void contactsPageTitleTest() {
		String title = contactspage.getTitle();
		Assert.assertEquals(title, AppConstants.CONTACT_PAGE_TITLE,"The Contacts Page title is incorrect");
	}

	@DataProvider
	public Object[][]  getTestData() {
		Object[][] data = ExcelUtil.getTestData(AppConstants.SHEET_NAME);
		return data;
	}
	
	@Test(priority=2, dataProvider="getTestData")
	public void verifyCreateNewContacts(String EM, String FN, String LN, String titleOfJob, String phoneNo) {
		contactspage.addContacts(EM, FN, LN, titleOfJob, phoneNo);
	}
	
	@AfterTest
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

	
}
