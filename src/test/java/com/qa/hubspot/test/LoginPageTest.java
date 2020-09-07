package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utilities.AppConstants;

public class LoginPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		
	}

	@Test(priority=1)
	public void titleTest() {
		
		String title = loginPage.getPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE,"The title is incorrect");
	}
	
	@Test(priority=2)
	public void loginTest() {
		HomePage homepage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		String header = homepage.getHomePageHeader();
		Assert.assertEquals(header, AppConstants.HOME_PAGE_HEADER, "The HomePage header is incorrect");
	}
	
	
	@AfterTest
	public void tearDown() {
		if(driver!=null) {
		driver.quit();
		}
	}
}
