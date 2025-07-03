package com.qa.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getElementWhenVisible(By locator) {

		return waitforElementVisibility(locator, 10);
	}
	
	
	public WebElement getElementWhenClickable(By locator) {

		return waitforElementClickability(locator, 10);
	}

	public void doSendKeys(By locator, String value) {

		getElementWhenVisible(locator).sendKeys(value);
	}

	public void doClick(By locator) {

		getElementWhenVisible(locator).click();

	}
	
	public String getText(By locator) {
		return getElementWhenVisible(locator).getText();
    }

	public boolean isElementExist(By locator) {

		try {

			return getElementWhenVisible(locator).isDisplayed();

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public WebElement waitforElementVisibility(By locator, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement waitforElementClickability(By locator, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    return wait.until(ExpectedConditions.elementToBeClickable(locator));
	
	}
	// Overloaded methods to accept WebElements from PageClasses using PageFactory approach
	
	public WebElement getElementWhenVisible(WebElement element) {

		return waitforElementVisibility(element, 10);
	}

	public void doSendKeys(WebElement element, String value) {

		getElementWhenVisible(element).sendKeys(value);
	}

	public void doClick(WebElement element) {

		getElementWhenVisible(element).click();

	}
	
	public String getText(WebElement element) {
		return getElementWhenVisible(element).getText();
    }

	/*public boolean isElementExist(WebElement element) {

		try {

			return getElementWhenVisible(element).isDisplayed();

		} catch (NoSuchElementException e) {

			return false;

		}

		}*/
	
	public boolean isElementExist(WebElement element) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOf(element));
	        return element.isDisplayed();
	    } catch (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
	        return false;
	    }
	}

	
	
	public WebElement waitforElementVisibility(WebElement element, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	
	public WebElement waitforElementClickability(WebElement element, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	

}
