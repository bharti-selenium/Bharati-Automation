package com.Initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
public static	WebDriver driver;


	// launch the browser
	/*
	 * @BeforeMethod public void launchBrowser() {
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
	 * System.out.println("Browser is launched successfully"); }
	 */

	// hit the Salesforce url
	@Test
	public void hitUrl() throws InterruptedException {
		
		// Launch the Chrome browser
		  WebDriverManager.chromedriver().setup(); 
		  driver = new ChromeDriver();
		  System.out.println("Chrome browser is launched successfully");
		 
		 
		 
		  // Launch the Firefox browser 
			
			
			/*
			 * Thread.sleep(4000); WebDriverManager.firefoxdriver().setup(); driver = new
			 * FirefoxDriver();
			 * System.out.println("Mozilla firefox browser is launched successfully");
			 */
			 			 
		  // Launch the opera browser
			/*
			 * Thread.sleep(3000); WebDriverManager.operadriver().setup(); driver = new
			 * OperaDriver(); System.out.println("Opera browser is launched successfully");
			 */
			 
			 
		  // Hit the Salesforce login url 
	    driver.get("https://login.salesforce.com/");
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    String title = 	driver.getTitle();
	    System.out.println(title);
	    String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		System.out.println("salesforce site is opened");
		System.out.println("----------------");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		 //Thread.sleep(4000);
	 
	}
	
}
