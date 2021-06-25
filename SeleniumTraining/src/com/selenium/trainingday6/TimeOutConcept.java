package com.selenium.trainingday6;

import org.testng.annotations.Test;

public class TimeOutConcept {
	
	@Test(invocationTimeOut = 20)
	public void a() {
		System.out.println("a");
	}
	
	@Test()
	public void b() {
		System.out.println("b");
	}

}
