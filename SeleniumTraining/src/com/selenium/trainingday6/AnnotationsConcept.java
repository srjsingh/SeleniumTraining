package com.selenium.trainingday6;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsConcept {
	
	@BeforeSuite
	public void beforeSuite() {
		
		System.out.println("before suite");
	}
	
	@BeforeClass
	public void beforeClass() {
		
		System.out.println("before class");
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("before method");
	}
	
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("before test");
	}
	
	@Test()
	public void test1() {
		
		System.out.println("test1");
	}
	
	@Test()
	public void test2() {
		
		System.out.println("test2");
	}
	
	@AfterClass
	public void afterClass() {
		
		System.out.println("after class");
	}
	
	@AfterSuite
	public void afterSuite() {
		
		System.out.println("after suite");
	}
	
	@AfterTest
	public void afterTest() {
		
		System.out.println("after test");
	}
	
	@AfterMethod
	public void afterMethod() {
		
		System.out.println("after method");
	}

}
