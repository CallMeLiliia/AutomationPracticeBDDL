package com.automationpractice.login;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import driver_factory.NonStaticDriver;
import utils.Reporter;

public class LoginTestWithReporting extends NonStaticDriver{
	
	
	@Test 
	public void loginWithValidUserIdAndPassword() {
		Reporter.createClass("LoginTEstWithReporting");
		Reporter.createTest("logintestcase");
		
		
		driverHelper.openUrl("http://www.automationpractice.com");
		driverHelper.click(By.className("login"), 2);
	}

}
