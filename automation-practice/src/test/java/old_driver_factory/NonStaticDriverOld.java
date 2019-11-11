package old_driver_factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.AppProperties;
import utils.Common;

import old_driver_factory.ReporterOld;

public class NonStaticDriverOld{
	
	protected  WebDriver driverOld;
	protected  DriverHelperOld driverHelperOld;
	
	
	@BeforeSuite
	public void initializeReporter () {
		ReporterOld.initReporter();
	}
	@AfterMethod
	public void saveReport() {
		ReporterOld.saveReport();
	}

	@BeforeTest
	public void init() {
		if (driverOld == null)
		driverOld = getDriver(AppProperties.BROWSER_TYPE);
		Common.deletFiles("/target/screenshots");
		

	}

	protected NonStaticDriverOld() {

	}
	

	protected  WebDriver getDriver(String browserType) {
		WebDriver driverOld = null;
		switch (browserType) {
		case "chrome":
			driverOld = getChromeDriver();
			driverOld.manage().window().maximize();
			break;
		case "firefox":
			driverOld = getFirefoxDriver();
			driverOld.manage().window().maximize();
			break;

		default:
			System.out.println("Browser type " + browserType + " invalid");
			break;
		}
		driverOld.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driverOld.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driverHelperOld = new DriverHelperOld(driverOld);
		return driverOld;

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
