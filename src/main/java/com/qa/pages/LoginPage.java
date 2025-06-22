package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.ElementUtil;

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
	
	@FindBy(css="p.oxd-alert-content-text")
	WebElement errorMsg;
	

	
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

	public boolean isErrorMsgDisplayed() {

		return elementUtil.isElementExist(errorMsg);
	}
}
