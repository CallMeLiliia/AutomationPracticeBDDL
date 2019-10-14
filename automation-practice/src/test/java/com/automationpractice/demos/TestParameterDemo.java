package com.automationpractice.demos;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver_factory.Driver;

public class TestParameterDemo extends Driver{
	
	@Parameters ({"userid", "password"})
	@Test
	public void Login_with_invalid_userid(String u, String p) {

		driverHelper.openUrl("http://automationpractice.com");
		driverHelper.click(By.className("login"), 5);
		
			
		driverHelper.sendKeys(By.id("email"), u, 5);
		driverHelper.sendKeys(By.id("passwd"), p,5);
		
		// Click sign in button
		
		driverHelper.click(By.xpath("//button[@id='SubmitLogin']"), 8);
			

	}

}
