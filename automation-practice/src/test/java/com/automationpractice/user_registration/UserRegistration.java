package com.automationpractice.user_registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.Driver;
import driver_factory.NonStaticDriver;
import utils.AppProperties;
import utils.Common;
import utils.DriverHelper;

/**
 * September 30,2019
 * 
 * @author kulis
 *
 */

public class UserRegistration extends NonStaticDriver {

	private final int timeOutInSeconds = 15;

	@Test
	public void userRegistration() {

		// DriverHelper driverHelper = new DriverHelper(driver);

		// WebDriver driver = getDriver(AppProperties.BROWSER_TYPE);

		driver.get(AppProperties.AUTOMATION_PRACTICE_BASE_URL);
		driver.findElement(By.xpath("//a[@class='login']")).click();

//	driverHelper.click(By.xpath("//a[@class='login']"), timeOutInSeconds);

		String buttonText = "   Create an account";// " "+driverHelper.getText(By.id("SubmitCreate"), timeOutInSeconds)+
													// " ";
		buttonText = buttonText.replaceAll("\\s+", "");
		buttonText = buttonText.trim();
		Assert.assertEquals("Create an account ", buttonText);

		String firstName = Common.getRandomFirstName();
		String lastName = Common.getRandomLastName();
		String email = Common.getRandomEmail(firstName, lastName);

		// driver.findElement(By.id("email_create")).sendKeys(email);
		driverHelper.sendKeys(By.id("email_create"), email, timeOutInSeconds);

		driver.findElement(By.id("SubmitCreate")).click();
//	driverHelper.click(By.id("SubmitCreate"), timeOutInSeconds);

		String createAnAccount = driver.findElement(By.xpath("//h1[text()='Create an account']")).getText();
		Assert.assertEquals(createAnAccount, "Create an account");

		String yourPersonalInformation = driver.findElement(By.xpath("//h3[text()='Your personal information']"))
				.getText();
		Assert.assertEquals(yourPersonalInformation, "YOUR PERSONAL INFORMATION");

		driverHelper.takeScreenshot();

		Common.sleep(4);

	}

}
