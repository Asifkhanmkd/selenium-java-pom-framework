package com.qa.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static final Map<String, ExtentTest> testMap = new ConcurrentHashMap<>();

    public static ExtentReports initReport() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter(Constants.EXTENT_REPORT_FOLDER + "Extent.html");
            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Orange CRM Test Automation Report");
            spark.config().setEncoding("utf-8");

            spark.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("QA", "Asif");
        }
        return extent;
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static ExtentTest  createTest(String testName) {
        // Only create once per test method
        if (!testMap.containsKey(testName)) {
            ExtentTest extentTest = extent.createTest(testName);
            testMap.put(testName, extentTest);
        }
        test.set(testMap.get(testName));
        return test.get();

    }

    public static ExtentTest getTest() {
        return test.get();
    }
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	/*private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public static ExtentReports initReport() {

		if (extent == null) {

			ExtentSparkReporter spark = new ExtentSparkReporter(Constants.EXTENT_REPORT_FOLDER +"Extent.html");
			spark.config().setReportName("Automation Test Report");
			spark.config().setDocumentTitle("Orange CRM Test Automation Report");
            spark.config().setTheme(Theme.DARK);
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
}*/
