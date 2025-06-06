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
		
		String timestamp= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String screenshotPath="./screenshots/" +testName+ "_" +timestamp+ ".png";
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src= ts.getScreenshotAs(OutputType.FILE); 
		File dest = new File(screenshotPath);
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				
		return screenshotPath;
	}

}
