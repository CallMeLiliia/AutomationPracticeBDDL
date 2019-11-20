package com.automationpractice.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * October 22,2019
 *  * @author kulis
 *
 */
final class DriverFactory {

	private static WebDriver driver;
	private static Logger logger = Logger.getLogger(DriverFactory.class);

	 static WebDriver getDriver() {
		if (driver == null) {
			driver = getActiveDriver();
		}
		return driver;
	}

	static void closeDriver() {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}

	private synchronized static WebDriver getActiveDriver() {
		String browserType = AppProperties.BROWSER_TYPE;
		switch (browserType) {
		case "chrome":
			driver = getChromeDriver();
			driver.manage().window().maximize();
			break;
		case "chrome-headless":
			driver = getHeadlessChromeDriver();
			break;
		case "firefox":
			driver = getFirefoxDriver();
			break;
		default:
			System.out.println("Browser type " + browserType + " invalid");
			break;
		}
		logger.info("Driver type set to " + browserType);
		return driver;
	}

	private static ChromeDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions crChromeOptions = new ChromeOptions();
		crChromeOptions.addArguments("--start-maximized");
		return new ChromeDriver(crChromeOptions);
	}

	private static ChromeDriver getHeadlessChromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions crChromeOptions = new ChromeOptions();
		crChromeOptions.addArguments("--start-maximized");
		crChromeOptions.addArguments("--headless");
		return new ChromeDriver(crChromeOptions);
	}

	private static FirefoxDriver getFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

}
