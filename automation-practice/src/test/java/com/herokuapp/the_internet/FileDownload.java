package com.herokuapp.the_internet;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.NonStaticDriver;
import utils.AppProperties;
import utils.Common;

public class FileDownload extends NonStaticDriver{
	private int timeOutInSeconds = 15;
	
@Test
public void fileDownloadTest1() {
	driverHelper.openUrl(AppProperties.THE_INTERNET_BASE_URL+"/download");
	String fileName = "webdriverIO.png";
	driverHelper.click(By.linkText("webdriverIO.png"), timeOutInSeconds);
	
	
	File file = new File(System.getProperty("user.home")+"/Downloads/"+fileName);
	//C://Users/kulis
//	System.out.println(file);
	
	boolean isFileExist = file.exists();
	int numberOfAttemps = 0;
	while (!isFileExist && numberOfAttemps<=5) {
		Common.sleep(1);
		isFileExist = file.exists();
		numberOfAttemps++;
		
	}
	
	Assert.assertTrue(file.exists(), "File\""+fileName+"\"not found in Download direciry");
	
	Common.sleep(5);
}
	
	
	
	
	
	
	

}
