package driver_factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.AppProperties;
import utils.DriverHelper;

public class Driver {
	protected static WebDriver driver;
	protected static DriverHelper driverHelper;

	static {
		if (driver == null)
		driver = getDriver(AppProperties.BROWSER_TYPE);

	}

	protected Driver() {

	}
	

	protected static WebDriver getDriver(String browserType) {
		WebDriver driver = null;
		switch (browserType) {
		case "chrome":
			driver = getChromeDriver();
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
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driverHelper = new DriverHelper(driver);
		return driver;

	}

	private static ChromeDriver getChromeDriver() {

		WebDriverManager.chromedriver().setup();

//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\kulis\\eclipse-workspace1\\FirstProject\\chromedriver.exe");

		return new ChromeDriver();

	}

	private static FirefoxDriver getFirefoxDriver() {

		WebDriverManager.firefoxdriver().setup();

		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\kulis\\eclipse-workspace1\\FirstProject\\geckodriver1.exe");
		return new FirefoxDriver();
	}

}
