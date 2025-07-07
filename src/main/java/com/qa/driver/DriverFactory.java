package com.qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(String browser) {

		switch (browser.toLowerCase()) {

		case "chrome":

			WebDriverManager.chromedriver().setup();
			ChromeOptions cOption = new ChromeOptions();

			if (System.getenv("CI") != null) {
				cOption.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080");
			}
			tdriver.set(new ChromeDriver(cOption));

			break;

		case "firefox":

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions fOption = new FirefoxOptions();
			if (System.getenv("CI") != null) {

				fOption.addArguments("--headless");
			}

			tdriver.set(new FirefoxDriver());

			break;

		case "edge":

			WebDriverManager.edgedriver().setup();
			EdgeOptions eOption= new EdgeOptions();
			
			if(System.getenv("CI")!=null) {
				eOption.addArguments("--headless=new","--disable-gpu","--window-size=1920,1080")
				;
			}
			tdriver.set(new EdgeDriver());

			break;

		default:
			throw new IllegalArgumentException("unsupported browser: " + browser);
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