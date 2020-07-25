package com.qa.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.SmartphonesPage;

public class SmartphonesPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	SmartphonesPage smartphonesPage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName =prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		smartphonesPage = homePage.mouseHover();
		Thread.sleep(5000);
	}
	@Test(priority=1, description="Get Home Page title ", enabled=false)
	public void veriftHomePageTitleTest() {
		String title =homePage.getHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Verizon Wireless, Smartphone Deals & Plans | First to 5G");
	}
	
	@Test(priority=2, description="Get page title as Smartphones - Buy The Newest Cell Phones | Verizon Wireless")
	public void verifySmartPhonePageTitle(){
		String title = smartphonesPage.getSmartPhonePageTitle();
		System.out.println("Smartphones page title is ;" + title);
		Assert.assertEquals(title, "Smartphones - Buy The Newest Cell Phones | Verizon Wireless");
	}
	
	@Test(priority=3, description="Select Apple iPhone 11")
	public void selectPhonesTest() throws InterruptedException {
		smartphonesPage.selectPhone();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}	
	





	
	
	
	
	
	
	
	
	
	
	
	


