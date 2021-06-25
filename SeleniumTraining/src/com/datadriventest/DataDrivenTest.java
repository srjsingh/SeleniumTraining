package com.datadriventest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {
	
	public static void  main(String[] args) {
		
		
		Xls_Reader reader = new Xls_Reader("E:\\Eclipse_workspace\\"
				+ "SeleniumTraining\\src\\com\\testdata\\Book1.xlsx");
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suraj\\Desktop\\Selenium Jar\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://facebook.com");
		
		WebElement emailField = driver.findElement(By.id("email"));
		WebElement passwordField = driver.findElement(By.id("pass"));
		
		
		String emailData = reader.getCellData("Sheet1", "email", 2);
		String passwordData = reader.getCellData("Sheet1", "password", 2);
		System.out.println(emailData + "\n" + passwordData);
		
		emailField.clear();
		emailField.sendKeys(emailData);
		
		passwordField.clear();
		passwordField.sendKeys(passwordData);
		
	}

}
