package com.automationpractice.steps.contact_us;

import org.openqa.selenium.WebDriver;

import com.automationpractice.pages.contact_us.ContactUsPage;
import com.automationpractice.utilities.CommonSteps;
import com.automationpractice.utilities.TestDataGenerator;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactUsSteps extends CommonSteps{
	
	private ContactUsPage contactUsPage; 
	
public ContactUsSteps() {
	if(contactUsPage==null) {
		contactUsPage = new ContactUsPage(getDriver());
	}
}
	
	


	@When("User populates Contact Us form")
	public void user_populates_Contact_Us_form() {
		
		String firstName = TestDataGenerator.getRandomFirstName();
		String lastName = TestDataGenerator.getRandomLastName();
	    contactUsPage.enterEmail(TestDataGenerator.getRandomEmail(firstName, lastName));
	    
	    contactUsPage.enterOrderReference("randomText");
	    contactUsPage.enterMessage(TestDataGenerator.getRandomText(301));
	    contactUsPage.chooseSubjectHeader("Customer service");
	    contactUsPage.attachFile("C:/Users/kulis/OneDrive/Desktop/New folder/w3.gng");
	   
	}

	@When("User Clicks on Send button")
	public void user_Clicks_on_Send_button() {

		contactUsPage.clickSendButton();
	}

	@Then("User should vie success message")
	public void user_should_vie_success_message() {
		
		System.out.println("done");
	    
	}

	

}
