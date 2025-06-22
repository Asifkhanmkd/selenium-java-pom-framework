package com.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public static ExtentReports initReport() {

		if (extent == null) {

			ExtentSparkReporter spark = new ExtentSparkReporter(Constants.EXTENT_REPORT_FOLDER +"Extent.html");
			spark.config().setReportName("Automation Test Report");
			spark.config().setDocumentTitle("Orange CRM Test Automation Report");

			extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("QA", "Asif");
		}

		return extent;
	}

	public static void flushReport() {

		if (extent != null)
			extent.flush();
	}

	public static void createTest(String testName) {
		ExtentTest extentTest = extent.createTest(testName);
		test.set(extentTest);
	}

	public static ExtentTest getTest() {

		return test.get();

	}
}
