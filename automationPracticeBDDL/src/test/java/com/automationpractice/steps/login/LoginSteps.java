package com.automationpractice.steps.login;

import org.openqa.selenium.WebDriver;
import com.automationpractice.pages.home.HomePage;
import com.automationpractice.pages.login.LoginPage;
import com.automationpractice.pages.my_account.MyAccountPage;
import com.automationpractice.utilities.AppProperties;
import com.automationpractice.utilities.CommonSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

/**
 * October 22,2019
 * 
 * @author kulis
 *
 */
public class LoginSteps  extends CommonSteps{

	private WebDriver driver = getDriver();
	private HomePage homePage = new HomePage(driver);
	private LoginPage loginPage = new LoginPage(driver);
	private MyAccountPage myAccountPage = new  MyAccountPage(driver);
	

	@Given("^User navigates to home page$")
	public void userNavigatesToHomePage() {

	}

	@When("User user clicks on sign in link")
	public void user_user_clicks_on_sign_in_link() {
		homePage.clicSignInLink();
	}

	@When("User inputs  email and password")
	public void user_inputs_email_and_password() {
		String email ="abc213@mailinator.com";
		String password ="abc1234";
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		
	}

	@When("User clicks sign in button")
	public void user_clicks_sign_in_button() {
		homePage.clicSignInLink();
	}

	@Then("User is on account page")
	public void user_is_on_account_page() {
	String actualHeader = myAccountPage.getHeader();	
	assertEquals("AUTHENTICATION", actualHeader);
	}

}
