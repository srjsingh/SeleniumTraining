package com.selenium.trainingday2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriver {

	public static void main(String[] args) {
		
		WebDriver driver = new HtmlUnitDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://html.com/input-type-file/");
		
		System.out.println("Execution started");
		
		driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\Suraj\\Documents\\Suraj_Singh_Resume.docx");
		
		System.out.println("Execution ends");
		
		driver.close();


	}

}
