package com.selenium.trainingday2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class ObjectRepositoryConcept {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		
		Properties pro = new Properties();
		FileInputStream io = new FileInputStream("E:\\Eclipse_workspace\\SeleniumTraining\\src\\repository.properties");
		
		pro.load(io);
		
		String browser = pro.getProperty("browser");
		
		if (browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Suraj\\Desktop\\Selenium Jar\\Chrome Driver\\chromedriver.exe");
			
		driver = new ChromeDriver();
			
		}
		else if (browser.equals("html")) {
			
		driver = new HtmlUnitDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(pro.getProperty("url"));
		
		driver.findElement(By.xpath(pro.getProperty("xpath_searchBar"))).sendKeys(pro.getProperty("search"));
		
		System.out.println("execution done");
		
		driver.close();

	}

}
