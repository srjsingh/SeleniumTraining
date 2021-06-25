package com.selenium.trainingday6;


import org.testng.annotations.Test;

public class PriorityConcept {
	
	@Test(priority = 4)
	public void a() {
		System.out.println("a");
	}
	
	@Test(priority = 3)
	public void b() {
		System.out.println("b");
	}
	
	@Test(priority = 2)
	public void c() {
		System.out.println("c");
	}
	
	@Test(priority = 1)
	public void d() {
		System.out.println("d");
	}

}
