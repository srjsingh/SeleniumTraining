package com.selenium.trainingDay1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveMouseConcept {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suraj\\Desktop\\Selenium Jar\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://spicejet.com/");
		
		Actions action = new Actions(driver);
		
		action .moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		
		Thread.sleep(2000);
		
		//action.moveToElement(driver.findElement(By.xpath("//a[text()='Priority Check-in']"))).build().perform();
		driver.findElement(By.xpath("//a[text()='Priority Check-in']")).click();
		
		driver.close();
		
	}

}
