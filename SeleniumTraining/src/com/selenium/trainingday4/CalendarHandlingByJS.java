package com.selenium.trainingday4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandlingByJS {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suraj\\Desktop\\Selenium Jar"
				+ "\\Chrome Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		
		WebElement calendarIcon = driver.findElement(By.id("departureCalendar"));
		
		//calendarIcon.click();	
		
		String date = "Thu, 6 Jan";
		
		selectDate(driver, calendarIcon, date);
		
		driver.close();
		
	}
	
	public static void selectDate(WebDriver driver, WebElement element, String dateVal) {
		
		JavascriptExecutor js = ((JavascriptExecutor)(driver));
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		
	}

}
