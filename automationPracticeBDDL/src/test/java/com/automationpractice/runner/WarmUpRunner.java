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
				
		},
		
		 glue= {
				 "com.automationpractice.steps"
				 
		 },
		 features = {"src/test/resources/features/feturesToolsQA/warm_up.feature"
				 
		 }
		
		,dryRun = true
		
		)

public class WarmUpRunner extends CommonSteps{
	
	@AfterClass
	public static void after() {
		closeDriver();
	}
	
}

