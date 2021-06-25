package com.selenium.trainingday3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsSelectedIsDisplayedIsEnabledConcept {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suraj\\Desktop\\Selenium Jar\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		System.out.println(driver.findElement(By.xpath("//button[text()='Log In']")).isDisplayed());

		System.out.println(driver.findElement(By.xpath("//button[text()='Log In']")).isEnabled());
		
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Suraj");
		
		Boolean c = driver.findElement(By.xpath("//input[@name='sex'][@value='2']")).isSelected();
		System.out.println(c);
		
		if (c==true) {
			
			driver.findElement(By.xpath("//input[@name='sex'][@value='2']")).click();
			System.out.println("clicked");
			
		}
		else {
			System.out.println("not clicked");
		}
		
		driver.close();

	}

}
