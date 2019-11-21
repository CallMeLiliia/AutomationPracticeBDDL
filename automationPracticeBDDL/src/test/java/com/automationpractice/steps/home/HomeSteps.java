package com.automationpractice.steps.home;

import com.automationpractice.pages.home.HomePage;
import com.automationpractice.utilities.CommonSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
/**
 * November,20 2019
 * @author kulis
 *
 */
public class HomeSteps extends CommonSteps{
	
	private HomePage homePage = new HomePage(getDriver());
	@Given("^User clicks on Contact Us link$")
	public void userClickOnContactUsLink() {
		homePage.clickContactUsLink();}
	
	@When("User user clicks on sign in link")
	public void user_user_clicks_on_sign_in_link() {
		homePage.clicSignInLink();
	}

	}

