package TestNGListenerConceptFailedScenarioScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver  driver;
	
	public static void initialization() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suraj\\Desktop\\"
				+ "Selenium Jar\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://google.com");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	public void failed(String name) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Eclipse_workspace\\SeleniumTraining\\src\\Screenshot\\" + name + ".png"));
		
	}

}
