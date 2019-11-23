package com.automationpractice.steps.login;

import org.openqa.selenium.WebDriver;
import com.automationpractice.pages.home.HomePage;
import com.automationpractice.pages.login.LoginPage;
import com.automationpractice.pages.my_account.MyAccountPage;
import com.automationpractice.utilities.Common;
import com.automationpractice.utilities.CommonSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

/**
 * October 22,2019
 * 
 * @author kulis
 *
 */
public class LoginSteps extends CommonSteps {

	private WebDriver driver = getDriver();
	private HomePage homePage = new HomePage(driver);
	private LoginPage loginPage = new LoginPage(driver);
	private MyAccountPage myAccountPage = new MyAccountPage(driver);

	@Given("^User navigates to home page$")
	public void userNavigatesToHomePage() {

	}

	@When("User inputs  email and password")
	public void user_inputs_email_and_password() {
		String email = "abc213@mailinator.com";
		String password = "abc1234";
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);

	}

	@When("User clicks sign in button")
	public void user_clicks_sign_in_button() {
		loginPage.clickSignInButton();
		;
	}

	@Then("User is on account page")
	public void user_is_on_account_page() {
		String actualHeader = myAccountPage.getHeader();
		assertEquals("AUTHENTICATION", actualHeader);
	}

	@When("User inputs {string} email  and {string} password")
	public void user_inputs_and(String email, String password) {
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
	}

	@Then("User should see error message {string}")
	public void user_should_see_error_message(String errorMessage) {
		String actualErrorMessage = loginPage.getErrorMessage();
		assertTrue("Error message: Actual is " + actualErrorMessage + " , Expected is " + errorMessage,
				actualErrorMessage.contains(errorMessage));
	}

	@Then("User inputs  email, password, clicks sign in button and validate errore message")
	public void user_inputs_email_password_clicks_sign_in_button_and_validate_errore_message(DataTable dataTable) {

		List<Map<String, String>> listOfRows = dataTable.asMaps(String.class, String.class);
		
		for(int row =0; row< listOfRows.size(); row++ ) {
			String email = listOfRows.get(row).get("email");
			
			user_inputs_and(email, listOfRows.get(row).get("password"));
			user_clicks_sign_in_button();
			user_should_see_error_message(listOfRows.get(row).get("error message"));
			
			Common.sleep(2);
		}

	}

}
