package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PIMPage extends BasePage {

	public PIMPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement EmployeeAddButn;

	@FindBy(name = "firstName")
	WebElement firstNameInputField;

	@FindBy(name = "lastName")
	WebElement lastNameInputField;

	@FindBy(xpath = "//button[normalize-space()='Save']") 
	WebElement saveBtn;
	
	@FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']") 
	WebElement createLoginDetailsToggle;
	
	
	@FindBy(xpath = "//div[@class='oxd-form-row'][2]//input") 
	WebElement usernameField;
	
	@FindBy(xpath = "//div[@class='oxd-form-row user-password-row']/div/div/div/div[2]/input") 
	WebElement passwordField;
	
	@FindBy(xpath = "//div[@class='oxd-form-row user-password-row']/div/div[2]/div/div[2]/input") 
	WebElement confirmPasswordField;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	WebElement Toaster;

	public void clickOnAddbtn() {

		elementUtil.doClick(EmployeeAddButn);
	}

	public void typeFullName(String fullName) {

		elementUtil.doSendKeys(firstNameInputField, fullName);
	}

	public void typeLastName(String lastName) {

		elementUtil.doSendKeys(lastNameInputField, lastName);
	}
	
	public void createLoginDetails() {
		
		elementUtil.doClick(createLoginDetailsToggle);
		
	}
	
	public void enterUserName(String username) {
		elementUtil.doSendKeys(usernameField, username);
		
	}
	
	public void enterPassword(String password) {
		elementUtil.doSendKeys(passwordField, password);
		
	}
	
	public void confirmPassword(String confirmPswd) {
		elementUtil.doSendKeys(confirmPasswordField, confirmPswd);
		
	}
	
public void clickOnSaveBtn() {
		
		elementUtil.doClick(saveBtn);
}

public boolean isSuccessfulToasterDisplayed() {
	return elementUtil.isElementExist(Toaster);

}
}