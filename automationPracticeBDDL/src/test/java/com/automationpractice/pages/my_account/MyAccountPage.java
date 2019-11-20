package com.automationpractice.pages.my_account;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.pages.home.HomePage;
import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;

/**
 * Page object for My Account web page
 * November,20 2019
 * @author kulis
 *
 */
public class MyAccountPage extends CommonPage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	private static final int timeOutInSeconds = 15;
	private static final Logger logger = Logger.getLogger(MyAccountPage.class);
	private DriverHelper driverHelper = getDriverHelper();
	
	private By header = By.tagName("h1");
	
	
	public String getHeader () {
		return driverHelper.getText(header, timeOutInSeconds);
	}
	
	
	
}
