package com.selenium.trainingday6;

import org.testng.annotations.Test;

public class InvocationCountConcept {
	
	@Test(invocationCount = 10)
	public void a() {
		System.out.println("a");
	}

}
