package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;


public class LoginTest extends BaseTest {
	
	
	
	
	@Test(groups= {"e2e"},priority=1)
	public void loginTest() {
		
		LoginPage loginPage= new LoginPage(driver);	
		
		//driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		String uname=prop.getProperty("username");
		String pass=prop.getProperty("password");
		
		DashboardPage dashboardPage =loginPage.doLogin(uname, pass);
		
		 Assert.assertTrue(dashboardPage.IsTheDashboardHeaderVisiblen(), "Login failed — Dashboard header not visible"); 
		
        
	}
	
	@Test(priority=2)
	public void invalidLoginTest() {
		LoginPage loginPage=new LoginPage(driver);
		
		//loginPage.doLogin("invaliduser", "InvalidPass");
		
		loginPage.doLogin("Admin", "admin123");
		
		Assert.assertTrue(loginPage.isErrorMsgDisplayed(), "Error message not displayed — negative login test failed");
	}

}
