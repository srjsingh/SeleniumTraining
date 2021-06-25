package com.selenium.trainingday6;

import org.testng.annotations.Test;

public class GroupingConcept {
	
	@Test(groups = "first")
	public void a() {
		System.out.println("a");
	}
	
	@Test(groups = "first")
	public void b() {
		System.out.println("b");
	}
	
	@Test(groups = "second")
	public void c() {
		System.out.println("c");
	}
	
	@Test(groups = "second")
	public void d() {
		System.out.println("d");
	}

}
