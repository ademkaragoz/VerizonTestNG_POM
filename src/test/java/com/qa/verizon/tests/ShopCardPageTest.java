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
import com.qa.verizon.page.ShopCardPage;
import com.qa.verizon.page.SmartphonesPage;

public class ShopCardPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	SmartphonesPage smartphonesPage;
	ApplePage applePage;
	ShopCardPage shopCardPage;

	@BeforeTest
	public void SetUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		smartphonesPage = homePage.mouseHover();
		applePage = smartphonesPage.selectPhone();
		shopCardPage = applePage.doFeaturesPhone();
  }
	@Test(priority=1, description="Page title is Verizon | Customize your Device")
	public void verifyCustomizeYourDeviceTitle(){
		String title1 =shopCardPage.getCustomizeYourDeviceTitle();
		System.out.println(title1);
		Assert.assertEquals(title1, "Verizon | Customize your Device");
  }
    @Test(priority=2, description="Finel page:: Shopping card page")
	 public void ShoppingCardPageTest() {
		shopCardPage.doShoppingCard();	
 }
     @Test(priority=3, description="Page title is Verizon | Shopping Cart")
   	public void verifyShoppingCardPageTitle()  {
   		String title2 = shopCardPage.getShoppingCardPageTitle();
   		System.out.println(title2);
   		Assert.assertEquals(title2, "Verizon | Shopping Cart");
   }
    
  @AfterTest
  public void tearDown() {
	  driver.quit();
  }
    
    
  	
}
