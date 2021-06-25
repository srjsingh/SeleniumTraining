package com.selenium.trainingday10;

import org.testng.annotations.Test;

public class RuntimeRetryConcept {
	
	//Refer xml file

	@Test()
	public void test1() {
		
		System.out.println("test1");
		
		int i = 9/0;
		
	}
	
	@Test
	public void test2() {
		
		System.out.println("test2");
		
		int i = 9/0;
		
	}
	
	@Test
	public void test3() {
		
		System.out.println("test3");
		
	}
	
}
