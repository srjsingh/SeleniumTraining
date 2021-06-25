package com.selenium.trainingday5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowserWithChrome {
	
	static int counter = 0;

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suraj\\Desktop\\Selenium Jar"
				+ "\\Chrome Driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		WebElement searchBar = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		searchBar.sendKeys("selenium");
		
		List<WebElement> suggestionList= driver.findElements(By.xpath("//div[@class='aajZCb']//ul//descendant::"
				+ "li//div[@class='eIPGRd']//div[@class='pcTkSc']"
				+ "//div[contains(@class, 'wM6W7d')]"));
		
		System.out.println(suggestionList.size());
		
		for(int i = 0; i<suggestionList.size(); i++) {
			
		
		System.out.println(suggestionList.get(i).getText());
			
		if (suggestionList.get(i).getText().
				contains("selenium webdriver")) {
			
			suggestionList.get(i).click();
			counter++;
			break;
			
		}
		
	}
		
		if(counter != 1) {
			System.out.println("Searced suggestion not available");
		}
		
		driver.close();

	}

}
