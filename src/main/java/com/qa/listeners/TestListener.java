package com.qa.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.base.BaseTest;
import com.qa.utils.ScreenshotUtils;


public class TestListener implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		String testName =result.getName();
		
		Object testObject = result.getInstance();  // testObject here is the actual testclass i.e. LoginTest class
		WebDriver driver=((BaseTest)testObject).driver;
		ScreenshotUtils.captureScreenshot(driver, testName);
	
	}
}
