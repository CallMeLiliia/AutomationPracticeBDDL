package com.herokuapp.testleaf;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import driver_factory.NonStaticDriver;
import utils.AppProperties;
import utils.Common;

/**
 * October 12, 2019
 * @author kulis
 *
 */

public class Table extends NonStaticDriver{
	private int timeOutInSeconds=15;
	
	@BeforeClass
	void beforeClass() {
		driverHelper.openUrl(AppProperties.TEST_LEAF_BASE_URL+"/pages/table.html");
		
	}
	/**
	 * Get the count of number of columns
	 */
	@Test 
	void tabletest1() {
		
	int numberOfColumns = 	driverHelper.getElements(By.xpath("//table/tbody/tr/th"), timeOutInSeconds).size();
	Assert.assertEquals(numberOfColumns, 3);
	Assert.assertTrue(numberOfColumns ==3);
	
	WebElement tableElement = driverHelper.getElement(By.tagName("table"), timeOutInSeconds);
	int numberOfColumns1 = tableElement.findElements(By.tagName("th")).size();
	System.out.println(numberOfColumns1);
		
	}
	/**
	 * Get the count of number of rows
	 */
	@Test
	void tableTest2() {
	
	int numberOfRows=	driverHelper.getElements(By.xpath("//table/tbody/tr"), timeOutInSeconds).size();
	Assert.assertEquals(numberOfRows, 4);
		
	}
	/**
	 * Get the progress value of 'Learn to interact with Elements'
	 */
	@Test
	void tableTest3() {
	String progress = getCellValue("Learn to interact with Elements","progress" );
	
	Assert.assertEquals(progress, "80%");
	
	}
	private String getCellValue(String rowName, String columnName) {
		String cellValue = "";
		
		int columnIndex = 0;
		List<WebElement> columnElements = driverHelper.getElements(By.xpath("//table/tbody/tr/th"), timeOutInSeconds);
		for(int index =0; index< columnElements.size(); index++) {
			String actualColumnName = columnElements.get(index).getText();
			if(actualColumnName.contains(columnName)) {
				columnIndex=index+1;
				break;
			}}
			
			List<WebElement> rowElements = driverHelper.getElements(By.xpath("//table/tbody/tr"), timeOutInSeconds);
			for(int index = 1; index < rowElements.size(); index++) {
				String actualRowName = rowElements.get(index).findElement(By.tagName("td")).getText();
				if(actualRowName.contains(rowName)) {
					cellValue =rowElements.get(index).findElement(By.xpath(".//td[2]")).getText();
							
							//driverHelper.getText(By.xpath("(//table/tbody/tr)/td["+columnIndex+"]"), timeOutInSeconds);
				}
			}
		
				
		return cellValue;
	}
/**
 * Check the vital task for the 'Learn to interact with Elements'.
 */
	
	@Test 
	void tableTest4() {
		 WebElement webElement = getVitalTask("Learn to interact with Elements","Vital Task" );
		 webElement.click();
		 
		 Assert.assertTrue(webElement.findElement(By.tagName("input")).isSelected());
		
	}
	private WebElement getVitalTask(String rowName, String columnName) {
WebElement webElment = null;
		
		int columnIndex = 0;
		List<WebElement> columnElements = driverHelper.getElements(By.xpath("//table/tbody/tr/th"), timeOutInSeconds);
		for(int index =0; index< columnElements.size(); index++) {
			String actualColumnName = columnElements.get(index).getText();
			if(actualColumnName.contains(columnName)) {
				columnIndex=index+1;
				break;
			}}
			
			List<WebElement> rowElements = driverHelper.getElements(By.xpath("//table/tbody/tr"), timeOutInSeconds);
			for(int index = 1; index < rowElements.size(); index++) {
				String actualRowName = rowElements.get(index).findElement(By.tagName("td")).getText();
				if(actualRowName.contains(rowName)) {
					webElment =rowElements.get(index).findElement(By.xpath(".//td["+columnIndex+"]"));
							
							//driverHelper.getText(By.xpath("(//table/tbody/tr)/td["+columnIndex+"]"), timeOutInSeconds);
				}
			}
		
				
		return webElment;
	}
}
