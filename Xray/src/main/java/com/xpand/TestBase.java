package com.xpand;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	static WebDriver driver;
	static Properties prop;
	
	public TestBase () {
		
			
		
	} 
	
		
		public static WebDriver initialization() {
			    System.setProperty("webdriver.chrome.silentOutput", "true");
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
				driver.get("https://ui.freecrm.com/");
				String title=driver.getTitle();
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.titleContains(title));
				System.out.println(driver.getCurrentUrl()) ;
				return driver;
			
		}
		
	}



