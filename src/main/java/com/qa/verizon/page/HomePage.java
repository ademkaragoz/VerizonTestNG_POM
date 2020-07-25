package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.ElementUtil;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
    // 1.Locators
	By phone = By.xpath("//*[text()='Phones list']");
	By smartPh = By.id("thirdLevel00");
	
	//2.Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//3.Actions 
	public String getHomePageTitle() {
	  elementUtil.waitForTitlePresent("Verizon Wireless, Smartphone Deals & Plans | First to 5G");
	  return elementUtil.doGetPageTitle();
	}

	//this method provide to connect smartPhone page
	public SmartphonesPage mouseHover() throws InterruptedException {
		
		Actions actions = new Actions(driver);
		elementUtil.doclick(phone);
		actions.build().perform();
		Thread.sleep(5000);
		elementUtil.doclick(smartPh);
		actions.click().build().perform();
		Thread.sleep(3000);
		return new SmartphonesPage(driver);
	}
	
	
}
