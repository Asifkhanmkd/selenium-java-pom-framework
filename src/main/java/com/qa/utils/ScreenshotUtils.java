package com.qa.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static String captureScreenshot(WebDriver driver, String testName) {

		// System.out.println("Driver is: " + driver);
		// System.out.println("Capturing screenshot for: " + testName);

		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String fileName = testName + "_" + timestamp + ".png";

		String screenshotPath = Constants.SCREENSHOT_FOLDER + fileName;

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotPath);

		try {
			FileUtils.copyFile(src, dest);

			return "screenshots/" + fileName;

		}

		catch (IOException e) {

			throw new RuntimeException("Failed to store screenshot to :" + screenshotPath, e);

		}

	}

}
