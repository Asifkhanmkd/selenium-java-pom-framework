package com.qa.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.driver.DriverFactory;
import com.qa.utils.ConfigReader;
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
		String browser = ConfigReader.get("browser");
		String env = ConfigReader.get("env");
		ExtentReportManager.getTest().assignCategory(browser + " | " + env);

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
		// System.out.println("Driver in TestListener is " + driver);

		try {
			String screenshotPath = ScreenshotUtils.captureScreenshot(driver, testName);

			ExtentReportManager.getTest().fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} catch (RuntimeException e) {

			ExtentReportManager.getTest().warning("Screenshot not captured: " + e.getMessage());

			// ExtentReportManager.getTest().log(Status.WARNING, "Screenshot not captured: "
			// + e.getMessage());

		}

	}

	public void onFinish(ITestContext context) {
		ExtentReportManager.flushReport();
	}
}
