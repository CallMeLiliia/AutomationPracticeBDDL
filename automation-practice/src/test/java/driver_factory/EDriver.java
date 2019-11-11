package driver_factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import new_driver_factory.ReporterNew;
import utils.AppProperties;
import utils.Common;
import utils.DriverHelper;
import utils.Reporter;

public class EDriver {
	
	protected EventFiringWebDriver driver;
	protected WebDriver sDriver;
	protected DriverHelper driverHelper;

	@BeforeSuite
	public void initializeReporter() {
		ReporterNew.initReporter();

	}

	@AfterMethod
	public void saveReport() {
		ReporterNew.saveReport();

	}

	@BeforeTest
	public void init() {
		if (sDriver == null)
			sDriver = getDriver(AppProperties.BROWSER_TYPE);
// if ( driverHelper == null ) driverHelper = newDriverHelper(driver);

		Common.deletFiles("/target/screenshots");

	}



	protected WebDriver getDriver(String browserType) {
        WebDriver driver = null;
		switch (browserType) {
		case "chrome":
			driver = getChromeDriver();

//		driver.manage().window().maximize();
			break;
		case "firefox":
			driver = getFirefoxDriver();
			driver.manage().window().maximize();
			break;

		default:
			System.out.println("Browser type " + browserType + " invalid");
			break;

		}
		
		this.driver = new EventFiringWebDriver(driver);
		this.driver.register(new DriverListener());
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driverHelper = new DriverHelper(driver);
		return driver;

	}

	private ChromeDriver getChromeDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions crChromeOptions = new

		ChromeOptions();

		crChromeOptions.addArguments("--start-maximized");
		return new ChromeDriver(crChromeOptions);

	}

	private FirefoxDriver getFirefoxDriver() {

		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver.quit();

	}

}
