package com.automationpractice.login;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertDemo {
	@Test
	public void testOne() {
		
		
		String a ="abc";
		 Assert.assertEquals(a, "abcm");
	}

}
