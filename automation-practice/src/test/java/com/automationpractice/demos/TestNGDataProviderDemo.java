package com.automationpractice.demos;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviderDemo {
	
	
	@DataProvider(name = "morgageData")
		public String [][] getData(){
			String [][] data = new String [][] {
				{"3.1","330000","15000","30"},
				{"3.75","270000","12000","15"},
				{"3.86","295000","35000","30"}
			};return data;
		}
	
	
	
	
	@Test(dataProvider = "morgageData")
	public void calculateMorgageMonthlyPayment(String ir, String tl, String dp, String l) {
		System.out.println("Interest rate :" + ir);
		System.out.println("Total loan : " +tl);
		System.out.println("DownPayment: "+ dp);
		System.out.println("Lenth: " + l);
		
	}

}
