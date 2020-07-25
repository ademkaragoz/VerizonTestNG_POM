package com.qa.verizon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.ApplePage;
import com.qa.verizon.page.HomePage;
import com.qa.verizon.page.SmartphonesPage;

public class ApplePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	SmartphonesPage smartphonesPage;
	ApplePage applePage;
	
	@BeforeTest
	public void setUp() throws InterruptedException{
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		smartphonesPage = homePage.mouseHover();
		applePage = smartphonesPage.selectPhone();
	}

    @Test(priority=1, description="Get page title: ", enabled=true)
	public void verifyApplePageTitle() throws InterruptedException {
	   String title = applePage.getFeaturesPageTitle();
	   System.out.println("Apple phone page title: " + title);
       Assert.assertEquals(title, "New Apple iPhone 11 - 6 Cool Colors & Dual Camera | Best Price");
		//New Apple iPhone 11 - 6 Cool Colors & Dual Camera | Best Price
   }
	
	@Test(priority=2, description="Select Apple phone features", enabled=true)
	public void applePhonePageTest() throws InterruptedException {
		applePage.doFeaturesPhone();
		Thread.sleep(5000);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	
}
