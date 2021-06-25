package com.selenium.trainingday3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {
	
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suraj\\Desktop\\Selenium Jar"
				+ "\\Chrome Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.crm.com/");
		
		WebElement talkToSalesButton =   driver.findElement(By.
				xpath("//a[contains(text(),'TALK TO SALES')]"));
		
		flash(talkToSalesButton, driver);
		
		drawBorder(talkToSalesButton, driver);
		
		generateAlert(driver, "Just a test");
		
		driver.switchTo().alert().accept();
		
		clickElementByJS(driver, talkToSalesButton);
		
		refreshPageByJS(driver);
		
		System.out.println(getPageTitleByJS(driver));
		
		System.out.println(getPageInnerTextByJS(driver));
		
		scrollingDownByJS(driver);
		
		WebElement submitButton = driver.findElement(By.
				xpath("//input[@type='submit'][@value='SUBMIT']"
						+ "[@class='wpcf7-form-control wpcf7-submit "
						+ "btnPrimary btnPrimary--long']"));
		
		scrollingIntoViewByJS(driver, submitButton);
		
		driver.close();

	}
	
	public static void flash(WebElement element, WebDriver driver) {
		
		String bgColor = element.getCssValue("backgroundColor");
		
		//System.out.println(bgColor);
		
		for (int i = 0; i < 100; i++) {
			
			changeColor("rgb(0,128,0)", element, driver);
			changeColor(bgColor, element, driver);
		}
		
	}
	
	public static void changeColor(String color, 
			WebElement element, WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		
		try {
			
			Thread.sleep(20);
			
		} catch (InterruptedException e) {
		}
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid black'", element);
		
	}
	
	public static void generateAlert(WebDriver driver, String message) {
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
		
	}
	
	public static void clickElementByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public static void refreshPageByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
		
	}
	
	public static String getPageInnerTextByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String pageText = js.executeScript("return document.documentElement.innerText;")
				.toString();
		return pageText; 
		
	}
	
	public static String getPageTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
		
	}
	
	public static void scrollingDownByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	public static void scrollingIntoViewByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}

}
