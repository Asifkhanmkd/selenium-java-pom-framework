package com.qa.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;

	@BeforeMethod
	public void setup() {

		ConfigReader config = new ConfigReader();
		prop = config.initProp();

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
			driver.get(url);

		}
	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {

			driver.quit();
		}

	}
}
