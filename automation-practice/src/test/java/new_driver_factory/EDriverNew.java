package new_driver_factory;

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
import org.testng.annotations.Listeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.AppProperties;
import utils.Common;
import utils.DriverHelper;
import new_driver_factory.ReporterNew;

@Listeners(driver_factory.TestNGListener.class)
public class EDriverNew {

	protected EventFiringWebDriver driver;
	protected WebDriver sDriver;
	protected DriverHelperNew driverHelperNew;

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
			sDriver =getDriver(AppProperties.BROWSER_TYPE);
     //if ( driverHelper == null )driverHelper = new DriverHelperNew(driver);
	//	Common.deleteFiles("/target/screenshots");
		ReporterNew.createTest("test");
		
		

	}

	protected WebDriver getDriver(String browserType) {

		switch (browserType) {
		case "chrome":
			sDriver = getChromeDriver();

//		driver.manage().window().maximize();
			break;

		case "chrome-headless":
			sDriver =getHeadlessChromeDriver();

			break;
		case "firefox":
			sDriver = getFirefoxDriver();

			sDriver.manage().window().maximize();
			break;

		default:
			System.out.println("Browser type " +browserType + " invalid");

			break;

		}
		this.driver = new EventFiringWebDriver(sDriver);
		this.driver.register(new DriverListenerNew());
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,

				TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10,

				TimeUnit.SECONDS);

		driverHelperNew = new DriverHelperNew(this.driver);
		return driver;

	}

	private ChromeDriver getChromeDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions crChromeOptions = new

		ChromeOptions();

		crChromeOptions.addArguments("--start-maximized");
		return new ChromeDriver(crChromeOptions);

	}

	private ChromeDriver getHeadlessChromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions crChromeOptions = new

		ChromeOptions();

		crChromeOptions.addArguments("--start-maximized");
		crChromeOptions.addArguments("--headless");
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