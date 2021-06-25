package com.selenium.trainingday6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidationConcept {
	
WebDriver driver;
	
	@BeforeMethod
	public  void browserSetup() {
		
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Suraj\\Desktop\\Selenium Jar"
			+ "\\Chrome Driver\\chromedriver.exe");
	
	 driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get("https://www.google.com/");
	
	}
	
	@Test
	 public void titleValidation() {
		 
		 String title = driver.getTitle();
		 
		 Assert.assertEquals(title, "Google", "title matched");
	 
		 driver.close();
		 
	 }


}
