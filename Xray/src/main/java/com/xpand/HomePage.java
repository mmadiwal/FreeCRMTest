package com.xpand;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	
	Properties prop;
	WebDriver driver;
	
	public  Properties getProperties() {
		
		File file = new File("C:/JiraDemo/JiraSeleniumDemo/src/main/java/com/crm/qa/config/config.properties");
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public WebDriver initialization() {
		//System.out.println(prop.getProperty("username"));
		 System.setProperty("webdriver.chrome.silentOutput", "true");
		  //set the path of the driver executable file 
		  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe"); 
		  // open the browser 
		  driver = new ChromeDriver();
		  //Maximize the browser
		  driver.manage().window().maximize();
		  //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		  //Enter the URL and navigate to Lopin page 
		  driver.get("https://ui.freecrm.com/"); 
		  //Get the LoginPage titile"prop.get
		  String title=driver.getTitle();
		return driver;
		
	}
	public static void main(String[] args) {
		HomePage hp=new HomePage();
		Properties prop=hp.getProperties();
		System.out.println(prop.getProperty("username"));
	}

}
