package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
	
	super(driver);
	
	}

	@FindBy(css = "h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")
	WebElement DashboardHeader;

	public boolean IsTheDashboardHeaderVisiblen() {

		return elementUtil.isElementExist(DashboardHeader);

	}

}