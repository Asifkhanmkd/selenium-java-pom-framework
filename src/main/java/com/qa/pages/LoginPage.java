package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);

	}

	private By username = By.name("username");
	private By password = By.name("password");
	private By loginButton = By.cssSelector("button.oxd-button.oxd-button");
	private By loginErrorMsg = By.cssSelector("p.oxd-alert-content-text");

	public void enterUsername(String user) {

		elementUtil.doSendKeys(username, user);
	}

	public void enterPassword(String pass) {

		elementUtil.doSendKeys(password, pass);
	}

	public void clickLoginButton() {

		elementUtil.doClick(loginButton);

	}

	public DashboardPage doLogin(String user, String pass) {

		enterUsername(user);
		enterPassword(pass);
		clickLoginButton();

		return new DashboardPage(driver);
	}

	public boolean isErrorMsgDisplayed() {

		return elementUtil.isElementExist(loginErrorMsg);
	}
}
