package com.datadriven.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Initialization.LaunchBrowser;
import com.Locators.LoginLocators;
import com.Locators.TMULocators;
import com.excel.utility.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametrizedTest extends LaunchBrowser{
	


@Test
	public  void dataDriven() throws InterruptedException {
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
		 // WebDriver driver = null; 
		
		  Actions actions = new Actions(driver);
		//  LoginLocators login = new LoginLocators();
		
	      // Enter username
		 //Thread.sleep(3000);
			WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.username));
			username.sendKeys("tw01@taroepic.com");
			System.out.println("Username is entered");
			
			// Enter password
			WebElement password = driver.findElement(LoginLocators.password);
			password.sendKeys("taro@1234");
		      System.out.println("Password is entered");
		     
		          
			//Click on login button
			WebElement login = driver.findElement(LoginLocators.loginbtn);
		     login.click();
		
	
			System.out.println("User login successfully");
			
			System.out.println("--------------------");
		
		// get test data from excel:
		  Xls_Reader reader1 = new 
				  Xls_Reader("/Users/bharti.gharde/Documents/Bharti/BasicsOfAutomation/Taroworks/src/test/java/com/testdata/Book 1.xlsx");
		int rowCount = reader1.getRowCount("Taroworks");
		
		//Parametrization: - Parametrization is always done for for-loop
		for (int rowNum = 2; rowNum<=rowCount; rowNum++) {
			
			System.out.println("-----------------------");
			//click on new button for TMU
			Thread.sleep(3000);
			WebElement clickNewBtn = wait.until(ExpectedConditions.elementToBeClickable(TMULocators.newbtnfortmu));
			clickNewBtn.click();
			System.out.println("Create TMU page opened");
		
			
	  	String firstname1= reader1.getCellData("Taroworks", "firstname", rowNum);
	  	System.out.println(firstname1);
	  	
	  	String lastname1 = reader1.getCellData("Taroworks", "lastname", rowNum);
	  	System.out.println(lastname1);
	  	
	  	String Email  = reader1.getCellData("Taroworks", "Email", rowNum);
	  	System.out.println(Email );
	  	
	  	String Phone = reader1.getCellData("Taroworks", "Phone", rowNum);
	  	System.out.println(Phone);
	  	
	  	String MobileNo = reader1.getCellData("Taroworks", "MobileNo", rowNum);
	  	System.out.println(MobileNo);
	  	
	  	String Alias = reader1.getCellData("Taroworks", "Alias",rowNum);
	  	System.out.println(Alias);
	  	
	  	String Username = reader1.getCellData("Taroworks", "Username", rowNum);
	  	System.out.println(Username);
	  	
	
		// webdriver code
		  
		//Select salutation
	  	       //driver.findElement(TMULocators.Salutation).clear();
			WebElement salutation = wait.until(ExpectedConditions.visibilityOfElementLocated(TMULocators.Salutation));
			salutation.click();
			Thread.sleep(1000);
			actions.sendKeys(Keys.ARROW_DOWN).perform();
			actions.sendKeys(Keys.ENTER).click().build().perform();
			System.out.println("Salutation is selected");
			
			
			//Click on first name field
			 driver.findElement(TMULocators.firstnamefield).clear();
			WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(TMULocators.firstnamefield));
			firstname.sendKeys(firstname1);
			System.out.println("Firstname is entered");
			
			//Click on last name field
			 driver.findElement(TMULocators.lastnamefield).clear();
			WebElement lastname =driver.findElement(TMULocators.lastnamefield);
			lastname.sendKeys(lastname1);
			System.out.println("Lastname is entered");
			
			//click on account field and select one partner account
			 driver.findElement(TMULocators.accountfield).clear();
			WebElement account = driver.findElement(TMULocators.accountfield);
			account.click();
			account.sendKeys("automationuser");
			Thread.sleep(2000);
			account.sendKeys(Keys.ARROW_DOWN);
			account.sendKeys(Keys.ENTER);
			System.out.println("Selected partner account");
			
			// click on email field
			 driver.findElement(TMULocators.emailfield).clear();
			WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(TMULocators.emailfield));
			email.sendKeys(Email);
			System.out.println("Email is entered");
			
			//click on phone field
			 driver.findElement(TMULocators.phonefield).clear();
			WebElement phone = driver.findElement(TMULocators.phonefield);
			phone.sendKeys(Phone);
			System.out.println("Phone number is entered");
			
			//click on mobile field
			 driver.findElement(TMULocators.mobilefield).clear();
			WebElement mobile = driver.findElement(TMULocators.mobilefield);
			mobile.sendKeys(MobileNo);
		   System.out.println("Mobile number is entered");
			
			//Click on Alias field
		   driver.findElement(TMULocators.aliasfield).clear();
		WebElement alias = driver.findElement(TMULocators.aliasfield);
			alias.sendKeys(Alias);
			System.out.println("Alias is entered");
			
			//click on username field
			 driver.findElement(TMULocators.usernamefield).clear();
			WebElement usernamefield = driver.findElement(TMULocators.usernamefield);
			usernamefield.sendKeys(Username);
			System.out.println("username is entered");
					
			//Select Profile as Taroworks Partner user
			// driver.findElement(TMULocators.profilefield).clear();
			  WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(TMULocators.profilefield));
			  profile.click();
			  Thread.sleep(1000);
			  actions.sendKeys(Keys.ARROW_DOWN).perform();
			  Thread.sleep(1000);
			  actions.sendKeys(Keys.ENTER).click().build().perform();
			  System.out.println("Profile is selected");
			  
			  //Select English as Language 
			  //driver.findElement(TMULocators.languagefield).clear();
			  WebElement language = wait.until(ExpectedConditions.visibilityOfElementLocated(TMULocators.languagefield));
			  language.click();
			  Thread.sleep(1000);
			       actions.sendKeys(Keys.ARROW_DOWN).perform();
				   Thread.sleep(1000);
				   actions.sendKeys(Keys.ARROW_DOWN).perform();
				   actions.sendKeys(Keys.ARROW_DOWN).perform();
				   actions.sendKeys(Keys.ARROW_DOWN).perform();
				   actions.sendKeys(Keys.ARROW_DOWN).perform();
				   actions.sendKeys(Keys.ENTER).click().build().perform();	   
				   System.out.println("Language selected");
				   
				   // Click on Save button
					
					  WebElement clickSaveBtn =
					  wait.until(ExpectedConditions.elementToBeClickable(TMULocators.saveBtn));
					  clickSaveBtn.click(); System.out.println(" Save button is clicked");
					  Thread.sleep(2000);
					 
					  System.out.println("------------------");
					  Thread.sleep(2000);
					  
					  // click on Cancel button 
						
						/*
						 * WebElement cancel =
						 * wait.until(ExpectedConditions.visibilityOfElementLocated(TMULocators.
						 * cancelBtn)); cancel.click(); System.out.println("Cancelled successfully");
						 * Thread.sleep(2000);
						 */
					  
					// Click on Taroworks Tab
					  Thread.sleep(1000);
					  WebElement taroworksTabClick = wait.until(ExpectedConditions.visibilityOfElementLocated(TMULocators.taroworksTab));
					  JavascriptExecutor executor = (JavascriptExecutor)driver;
				      executor.executeScript("arguments[0].click();", taroworksTabClick);
					//  taroworksTabClick.click();
					  System.out.println("Clicked on Taroworks Mobile User Tab");
					  Thread.sleep(2000);
					  System.out.println("-------------------------");
		}
				
	}
		
	}
    


