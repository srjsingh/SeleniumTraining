package com.selenium.trainingDay1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpAndAlertHandling {

	public static void main(String[] args) {
	
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suraj\\Desktop\\Selenium Jar\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		String alertText = alert.getText();
		
		if (alertText.equals("Please enter a valid user name")) {
			
			System.out.println("Correct alert");
			alert.accept();
			
		}
		else {
			
			System.out.println("Wrong alert");
			
		}
		
		driver.close();

	}

}
