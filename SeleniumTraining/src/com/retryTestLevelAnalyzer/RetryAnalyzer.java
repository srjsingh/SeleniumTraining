package com.retryTestLevelAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//refer package 10 class

public class RetryAnalyzer implements IRetryAnalyzer{
	
	int count =0;
	int retry = 3;
	
	public boolean retry(ITestResult result) {
		
		if (count<retry) {
			
			count++;
			return true;
			
		} else {
			
			return false;

		}
		
	}

}
