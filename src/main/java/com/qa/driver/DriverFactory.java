package com.qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> tdriver= new ThreadLocal<WebDriver>();
	
	  public WebDriver initDriver(String browser) {
		  if(browser.equalsIgnoreCase("chrome")) {
			  WebDriverManager.chromedriver().setup();
			  tdriver.set(new ChromeDriver());
		  }
		  
		  return tdriver.get();
		  
		  

}
	  public static WebDriver getDriver() {
		  
		  return tdriver.get();
	  }
	  
	  
	  
	  
	  
}