package com.selenium.trainingday6;

import org.testng.annotations.Test;

public class DependsOnConcept {


	@Test()
	public void a() {
		System.out.println("a");
		int i= 9/0;
	}
	
	@Test(dependsOnMethods = "a")
	public void b() {
		System.out.println("b");
	}
	
	@Test(dependsOnMethods = "b")
	public void c() {
		System.out.println("c");
	}
	
	@Test(dependsOnMethods = "c")
	public void d() {
		System.out.println("d");
	}
	
}
