package com.qa.verizon.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.util.ElementUtil;

public class ApplePage {
	
	WebDriver driver;
	ElementUtil elementUtil;

	//1.Locators
    By phoneColor = By.xpath("//div[@style='background-color: rgb(0, 0, 0);']");
	By phoneMemory = By.xpath("//p[contains(text(),'256GB')]");
	By retailPrice = By.xpath("//span[@class='tntPrice-2']");
	By continuePhone  = By.id("ATC-Btn");
	By zipCode = By.id("zipcode");
	By confirmLocation = By.xpath("//*[text()='Confirm Location']");
	By newCustomer = By.xpath("//*[text()='New Customer']");

    //2.Constructor
	public ApplePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
     //3.Actions
	public String getFeaturesPageTitle() {
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.titleContains("New Apple iPhone 11 - 6 Cool Colors & Dual Camera | Best Price"));
	  //elementUtil.waitForTitlePresent("New Apple iPhone 11 - 6 Cool Colors & Dual Camera | Best Price");
	  return elementUtil.doGetPageTitle();
	}

    public ShopCardPage doFeaturesPhone() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		elementUtil.doclick(phoneColor);
		elementUtil.doclick(phoneMemory);
		elementUtil.doclick(retailPrice);
		elementUtil.doclick(continuePhone);
	    elementUtil.doSendKeys(zipCode, "13088");
		elementUtil.doclick(confirmLocation);
		elementUtil.doclick(newCustomer);
        return new ShopCardPage(driver);
   }
	
}
