package com.qa.verizon.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.verizon.util.ElementUtil;

public class ShopCardPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//1.Locator
	By noThanks = By.xpath("//div[@id='none']");
	By nextButton1 = By.xpath("//button[@aria-label='Next']");
	By nextButton2 = By.id("deviceProtectionBtn");
	By declineDevice1 = By.id("declineDeviceSelectProtecionBtn");
	By declineDevice2 = By.xpath("//button[@class='secondary button cancelProtectionButton']");
	By selectPlan = By.xpath("//button[@id='\"select-plan-list-view-26907']");
	By checkOut = By.xpath("//h1[text()='Continue to checkout.']");
	By verifyPhone = By.xpath("//h3/span[contains(text(),'iPhone 11')]");
	
    //2.Constructor
    public ShopCardPage(WebDriver driver) {
    	this.driver = driver;
    	elementUtil = new ElementUtil(driver);
   }
    
     //3.Actions
     public String getCustomizeYourDeviceTitle(){
    	WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Verizon | Customize your Device"));
	    return elementUtil.doGetPageTitle();
   }
     
     public String getShoppingCardPageTitle(){
    	try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.titleContains("Verizon | Shopping Cart"));
		  } catch (TimeoutException e) {
			e.printStackTrace();
		}
		   return elementUtil.doGetPageTitle();
	}
     
     public void doShoppingCard()  {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        elementUtil.doclick(noThanks);
        elementUtil.doclick(nextButton1);
		elementUtil.doclick(nextButton2);
	    elementUtil.doclick(declineDevice1);
	    elementUtil.doclick(declineDevice2);
	    elementUtil.doclick(selectPlan);
	    System.out.println(elementUtil.doGetText(checkOut));
		System.out.println(elementUtil.doGetText(verifyPhone));
	}
   
 }


