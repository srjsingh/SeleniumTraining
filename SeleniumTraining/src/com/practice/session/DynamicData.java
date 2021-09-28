package com.practice.session;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicData {

	static WebDriver driver;

	public static void main(String[] args) {

		String populationCounter = "//div[@class='maincounter-number']/span[@class='rts-counter']";

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suraj\\Desktop\\Selenium Jar\\Chrome Driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.worldometers.info/world-population/");

		while (true) {

			List<WebElement> populationList = driver.findElements(By.xpath(populationCounter));

			for (WebElement e : populationList) {

				System.out.println(e.getText());

			}

		}
	}

}
