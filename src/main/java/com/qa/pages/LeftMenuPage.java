package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.ElementUtil;

public class LeftMenuPage extends BasePage {


	public LeftMenuPage (WebDriver driver) {

		super(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='Admin']")////a[@class='oxd-main-menu-item active']/span
	WebElement adminMenuItem;

	@FindBy(xpath="//span[normalize-space()='PIM']")
	WebElement pimMenuItem;

	@FindBy(xpath = "//span[normalize-space()='My Info']")
	WebElement myInfoMenuItem;

	public AdminPage goToAdmin() {

		elementUtil.doClick(adminMenuItem);
		return new AdminPage(driver);
	}

	public PIMPage goToPIM() {
		elementUtil.doClick(pimMenuItem);
		return new PIMPage(driver);
	}

	public MyInfoPage goToMyinfo() {
		elementUtil.doClick(myInfoMenuItem);
		return new MyInfoPage(driver);
	}

}
