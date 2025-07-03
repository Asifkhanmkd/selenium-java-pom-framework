package com.qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> tdriver= new ThreadLocal<WebDriver>();
	
	  public WebDriver initDriver(String browser) {
		  
		  
		  switch(browser.toLowerCase()) {
		  
		  case"chrome":
		  
			  WebDriverManager.chromedriver().setup();
			  tdriver.set(new ChromeDriver());
			
			  break;
			  
			  
		  case "firefox":
		  
		   WebDriverManager.firefoxdriver().setup();
		   tdriver.set(new FirefoxDriver());
		   
		   break;
		   
		   case "edge":
		   
		   WebDriverManager.edgedriver().setup();
		   tdriver.set(new EdgeDriver());
		  
		   
		   break;
		   
		  
		  
		 default:
			   throw new IllegalArgumentException("unsupported browser: "+browser);
	  }
		
		  return tdriver.get();

		  
		  
		  

}
	  public static WebDriver getDriver() {
		  
		  return tdriver.get();
	  }
	  
	  
	  public static void quitDriver() {
	        WebDriver driver = tdriver.get();
	        if (driver != null) {
	            driver.quit();
	            tdriver.remove(); // Remove from ThreadLocal
	        }
	    }
	  
	 
	    
}