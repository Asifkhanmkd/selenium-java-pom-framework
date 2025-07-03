package com.qa.listeners;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.driver.DriverFactory;
import com.qa.utils.ConfigReader;
import com.qa.utils.ExtentReportManager;
import com.qa.utils.RetryAnalyzer;
import com.qa.utils.ScreenshotUtils;

public class TestListener implements ITestListener {
	@Override
	public void onStart(ITestContext context) {
		ExtentReportManager.initReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		/*ExtentReportManager.createTest(result.getMethod().getMethodName());
		String browser = ConfigReader.get("browser");
		String env = ConfigReader.get("env");
		ExtentReportManager.getTest().assignCategory(browser + " | " + env);*/

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = getReadableTestName(result);

	    ExtentTest test = ExtentReportManager.createTest(testName); // ✅ ensure test node is created
	    String browser = ConfigReader.get("browser");
	    String env = ConfigReader.get("env");
	    test.assignCategory(browser + " | " + env);

	    int attempts = RetryAnalyzer.getRetryCount(result);
	    if (attempts > 0) {
	        test.pass("✅ Test passed after " + (attempts + 1) + " attempts");
	        test.info("⚠️ Flaky test — passed after retry");
	    } else {
	        test.pass("✅ Test passed on first attempt");
	    }

	}	


		
		
		
		
		
		
		

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
		

		// Object testObject = result.getInstance(); // testObject here is the actual
		// testclass i.e. LoginTest class
		// WebDriver driver=((BaseTest)testObject).driver;
		
		
		
		String testName = getReadableTestName(result);

	    ExtentTest test = ExtentReportManager.createTest(testName); // ✅ ensure test node is created
	    String browser = ConfigReader.get("browser");
	    String env = ConfigReader.get("env");
	    test.assignCategory(browser + " | " + env);

	    int attempts = RetryAnalyzer.getRetryCount(result);
	    int totalAttempts = attempts + 1;

	    test.fail("❌ Test failed after " + totalAttempts + " attempts");
	

WebDriver driver = DriverFactory.getDriver();

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
	
	
	
	
	
	private String getReadableTestName(ITestResult result) {
        String baseName = result.getMethod().getMethodName();
        Object[] params = result.getParameters();
        if (params.length > 0) {
            return baseName + " | Data: " + Arrays.toString(params);
        }
        return baseName;
    }


	
	
}
