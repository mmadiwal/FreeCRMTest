package com.xpand;
 
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.Reporter;
import org.testng.reporters.XMLReporter;
import org.testng.ITestResult;


import com.xpand.annotations.Xray;
 
public class DemoTest {
	
	WebDriver driver;
	LoginPage loginpage;
	Properties prop;
	HomePage hp;
	
	public DemoTest() {
		
	}
 
    @BeforeSuite
    public void setUp() throws Exception {
 
    }
 
    @AfterSuite
    public void tearDown() throws Exception {
    }
 
 
    @Test
    @Xray( test ="XSD-4")
    public void loginPageTitleTest() { 
		  HomePage hp=new HomePage();
			Properties prop=hp.getProperties();
			driver=hp.initialization();
			String title =driver.getTitle();
		   Assert.assertEquals(title, "Cogmento CRM");
		  System.out.println("Login Page title verified successfully");
		  driver.quit();
		  }
 
	  
	  @Xray(test = "XSD-9") public void verifyUser() {
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
	  System.out.println("Verified user successfully"); 
	  //Closing the browser
	  driver.quit(); }
	 
    
	
}
