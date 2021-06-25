package com.selenium.trainingday10;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGRetryConcept {
	
	SoftAssert softassert = new SoftAssert(); 
	
	@Test(retryAnalyzer = com.retryTestLevelAnalyzer.RetryAnalyzer.class)
	public void test1() {
		
		System.out.println("test1");
		
		
		softassert.assertEquals(false, true);
		
		System.out.println("Hello");
		System.out.println("Hi");
		
		softassert.assertAll();
	}
	
	@Test
	public void test2() {
		
		System.out.println("test2");
		
	}
	
	@Test
	public void test3() {
		
		System.out.println("test3");
		
	}
	
       

}
