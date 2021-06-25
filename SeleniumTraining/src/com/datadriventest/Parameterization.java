package com.datadriventest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class Parameterization {

	public static void main(String[] args) {
		
		int colFlag = 0;
		
		Xls_Reader reader = new Xls_Reader("E:\\Eclipse_workspace\\"
				+ "SeleniumTraining\\src\\com\\testdata\\Book1.xlsx");
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Suraj\\Desktop\\Selenium Jar\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://facebook.com");
		
		WebElement emailField = driver.findElement(By.id("email"));
		WebElement passwordField = driver.findElement(By.id("pass"));
		
		int rowNum = reader.getRowCount("Sheet1");
		
		int colNum = reader.getColumnCount("Sheet1");
		System.out.println(colNum);
		
		for(int col=1; col<=colNum; col++) {
			
			String colName = reader.getCellData("Sheet1", col, 1);
			
			if(colName.equals("Status"))
				++colFlag;
			
		}
		
		
		if(colFlag!=1) {
			
		reader.addColumn("Sheet1", "Status");
		
		}
		for(int row = 2; row<=rowNum; row++) {
			
		String emailData = reader.getCellData("Sheet1", "email", row);
		String passwordData = reader.getCellData("Sheet1", "password", row);
		
		emailField.clear();
		emailField.sendKeys(emailData);
		
		passwordField.clear();
		passwordField.sendKeys(passwordData);
		
		reader.setCellData("Sheet1", "Status", row, "pass"); //write data into cell
		
		}
		
		driver.quit();

	}

}
