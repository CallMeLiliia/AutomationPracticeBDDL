package com.herokuapp.the_internet;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.Driver;
import utils.AppProperties;
import utils.DriverHelper;

/**
 * 
 * October, 7 2019
 * @author kulis
 *
 */

public class FileUpload extends Driver{
private final int timeOutInSeconds = 15;	
		@Test 
	public void fileUpload() {
			driver.get(AppProperties.THE_INTERNET_BASE_URL);
			
			DriverHelper driverHelper = new DriverHelper(driver);
			driverHelper.click(By.linkText("File Upload"), timeOutInSeconds);
			
			
			
			String filePath = System.getProperty("user.dir")+"/src/test/resources/files/w3.PNG";
			driverHelper.sendKeys(By.id("file-upload"),filePath, timeOutInSeconds);
			
			String fileName = Paths.get(filePath).getFileName().toString();
			
			
			String uploadedFile = driverHelper.getElement(By.id("file-upload"), timeOutInSeconds).getAttribute("value");
			uploadedFile =  Paths.get(uploadedFile).getFileName().toString();
			
			Assert.assertEquals(fileName, uploadedFile, "Uploaded file validation is Failed");
			
			driverHelper.takeScreenshot();
			
			driverHelper.click(By.id("file-submit"), timeOutInSeconds);
			String actualHeader = driverHelper.getText(By.tagName("h3"), timeOutInSeconds);
			String actualUploadedFile = driverHelper.getText(By.id("uploaded-files"), timeOutInSeconds);
			
			Assert.assertEquals(actualHeader, "File Uploaded!");
			Assert.assertEquals(fileName, actualUploadedFile);
			
			
			System.out.println("Name of the Uploaded File is " +uploadedFile);
			
			
			
			driverHelper.takeScreenshot();
			
		
		
		
	}

}
