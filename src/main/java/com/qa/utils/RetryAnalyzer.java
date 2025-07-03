package com.qa.utils;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	private static final int maxTry = 1;
	private static final Map<String, Integer> retryCounts = new ConcurrentHashMap<>();

	@Override
	public boolean retry(ITestResult result) {
		String testId = getTestId(result);
		int currentCount = retryCounts.getOrDefault(testId, 0);

		if (currentCount < maxTry) {

			retryCounts.put(testId, currentCount + 1);
			return true;
		}
		return false;

	}

	public static int getRetryCount(ITestResult result) {
		return retryCounts.getOrDefault(getTestId(result), 0);
	}

	private static String getTestId(ITestResult result) {
		return result.getTestClass().getName() + "." + result.getMethod().getMethodName()
				+ Arrays.toString(result.getParameters());
	}
}

/*
 * private static final int maxTry = 1; private static final Map<String,
 * Integer> retryCounts = new ConcurrentHashMap<>();
 * 
 * @Override public boolean retry(ITestResult result) { String testId =
 * result.getTestClass().getName() + "." + result.getMethod().getMethodName();
 * int currentCount = retryCounts.getOrDefault(testId, 0);
 * 
 * result.setAttribute("retryCounts",currentCount);
 * 
 * retryCounts.put(testId, currentCount+1);
 * 
 * return currentCount < maxTry; }
 * 
 * public static int getRetryCount(String testId) {
 * 
 * return retryCounts.getOrDefault(testId, 0); }
 * 
 * }
 */
