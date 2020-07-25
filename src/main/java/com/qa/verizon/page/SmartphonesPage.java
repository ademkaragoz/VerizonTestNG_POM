package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.util.ElementUtil;

public class SmartphonesPage {

	WebDriver driver;
	ElementUtil elementUtil;  
	
	//1.Locators
	By selectPh = By.xpath("//*[text()='iPhone 11']");
	
	//2.Constructor
	public SmartphonesPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//3.Actions
	public String getHomePageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Verizon Wireless, Smartphone Deals & Plans | First to 5G"));
		return elementUtil.doGetPageTitle();
	}
	
	public String getSmartPhonePageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.titleContains("Smartphones - Buy The Newest Cell Phones | Verizon Wireless"));
        return elementUtil.doGetPageTitle();
	}

	public ApplePage selectPhone() throws InterruptedException {
		elementUtil.doclick(selectPh);
		Thread.sleep(3000);
		return new ApplePage(driver);
		
	}
	
	
}
