package com.qa.base;
import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.driver.DriverFactory;
import com.qa.utils.ConfigReader;

public class BaseTest {

	public WebDriver driver;
	//public Properties prop;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
	    System.out.println("[" + Thread.currentThread().getId() + "] Starting browser at " + LocalDateTime.now());
		
		ConfigReader.initProp();
		
		
		String url= ConfigReader.get("url");
		
		DriverFactory df = new DriverFactory();
	 	
		//ConfigReader config = new ConfigReader();
		//prop = config.initProp();

		//String browser = prop.getProperty("browser");
		//String url = prop.getProperty("url");
		
	     String browser= System.getProperty("browser");
	     if(browser==null) {
	    	 browser=ConfigReader.get("browser");	 
	    	 
	     }
		

		driver = df.initDriver(browser);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		
		System.out.println("[" + Thread.currentThread().getId() + "] Navigated to: " + url + " at " + LocalDateTime.now());

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		System.out.println(">>> Running tearDown() for driver: " + driver);
		if (driver != null) {

			driver.quit();
		}

	}
}
