package com.qa.tests.e2e;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.LeftMenuPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PIMPage;
import com.qa.utils.ConfigReader;
import com.qa.utils.DataProviderUtil;
import com.qa.utils.ExcelReader;

public class PIMPageTest extends BaseTest {

	@Test(groups = { "e2e" }, dataProvider = "data-provider", dataProviderClass = DataProviderUtil.class)
	public void addNewEmployeeTest(Hashtable<String, String> data) {

		LeftMenuPage leftMenuPage = new LeftMenuPage(driver);
		LoginPage loginPage = new LoginPage(driver);

		//System.out.println("Driver initialized?   " + driver);

		//loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		loginPage.doLogin(ConfigReader.get("username"), ConfigReader.get("password"));

		PIMPage pimPage = leftMenuPage.goToPIM();
		pimPage.clickOnAddbtn();
		pimPage.typeFullName(data.get("fullname"));
		pimPage.typeLastName(data.get("lastname"));
		pimPage.createLoginDetails();
		pimPage.enterUserName(data.get("username"));
		pimPage.enterPassword(data.get("password"));
		pimPage.confirmPassword(data.get("confirmpassword"));
		pimPage.clickOnSaveBtn();
		pimPage.isSuccessfulToasterDisplayed();

		Assert.assertTrue(pimPage.isSuccessfulToasterDisplayed(), "Success toaster was not displayed.");

	}

}