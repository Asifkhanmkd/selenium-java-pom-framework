package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.ElementUtil;

public class AdminPage extends BasePage {

	public AdminPage(WebDriver driver) {
		
		super(driver);
	}

	@FindBy(xpath = "//div[@class='orangehrm-paper-container']/div/button")
	WebElement addbtn;

	@FindBy(xpath = "//div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[1]/div/div[2]/div")
	WebElement selectRoleDropDown;

	@FindBy(xpath = "//div[@role='listbox']//span[text()='Admin']")
	WebElement selectRole;

	@FindBy(xpath = "//div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[3]/div/div[2]/div")
	WebElement selectStatusropDown;

	@FindBy(xpath = "//div[@role='listbox']//span[text()='Enabled']")  
	WebElement selectStatus;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement empNameField;

	@FindBy(xpath = "//div[@role='listbox']//span[text()='Ravi M B']")
	WebElement empFullName;
	
	//@FindBy(xpath = "//span[normalize-space()='Ravi M B']")
	//WebElement empFullName;

	
	@FindBy(xpath = "//div[@class='oxd-grid-2 orangehrm-full-width-grid']/div[4]/div/div[2]/input")
	WebElement adminUserName;

	@FindBy(xpath = "//div[@class='oxd-form-row user-password-row']/div/div[1]/div/div[2]/input")
	WebElement passField;

	@FindBy(xpath = "//div[@class='oxd-form-row user-password-row']/div/div[2]/div/div[2]/input")
	WebElement confirmPassField;

	@FindBy(xpath = "//div[@class='oxd-form-actions']/button[2]")
	WebElement saveBtn;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	WebElement Toaster;

	@FindBy(xpath = "//label[normalize-space()='User Role']")
	WebElement userLabel;

	public void selectTheName() {

		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
	}

	public void clickOnAddbtn() {
		elementUtil.doClick(addbtn);

	}

	public void selectRole() {

		elementUtil.doClick(selectStatusropDown);

		elementUtil.doClick(selectStatus);
	}

	public void selectStatus() {

		elementUtil.doClick(selectRoleDropDown);

		elementUtil.doClick(selectRole);
	}

	public void typeEmployeeName(String empName) {
		elementUtil.doSendKeys(empNameField, empName);
		
		elementUtil.doClick(empFullName);
		
		System.out.println("Employee name clicked.....................");
		
	}

	public void typeUsename(String userName) {
		elementUtil.doSendKeys(adminUserName, userName);
	}

	public void typePassword(String password) {
		elementUtil.doSendKeys(passField, password);
	}

	public void confirmPassword(String password) {
		elementUtil.doSendKeys(confirmPassField, password);
	}

	public void clickOnSaveBtn() {

		elementUtil.doClick(saveBtn);
	}

	public boolean isSuccessfulToasterDisplayed() {
		return elementUtil.isElementExist(Toaster);

	}

}