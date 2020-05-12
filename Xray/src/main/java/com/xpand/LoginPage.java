package com.xpand;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage extends TestBase{
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait (driver,20);
	
	@FindBy(name="email")
	
	WebElement emailID;
	
	@FindBy(name="password")
	
	WebElement password;
	
	@FindBy(linkText="Forgot your password?")
	
	WebElement link;
	
	@FindBy(xpath="//div[contains(@class,'ui fluid large blue submit button')]")
	
	WebElement LoginBTN;
	
	public LoginPage () {
		PageFactory.initElements(driver,this);
	}
	
	public static String getPageTitle(WebDriver driver, int timeout, String title){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	} 
	
	public  Boolean ValidateForgetyourPasswordLink(WebDriver driver) {
		
		return link.isDisplayed();
		
	}
	
	public static String GetActualURL(WebDriver driver, int timeout,String url) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.urlContains(url));
		return driver.getCurrentUrl();
		
	}
	
	public  void Login(String email,String pass,WebDriver driver,int timeout) {
		System.out.println("Inside login method");
		//WebElement loginButton=driver.findElement(By.xpath("//div[contains(@class,'ui fluid large blue submit button')]"));
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'ui fluid large blue submit button')]")));
		emailID.sendKeys(email);
		password.sendKeys(pass);
		LoginBTN.click();
		
	}

}
