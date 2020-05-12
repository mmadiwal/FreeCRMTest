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
 
    @Test
    @Xray(test ="XSD-2")
    public void loginTest() {
		  HomePage hp=new HomePage();
			Properties prop=hp.getProperties();
			driver=hp.initialization();
		  //Enter the UserName 
		driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
		//Enter the password
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		//Click on the Login Button
		driver.findElement(By.xpath("//div[contains(@class,'ui fluid large blue submit button')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String dealsText=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//span[contains(text(),'Deals')]"))).getText();
	    Assert.assertEquals(dealsText, "Deals");
	    System.out.println("Successfully able to login to the application ");
	    driver.quit();
	 	
}    
	
	  @Test
	  
	  @Xray(test = "XSD-9") public void verifyUser() {
	 HomePage hp=new HomePage();
	  Properties prop=hp.getProperties(); driver=hp.initialization();
	  driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
	  //Enter the password
	  driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
	  //Click on the Login Button 
	  driver.findElement(By.xpath("//div[contains(@class,'ui fluid large blue submit button')]")).click();
	  WebDriverWait wait = new WebDriverWait(driver,40); 
	  String userNme=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//span[contains(text(),'Mahant Madiwal')]"))).getText();
	  //Comparing both the texts 
	  Assert.assertEquals(userNme, "Mahant Madiwal");
	  System.out.println("Verified user successfully"); 
	  //Closing the browser
	  driver.quit(); }
	 
    
	/*
	 * @Test public void verifyDocumentsTab() { HomePage hp=new HomePage();
	 * Properties prop=hp.getProperties(); driver=hp.initialization();
	 * driver.findElement(By.name("email")).sendKeys("madiwal.m@gmail.com"); //Enter
	 * the password
	 * driver.findElement(By.name("password")).sendKeys("Alti@33533533"); //Click on
	 * the Login Button driver.findElement(By.
	 * xpath("//div[contains(@class,'ui fluid large blue submit button')]")).click()
	 * ; //Navigate to the documents tab boolean
	 * flag=driver.findElement(By.xpath("//span[contains(text(),'Documents')]")).
	 * isDisplayed(); Assert.assertTrue(flag);
	 * System.out.println("Verified Home Tab Successfully"); //Closing the browser
	 * driver.quit(); }
	 */
}