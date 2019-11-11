package com.automationpractice.login;

import org.junit.Assert;
import org.openqa.selenium.By;
import com.automationpractice.utilities.AppProperties;
import com.automationpractice.utilities.DriverFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/**
 * October 22,2019
 * 
 * @author kulis
 *
 */
public class LoginSteps extends DriverFactory {

	
	private int timeOutInSeconds = 15;



	@Given("^User navigates to home page$")
	public void userNavigatesToHomePage() {
		driver.get(AppProperties.AUTOMATION_PRACTICE_BASE_URL);

	}

	@When("User user clicks on sign in link")
	public void user_user_clicks_on_sign_in_link() {
		driverHelper.click(By.linkText("Sign in"), timeOutInSeconds);
	}

	@When("User inputs  email and password")
	public void user_inputs_email_and_password() {
		driverHelper.sendKeys(By.id("email"), "abc213@mailinator.com", timeOutInSeconds);
		driverHelper.sendKeys(By.id("passwd"), "abc1234", timeOutInSeconds);
	}

	@When("User clicks sign in button")
	public void user_clicks_sign_in_button() {
driverHelper.click(By.id("SubmitLogin"), timeOutInSeconds);
	}

	@Then("User is on account page")
	public void user_is_on_account_page() {
		String accountHeader = driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
Assert.assertEquals("MY ACCOUNT", accountHeader);	}



}
