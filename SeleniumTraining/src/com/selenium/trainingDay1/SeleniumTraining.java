package com.selenium.trainingDay1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SeleniumTraining {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suraj\\Desktop\\Selenium Jar\\"
				+ "Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://phptravels.org/register.php");
		System.out.println(driver.getTitle());
		
		
		driver.findElement(By.id("inputFirstName")).sendKeys("Suraj");
		driver.findElement(By.id("inputLastName")).sendKeys("Singh");
		driver.findElement(By.id("inputEmail")).sendKeys("testing@gmail.com");
		WebElement countryList = driver.findElement(By.xpath("//span[@class='dial-code'][contains(text(),'+91')]"));
				
		driver.findElement(By.className("iti-arrow")).click();
		
		Thread.sleep(2000);
		
		countryList.click();
		
		driver.findElement(By.id("inputPhone")).sendKeys("7458142536");
		driver.findElement(By.id("inputAddress1")).sendKeys("Hinjewadi");
		driver.findElement(By.id("inputAddress2")).sendKeys("Phase 3");
		driver.findElement(By.id("inputCity")).sendKeys("Pune");
		driver.findElement(By.id("stateinput")).sendKeys("West Bengal");
		driver.findElement(By.id("inputPostcode")).sendKeys("411057");
		
		Select drpCountry = new Select(driver.findElement(By.id("inputCountry")));
		drpCountry.selectByVisibleText("India");
		
		Select customeField1 = new Select(driver.findElement(By.id("customfield1")));
		customeField1.selectByValue("Friend");
		
		driver.findElement(By.id("customfield2")).sendKeys("7485142536");
		driver.findElement(By.id("inputNewPassword1")).sendKeys("Ramram@01");
		driver.findElement(By.id("inputNewPassword2")).sendKeys("Ramram@01");
		
		//driver.findElement(By.xpath("//button[contains(text(),'Generate Password')]")).click();
		driver.findElement(By.xpath("//span[@class='bootstrap-switch-label']")).click();
		
		//driver.findElement(By.id("recaptcha-anchor")).click();
		
		Thread.sleep(9000);
		
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
		
		driver.close();
		
	     
		

	}

}
