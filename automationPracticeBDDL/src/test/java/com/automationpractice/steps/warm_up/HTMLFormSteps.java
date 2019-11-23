package com.automationpractice.steps.warm_up;

import com.automationpractice.utilities.CommonSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import warm_up.HtmlFormPage;
/**
 * November,21 2019
 * @author kulis
 *
 */
public class HTMLFormSteps extends CommonSteps{
	
	private HtmlFormPage htmlFormPage = HtmlFormPage.getHtmlFormPage(getDriver()); 
	
//	public HTMLFormSteps() {
//		if (htmlFormPage==null) {
//			htmlFormPage = new HtmlFormPage(getDriver());
//		}
//	}
	
	@Given("User navigates tp TOOLS QA home page")
	public void user_navigates_tp_TOOLS_QA_home_page() {
	getDriver().get("https://demoqa.com/");
	   
	}

	@When("User click HTML form link")
	public void user_click_HTML_form_link() {
	  htmlFormPage.clickHtmlContactFormLink();
	}

	@When("User enters {string} first name")
	public void user_enters_first_name(String fName) {
	   htmlFormPage.enterFirstName(fName);
	}

	@When("User enters {string} last name")
	public void user_enters_last_name(String lName) {
	   htmlFormPage.enterLastName(lName);
	}
	
	@When("User enters {string} subject")
	public void user_enters_subject(String subject) {
		 htmlFormPage.enterSubject(subject);
	}

	@When("User enters {string} country")
	public void user_enters_country(String country) {
	   htmlFormPage.enterCountry(country);
	}

	@When("User clicks submit button")
	public void user_clicks_submit_button() {
	htmlFormPage.clickSubmitButton();
	}

	@Then("User should see successful page")
	public void user_should_see_successful_page() {

	}

}
