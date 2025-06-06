package com.qa.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getElement(By locator) {

		return waitforElementVisibility(locator, 10);
	}

	public void doSendKeys(By locator, String value) {

		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {

		getElement(locator).click();

	}

	public boolean isElementExist(By locator) {

		try {

			return getElement(locator).isDisplayed();

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public WebElement waitforElementVisibility(By locator, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
