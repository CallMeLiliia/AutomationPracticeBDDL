package com.automationpractice.pages.contact_us;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.pages.login.LoginPage;
import com.automationpractice.utilities.CommonPage;
import com.automationpractice.utilities.DriverHelper;

/**
 * November,20 2019
 * @author kulis
 *
 */

public class ContactUsPage extends CommonPage {
	private WebDriver driver;
	public ContactUsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}
	private static final int timeOutInSeconds = 15;
	private static final Logger logger = Logger.getLogger(LoginPage.class);
	private DriverHelper driverHelper = getDriverHelper();
	
	private By dropDownSubjectHeader = By.id("id_contact");
	private By emailTextBox = By.id("email");
	private By orderReferenceTextBox = By.id("id_order");
	private By attachFileTextBox = By.id("fileUpload");
	private By messageTextBox = By.id("message");
	private By sendButton = By.id("submitMessage");
	
	
	
	
	public void chooseSubjectHeader(String subject) {
		Select select = new Select(driver.findElement(dropDownSubjectHeader));
		select.selectByVisibleText(subject);
		logger.info(subject+ " was selected in Subject Header");
		
	}
	public void enterEmail(String email) {
		driverHelper.sendKeys(emailTextBox, email, timeOutInSeconds);
		logger.info("Entered an email as "+ email);
	}
	
	public void enterOrderReference (String orderReferenceText) {
		driverHelper.sendKeys(orderReferenceTextBox, orderReferenceText, timeOutInSeconds);
		logger.info("Entered Order Reference as "+ orderReferenceText);
	}
	
	public void attachFile (String filePath) {
		driverHelper.sendKeys(attachFileTextBox, filePath, timeOutInSeconds);
	}
	
	public void enterMessage (String message) {
		driverHelper.sendKeys(messageTextBox, message, timeOutInSeconds);
	}
	
	public void clickSendButton() {
		driverHelper.click(sendButton, timeOutInSeconds);
	}
	

}
