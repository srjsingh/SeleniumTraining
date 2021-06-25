package com.selenium.trainingday7;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkAndImageConcept {

	public static void main(String[] args) throws IOException, IOException {
	
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suraj\\Desktop\\Selenium Jar\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.freecrm.com");
		
		WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log In')]"));
		loginButton.click();
		
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.clear();
		email.sendKeys("srjsingh636@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("Ramram@01");
		
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		linkList.addAll(driver.findElements(By.tagName("img")));
		
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		for(int i = 0; i<=linkList.size(); i++) {
			
			String linkAttribute = linkList.get(i).getAttribute("href");
			if (linkAttribute != null && (!linkAttribute.contains("javascript"))) {
				
				activeLinks.add(linkList.get(i));
				
			}
			
		}
		
		
		for(int j = 0; j<=activeLinks.size(); j++) {
			
			HttpsURLConnection connection = (HttpsURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") + "----->" + response);
			
		}

	}

}
