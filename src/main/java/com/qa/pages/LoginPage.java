package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {

		super(driver);
	}
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
    WebElement password; 
	
	@FindBy(css="button.oxd-button.oxd-button")
	WebElement loginbtn;
	
	//@FindBy(css="p.oxd-alert-content-text")
	//WebElement errorMsg;
	
	@FindBy(css=".this-class-does-not-exist-anywhere")
	WebElement errorMessage;

	
		public void enterUsername(String user) {

		elementUtil.doSendKeys(username, user);
	}

	public void enterPassword(String pass) {

		elementUtil.doSendKeys(password, pass);
	}

	public void clickLoginButton() {

		elementUtil.doClick(loginbtn);

	}

	public DashboardPage doLogin(String user, String pass) {

		enterUsername(user);
		enterPassword(pass);
		clickLoginButton();

		return new DashboardPage(driver);
	}

	/*public boolean isErrorMsgDisplayed() {

		return elementUtil.isElementExist(errorMsg);
	}*/
	
	/*public boolean doesEleExist() {

		return elementUtil.isElementExist(errorMessage);
	}*/
	
	/*public boolean doesEleExist() {
	    try {
	        // Use explicit wait with ExpectedConditions.presenceOfElementLocated
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	        wait.until(ExpectedConditions.presenceOfElementLocated(
	            By.cssSelector(".this-class-does-not-exist-anywhere")));
	        return true;
	    } catch (TimeoutException e) {
	        return false;
	    }
	}*/
public boolean doesEleExist() {
    return !driver.findElements(By.cssSelector(".this-class-does-not-exist-anywhere")).isEmpty();
}
}






