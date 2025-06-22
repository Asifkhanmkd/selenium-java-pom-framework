package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.ElementUtil;

public class BasePage {

	
	protected WebDriver driver;
	protected ElementUtil elementUtil;
	
	public BasePage(WebDriver driver) {
	this.driver=driver;
	elementUtil= new ElementUtil(driver);
	PageFactory.initElements(driver, this);
}

	
	
}