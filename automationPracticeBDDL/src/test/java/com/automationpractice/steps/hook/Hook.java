package com.automationpractice.steps.hook;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.AppProperties;
import com.automationpractice.utilities.CommonSteps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
/**
 * November,20 2019
 * @author kulis
 *
 */
public class Hook extends CommonSteps{
	
	private static Logger logger = Logger.getLogger(Hook.class);
	private WebDriver driver = getDriver();
			

	@Before
	public void setUp() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		
		driver.get(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
		
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		byte [] screenshot=	takesScreenshot.getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
		
		}
//		closeDriver();
		
		}
	@AfterStep
	public void afterStep(Scenario scenario) {
		if(AppProperties.IS_EACH_STEP_SCREENSHOT) {
			TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
			byte [] screenshot=	takesScreenshot.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");	
		}
	}
	
}
