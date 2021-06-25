package com.selenium.trainingday9;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParametersTest {
	
	WebDriver driver;
	
	
	@Test
	@Parameters({"userNameData"})  //refer to testNG.xml file
	public void yatraTitleTest(String userNameData) throws IOException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suraj\\Desktop\\Selenium Jar"
				+ "\\Chrome Driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://yatra.com");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@class='dropdown-toggle' and text() = 'My Account']"))).build().perform();
		
		driver.findElement(By.id("signInBtn")).click();
		
		
		WebElement userName = driver.findElement(By.id("login-input"));
		
		userName.clear();
		userName.sendKeys(userNameData);
		
		driver.findElement(By.id("login-continue-btn")).click();
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Eclipse_workspace\\SeleniumTraining\\src\\yatra.png"));
	
		driver.quit();
		
	}

}
