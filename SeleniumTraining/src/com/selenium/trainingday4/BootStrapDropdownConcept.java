package com.selenium.trainingday4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropdownConcept {
	
	static int counter=0;

	public static void main(String[] args) {
			
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Suraj\\Desktop\\Selenium Jar"
					+ "\\Chrome Driver\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("https://phptravels.org/register.php");
			
			WebElement calendarDropdown = driver.findElement(By.
					xpath("//div[@class='iti-arrow']"));
			calendarDropdown.click();
			
			List<WebElement> countryList= driver.findElements(By
					.xpath("//div[@class='flag-container']//"
							+ "div[@class='selected-flag']//following-sibling::ul//"
							+ "descendant::li[contains(@class, 'country')]//"
							+ "div[@class='flag-box']//"
							+ "following-sibling::"
							+ "span[contains(@class,'country-name')]"));
		
			System.out.println(countryList.size());
			
			for(int i = 0; i<countryList.size(); i++) {
				
			//System.out.println(countryList.get(i).getText());	
				
				if (countryList.get(i).getText().startsWith("India")) {
					
					countryList.get(i).click();
					counter++;
					break;
					
				}
			
			
			}
			
			if (counter!=1) {
				
				System.out.println("Country not available");
				
			}
			
			driver.close();
	}

}
