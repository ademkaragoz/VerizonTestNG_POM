package com.qa.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;

public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
	}
	
	@Test(priority=1, description="Get page title as Verizon Wireless, Smartphone Deals & Plans | First to 5G")
	public void verifyHomePageTitleTest() throws InterruptedException {
		Thread.sleep(5000);
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is " + title);
        Assert.assertEquals(title, "Verizon Wireless, Smartphone Deals & Plans | First to 5G");
	}             
	
	@Test(priority=2, description="Correct Home Page")
	public void mouseHoverTest() throws InterruptedException {
		homePage.mouseHover();
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	

}
