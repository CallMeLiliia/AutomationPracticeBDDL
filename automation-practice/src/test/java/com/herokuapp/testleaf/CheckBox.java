package com.herokuapp.testleaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driver_factory.Driver;
import driver_factory.NonStaticDriver;
import utils.AppProperties;
import utils.Common;

public class CheckBox extends NonStaticDriver{
	private int timeOutInSeconds=15;
	
	
	@BeforeClass
	public void classSetUp() {
		driver.get(AppProperties.TEST_LEAF_BASE_URL);
		System.out.println("hey");
		
	}
	@Test
	public void checkBox1() {
		
		driverHelper.click(By.linkText("Checkbox"), timeOutInSeconds);
		String xpath = "//label[contains(text(),'Select the languages that you know?')]/following-sibling::input";
	//	driverHelper.click(By.xpath("(//label[contains(text(),'Select the languages that you know?')]/following-sibling::input)[1]"), timeOutInSeconds);
//	driverHelper.click(By.xpath(xpath), 1, timeOutInSeconds);
//	driverHelper.click(By.xpath(xpath), 2, timeOutInSeconds);
//	driverHelper.click(By.xpath(xpath), 3, timeOutInSeconds);
//	driverHelper.click(By.xpath(xpath), 4, timeOutInSeconds);
//	driverHelper.click(By.xpath(xpath), 5, timeOutInSeconds);
	
	
	for(int index = 0 ; index< driverHelper.getElements(By.xpath(xpath),timeOutInSeconds).size(); index++) {
		driverHelper.click(By.xpath(xpath), (index+1), timeOutInSeconds);
	}
	
	Common.sleep(4);
	}
	
	@Test
	
	public void confirmSeleniumIsChecked() {
		driverHelper.click(By.linkText("Checkbox"), timeOutInSeconds);
		
		WebElement element = driverHelper.getElement(By.xpath("(//input[@type='checkbox'])[6]"), timeOutInSeconds);
		boolean isSelected = element.isSelected();
		Assert.assertTrue(isSelected, "Selenium check box was not checked");
		
		driverHelper.takeScreenshot();
		Common.sleep(4);
		
	}

}
