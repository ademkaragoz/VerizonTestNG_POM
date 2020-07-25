package com.qa.verizon.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	/**
	 * Title wait method
	 * @param title
	 * @return
	 */
	public boolean waitForTitlePresent(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	
	}

	/**
	 * wait element
	 * @param locator
	 * @return
	 */
	public boolean waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}
	/**
	 * Visibility element
	 * @param locator
	 * @return
	 */
	public boolean waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}
	
	/**
	 * get title
	 * @return
	 */
	public String doGetPageTitle() {
		try {                          // if it has any problem I need to catch
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception occured while getting the title....");
		}
		return null;
	}
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception occured while getting the element....");
		}
		return element;
	}
	
	public void doclick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception occured while clicking the element....");
		}
	}
	
	public void doSendKeys(By locator, String value) {
		try {
			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception occured while getting the element....");
		}
	}
	
	public boolean doIsDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception occured for isDisplayed....");
		}
		return false;
	}
	
	public boolean doIsSelected(By locator) {
		try {
			return getElement(locator).isSelected();
		} catch (Exception e) {
			System.out.println("some exception occured for isSelected....");
		}
		return false;
	}
	
	public boolean doIsEnabled(By locator) {
		try {
			return getElement(locator).isEnabled();
		} catch (Exception e) {
			System.out.println("some exception occured for isEnabled....");
		}
		return false;
	}
	
	public String doGetText(By locator) {
		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception occured while getting text from page....");
		}
		return null;
	}
	
	// we can add how over method
	// we can add drop down method....
	
	
	
	
	

}
