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
import com.qa.hubspot.utilities.ElementUtil;

public class HomePageTest {
	
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	HomePage homepage;
	ElementUtil elementUtil;
	
	@BeforeTest
	public void setup() {
		basepage = new BasePage();
		prop = basepage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basepage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginpage = new LoginPage(driver);
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test
	public void homePageHeaderTest() {
		String header = homepage.getHomePageHeader();
		Assert.assertEquals(header, AppConstants.HOME_PAGE_HEADER,"The Home Page header is incorrect");
	}

	@Test
	public void homePageTitleTest() {
		String title = homepage.getHomePageTitle();
		Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE,"The Home Page title is incorrect");
	}


	@AfterTest
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
