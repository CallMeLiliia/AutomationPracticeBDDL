package com.automationpractice.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.automationpractice.utilities.CommonSteps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		        plugin= {
		        	"html:target/cucumber_report"	
		        	,"json:target/cucumber_report/cucumber.json"	
		        	,"rerun:target/failed_scenarios/rerun.txt"
		        	
		        },
		        features = { "src/test/resources/features" }, 
	         	glue = { 
	         			"com.automationpractice.steps" }, 
	         	tags= {
//	         			"@login"
	         			"@wip"
	         			}
//	         	,monochrome = true
 //             ,dryRun = true
                               )
public class Runner extends CommonSteps {
	@AfterClass
	public static void after() {
		closeDriver();
	}

}
