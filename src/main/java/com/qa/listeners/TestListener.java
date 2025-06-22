package com.qa.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.driver.DriverFactory;
import com.qa.utils.ExtentReportManager;
import com.qa.utils.ScreenshotUtils;

public class TestListener implements ITestListener {
	@Override
	public void onStart(ITestContext context) {
      ExtentReportManager.initReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
     ExtentReportManager.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
     ExtentReportManager.getTest().pass("Test Passed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReportManager.getTest().fail(result.getThrowable());
		String testName = result.getName();

		// Object testObject = result.getInstance(); // testObject here is the actual
		// testclass i.e. LoginTest class
		// WebDriver driver=((BaseTest)testObject).driver;

		WebDriver driver = DriverFactory.getDriver();
		//System.out.println("Driver in TestListener is " + driver);

		String screenshotPath= ScreenshotUtils.captureScreenshot(driver, testName);
		
		ExtentReportManager.getTest().fail("Test Failed",
			    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		
	    //ExtentReportManager.getTest().addScreenCaptureFromPath(screenshotPath);
	    
		//ExtentReportManager.getTest().fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	
	}	
				
				public void onFinish(ITestContext context) {
     ExtentReportManager.flushReport();
	}
}
