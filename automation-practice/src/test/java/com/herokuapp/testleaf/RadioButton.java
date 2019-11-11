package com.herokuapp.testleaf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import driver_factory.Driver;
import driver_factory.NonStaticDriver;

/**
 * 
 * October 4, 2019
 * Happy Birthday to me)
 * @author kulis
 *
 */

public class RadioButton extends NonStaticDriver {
	@Test
	public void test1() {
		driver.get("http://testleaf.herokuapp.com/pages/radio.html");
		
		WebDriverWait  webDriverWait = new WebDriverWait(driver, 12); //explicit wait
		
		WebElement yesElement = driver.findElement(By.id("yes"));
		WebElement noElement = driver.findElement(By.id("no"));
		
		webDriverWait.until(ExpectedConditions.visibilityOf(yesElement));
		yesElement.click();
		
		boolean isYesdSelected = yesElement.isSelected();
		Assert.assertTrue(isYesdSelected, "Yes radio button is not selected");
		
//		if (isYesdSelected) {
//			Assert.fail("Your Radio button is not selected");
//			
//		}
		
		driver.close();
		
		
	}
	
 

}
