package com.automationpractice.demos;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import driver_factory.NonStaticDriver;
import utils.AppProperties;
import utils.Common;


public class ExtentReportDemo extends NonStaticDriver {
	
	@Test
	public void t1() {

	}
	
	@Test
	public void login_with_invalid_user_is() {
		//Reporter.createTest("Login with invalid user ID and password");
		
         driver.get(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
		
		//Click sign in button from top right corner of the page
		driver.findElement(By.className("login")).click();
		
		//Enter invalid email address 'myunknownxaad@mailinator.com' in email address text field of right side
		driver.findElement(By.id("email")).sendKeys("myunknownxaad@mailinator.com");
		//driverHelper.sendKeys(By.id("email"), "myunknownxaad@mailinator.com",10);
		
		// Click sign in button
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		
		// Verify error message displayed 'There is 1 error'
		String errorMessage = driver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
		//System.out.println(errorMessage);
		
		Assert.assertEquals(errorMessage, "There is 1 error");
		
		//Verify error message displayed 'Password is required'
		String errorMessage1 = driver.findElement(By.xpath("//li[text()='Password is required.']")).getText();
	//	Assert.assertEquals(errorMessage1, "Password is required.");
		
		
		
		
		
		
		
	}

}
