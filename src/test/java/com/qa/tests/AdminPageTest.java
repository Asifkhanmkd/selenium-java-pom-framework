package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.AdminPage;
import com.qa.pages.LeftMenuPage;
import com.qa.pages.LoginPage;

public class AdminPageTest extends BaseTest {
	
	@Test
	public void verifyAddUserFormLoadsSuccessfully () {
		
		LeftMenuPage leftManuPage= new LeftMenuPage(driver);
		LoginPage loginPage= new LoginPage(driver);
		
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
		
		AdminPage adminPage=leftManuPage.goToAdmin();
		//System.out.println("Admin menu Clicked");
		adminPage.clickOnAddbtn();
		adminPage.selectRole();
		//System.out.println("Role Selected");
		adminPage.selectStatus();
		adminPage.typeEmployeeName("Ravi");
		
		adminPage.typeUsename("Matt123");
		adminPage.typePassword("P@kist@n47");
		adminPage.confirmPassword("P@kist@n47");
		adminPage.clickOnSaveBtn();
		adminPage.isSuccessfulToasterDisplayed();
		
		
	}

}
