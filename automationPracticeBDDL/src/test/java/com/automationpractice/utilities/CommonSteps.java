package com.automationpractice.utilities;

import org.openqa.selenium.WebDriver;

public class CommonSteps {
	
	protected WebDriver getDriver () {
		return DriverFactory.getDriver();
	}
	
	protected static void closeDriver () {
		DriverFactory.closeDriver();
	}

}
