package com.herokuapp.testleaf;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver_factory.NonStaticDriver;
import utils.AppProperties;
import utils.Common;

/**
 * 
 * October 12,2019
 * 
 * @author kulis
 *
 */

public class Window extends NonStaticDriver {
	private int timeOutInSeconds = 15;
	@Test
	public void windowTest1() {
		driver.get(AppProperties.TEST_LEAF_BASE_URL + "/pages/Window.html");
		driverHelper.click(By.id("home"), timeOutInSeconds);
		
		Set<String> windows = driver.getWindowHandles();
		
//		Set<Integer> windows = new HashSet<Integer>();
//		Iterator <Integer> it = windows.iterator();
//		
//		while(it.hasNext()) {
//			Integer window = it.next();
//			System.out.println(window);
//		}
		
		
		for(String window : windows) {
			driver.switchTo().window(window);
			String header = driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
			if(header.equals("Locators and Selenium Interactions")) {
				String title = driver.getTitle();
				Assert.assertEquals(title, "TestLeaf - Selenium Playground");
				driver.close();
			}
			
			driver.switchTo().window(windows.iterator().next());
			header=driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
			Assert.assertEquals(header, "Work with Windows");
			
		}
		
		
		
		
		
	}

	@Test
	public void windowTest2() {
		driver.get(AppProperties.TEST_LEAF_BASE_URL + "/pages/Window.html");
		driverHelper.click(By.xpath("//button[text()='Open Multiple Windows']"), timeOutInSeconds);

		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size() + " windows are opened");

	}

	@Test
	public void windowTest3() {
		driver.get(AppProperties.TEST_LEAF_BASE_URL + "/pages/Window.html");
		driverHelper.click(By.id("color"), 1, timeOutInSeconds);

		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			driver.switchTo().window(window);
			String header = driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
			if (!header.equals("Work with Windows")) {
//				String title = driver.getTitle();
//				Assert.assertEquals(title, "TestLeaf - Interact with Windows");

				driver.close();
			}

		}
		// driver.switchTo().window(driverHelper.getMainWindowhandle());

		driver.switchTo().window(windows.iterator().next());

	}

	@Test
	public void windowTest4() {
		driver.get(AppProperties.TEST_LEAF_BASE_URL + "/pages/Window.html");
		driverHelper.click(By.id("color"), 2, timeOutInSeconds);

		Common.sleep(5);
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			String header = driverHelper.getText(By.tagName("h1"), timeOutInSeconds);
			if (!header.equals("Work with Windows")) {
				driver.close();
			}

		}
		driverHelper.switchToMainWindow();

	}
}
