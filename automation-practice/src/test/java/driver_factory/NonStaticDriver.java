package driver_factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.AppProperties;
import utils.Common;
import utils.DriverHelper;
import utils.Reporter;

public class NonStaticDriver{
	
	protected  WebDriver driver;
	protected  DriverHelper driverHelper;
	
	
	@BeforeSuite
	public void initializeReporter () {
		Reporter.initReporter();
	}
	@AfterMethod
	public void saveReport() {
		Reporter.saveReport();
	}

	@BeforeTest
	public void init() {
		if (driver == null)
		driver = getDriver(AppProperties.BROWSER_TYPE);
		Common.deletFiles("/target/screenshots");
		

	}

	protected NonStaticDriver() {

	}
	

	protected  WebDriver getDriver(String browserType) {
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

	private  ChromeDriver getChromeDriver() {

		WebDriverManager.chromedriver().setup();

//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\kulis\\eclipse-workspace1\\FirstProject\\chromedriver.exe");

		return new ChromeDriver();

	}

	private  FirefoxDriver getFirefoxDriver() {

		WebDriverManager.firefoxdriver().setup();

		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\kulis\\eclipse-workspace1\\FirstProject\\geckodriver1.exe");
		return new FirefoxDriver();
	}
	
	@AfterTest
	public void closeBrowser() {
		//driver.close();
	}

}
