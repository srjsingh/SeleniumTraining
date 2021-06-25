package com.selenium.trainingday2;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopupHandling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suraj\\Desktop\\Selenium Jar\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/popup.php");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		System.out.println(driver.getTitle());
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		String parentWindow = it.next();
		
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//input[@name='emailid']"))
		.sendKeys("srj@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		
	}

}
