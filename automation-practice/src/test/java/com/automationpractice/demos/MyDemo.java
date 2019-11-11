package com.automationpractice.demos;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import driver_factory.EDriver;
import utils.DriverHelper;



public class MyDemo extends EDriver{
	
	
	@Test 
	public void test() {
		
		driverHelper.openUrl("https://www.facebook.com");
	}
	
}


	

	

	
	


