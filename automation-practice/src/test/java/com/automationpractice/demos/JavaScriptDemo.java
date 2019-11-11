package com.automationpractice.demos;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import new_driver_factory.EDriverNew;
import utils.AppProperties;
import utils.Common;


public class JavaScriptDemo extends EDriver{
	
	int timeOutInSeconds = 15;
	@Test
	public void calculator() {
		
		driverHelper.openUrl("http://anaesthetist.com/mnm/javascript/calc.htm");
		
		driverHelper.click(By.name("two"), timeOutInSeconds);
		
		driverHelper.click(By.name("add"), timeOutInSeconds);
		driverHelper.click(By.name("two"), timeOutInSeconds);
		
		Common.sleep(4);
		driverHelper.click(By.name("result"), timeOutInSeconds);
		
		
		String actualResult = driverHelper.getElement(By.name("[name=Display]"), timeOutInSeconds).getAttribute("value");
		Assert.assertEquals("4", actualResult);
		Common.sleep(4);
	}
	
	@Test
	public void jsAlert() {
		String alertText = "Ma name is "+ Common.getRandomFirstName() + " "+ Common.getRandomLastName();
		driverHelper.openUrl(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("alert ('"+alertText+"')");
		String actualAlertText = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		Assert.assertEquals(alertText, actualAlertText);
		
	}

}
