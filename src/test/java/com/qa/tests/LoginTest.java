package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.utils.ConfigReader;


public class LoginTest extends BaseTest {
	
	
	
	
	@Test(groups= {"e2e"},priority=1)
	public void loginTest() {
		
		LoginPage loginPage= new LoginPage(driver);	
		
		//driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		String uname=ConfigReader.get("username");
		String pass=ConfigReader.get("password"); 
		
		DashboardPage dashboardPage =loginPage.doLogin(uname, pass);
		
		 Assert.assertTrue(dashboardPage.IsTheDashboardHeaderVisiblen(), "Login failed — Dashboard header not visible"); 
		
        
	}
	
	
	
	@Test (priority=1)
	public void invalidLoginTest() {
		
		System.out.println("============================ Running invalidLoginTest attempt ===");
	    
		LoginPage loginPage=new LoginPage(driver);
		
		//loginPage.doLogin("invaliduser", "InvalidPass");
		
		loginPage.doLogin("Admin", "admin123");
		boolean exists = loginPage.doesEleExist();
		
		System.out.println("****************************************Element exists? " + exists);
         
		 Assert.assertTrue(exists, "Error message not displayed — negative login test failed");
		
		
		
	}

}
