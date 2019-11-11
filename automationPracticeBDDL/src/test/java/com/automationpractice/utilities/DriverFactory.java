package com.automationpractice.utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * October 22,2019
 * @author kulis
 *
 */
public class DriverFactory {
	
	
	
protected static WebDriver driver;
protected static DriverHelper driverHelper;

static {
	if (driver == null) {
		driver = getDriver(AppProperties.BROWSER_TYPE);
	
	driverHelper= new DriverHelper(driver);
}}


 

	protected synchronized static WebDriver getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			driver = getChromeDriver();
			driver.manage().window().maximize();
			break;
		case "chrome-headless":
			driver = getHeadlessChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver = getFirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("Browser type " + browserType + " invalid");
			break;
		}


		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	private static ChromeDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions crChromeOptions = new ChromeOptions();
		crChromeOptions.addArguments("--start-maximized");
		crChromeOptions.addArguments("--headless");
		return new ChromeDriver(crChromeOptions);
	}

	private static ChromeDriver getHeadlessChromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions crChromeOptions = new ChromeOptions();
		crChromeOptions.addArguments("--start-maximized");
		return new ChromeDriver(crChromeOptions);
	}

	private static FirefoxDriver getFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

}
