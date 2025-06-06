package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.utils.ElementUtil;

public class DashboardPage {

	private  WebDriver driver;
	private  ElementUtil elementUtil;
	
	
	public By my_ActionElement= By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");

	public DashboardPage(WebDriver driver) {

		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);

	}
	
	public boolean  IsTheDashboardHeaderVisiblen() {
		
		return elementUtil.isElementExist(my_ActionElement);
		
		
	}

}