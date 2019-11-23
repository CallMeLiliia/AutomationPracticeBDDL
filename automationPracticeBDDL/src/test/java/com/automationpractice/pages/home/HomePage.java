package com.automationpractice.pages.home;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;

/**
 * November, 20 2019
 * @author kulis
 *
 */
public class HomePage extends CommonPage{
	
	private static final  int timeOutInSeconds = 15;
	private static final Logger logger = Logger.getLogger(HomePage.class);
	private DriverHelper driverHelper = getDriverHelper();
	
	private By signInLink = By.className("login");
	private By contactUsLink = By.linkText("Contact us");
		
	public HomePage(WebDriver driver) {
		super(driver);
	}
		
	public void clicSignInLink() {
		driverHelper.click(signInLink, timeOutInSeconds );
		logger.info("Clicked on Sign In Link");
	}
	public void clickContactUsLink() {
		driverHelper.click(contactUsLink, timeOutInSeconds);
		logger.info("Clicked on Contect Us Link");
	}

}
