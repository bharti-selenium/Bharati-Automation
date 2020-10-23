package com.login_taroworks;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;

import javax.swing.Action;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.Initialization.LaunchBrowser;
import com.Locators.LoginLocators;
import com.Locators.TMULocators;
import com.excel.utility.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Compiler.Default.Harmonizer;

public class LoginPage extends LaunchBrowser {
	
	
	private static final String TakesScreenshot = null;

	// Login with user creds in salesforce
	@Test(enabled=true, priority = 1)
public void loginPage() throws InterruptedException, IOException {
	WebDriverWait wait = new WebDriverWait(driver, 14);
	SoftAssert loginpage = new SoftAssert();
	
	 Xls_Reader reader = new Xls_Reader("/Users/bharti.gharde/Documents/Bharti/BasicsOfAutomation/Taroworks/src/test/java/com/testdata/Book 1.xlsx");
	    
		String username1 = reader.getCellData("Taroworks", "username", 2);
		System.out.println(username1);
		
			String password1 = reader.getCellData("Taroworks", "password", 2);
			System.out.println(password1);
	
              // Enter username
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginLocators.username));
		username.sendKeys("tw01@taroepic.com");
		System.out.println("Username is entered");
		
		// Enter password
		WebElement password = driver.findElement(LoginLocators.password);
		password.sendKeys("taro@1234");
	      System.out.println("Password is entered");
	      takeScreenshot("Login_page");
	    
	          
		//Click on login button
		WebElement login = driver.findElement(LoginLocators.loginbtn);
	     login.click();
	    // takeScreenshot("Login_Page");
		
		
	     //  boolean actualloginbtn = login.isSelected();
	       
		System.out.println("User login successfully");
		
		System.out.println("--------------------");
			
	
	  
	}		
		// Take screenshot 
	public static void takeScreenshot(String filename) throws IOException {
		// Take screenshot and share it as file format
	File file =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// Copy the screenshot to desired location
	FileUtils.copyFile(file, new File("/Users/bharti.gharde/Documents/Bharti/BasicsOfAutomation/Taroworks/Screenshot/"+filename+".png"));
		}
	
	
	  // Create TMU user 
		@Test (enabled = true,priority = 3)
		public void tmuPage() throws InterruptedException, IOException {
			Thread.sleep(4000);
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 14);
		//click on new button for TMU
		WebElement clickNewBtn = wait.until(ExpectedConditions.elementToBeClickable(TMULocators.newbtnfortmu));
		clickNewBtn.click();
		System.out.println("Create TMU page opened");
		
		//Select salutation
		WebElement salutation = wait.until(ExpectedConditions.visibilityOfElementLocated(TMULocators.Salutation));
		salutation.click();
		Thread.sleep(1000);
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ENTER).click().build().perform();
		System.out.println("Salutation is selected");
	
		
		
		//Click on first name field
		WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(TMULocators.firstnamefield));
		firstname.sendKeys("Taro99");
		System.out.println("Firstname is entered");
		
		//Click on last name field
		WebElement lastname =driver.findElement(TMULocators.lastnamefield);
		lastname.sendKeys("Twent9");
		System.out.println("Lastname is entered");
		
		//click on account field and select one partner account
		WebElement account = driver.findElement(TMULocators.accountfield);
		account.click();
		account.sendKeys("automationuser");
		Thread.sleep(2000);
		account.sendKeys(Keys.ARROW_DOWN);
		account.sendKeys(Keys.ENTER);
		System.out.println("Selected partner account");
		
		// click on email field
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(TMULocators.emailfield));
		email.sendKeys("twentuser12@gmail.com");
		System.out.println("Email is entered");
		
		//click on phone field
		WebElement phone = driver.findElement(TMULocators.phonefield);
		phone.sendKeys("0127-76746");
		System.out.println("Phone number is entered");
		
		//click on mobile field
		WebElement mobile = driver.findElement(TMULocators.mobilefield);
		mobile.sendKeys("9988476655");
	   System.out.println("Mobile number is entered");
		
		//Click on Alias field
		WebElement alias = driver.findElement(TMULocators.aliasfield);
		alias.sendKeys("Auto777");
		System.out.println("Alias is entered");
		
		//click on username field
		WebElement usernamefield = driver.findElement(TMULocators.usernamefield);
		usernamefield.sendKeys("automation3@user.com");
		System.out.println("username is entered");
				
		//Select Profile as Taroworks Partner user
		  WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(TMULocators.profilefield));
		  profile.click();
		  Thread.sleep(2000);
		  actions.sendKeys(Keys.ARROW_DOWN).perform();
		  Thread.sleep(1000);
		  actions.sendKeys(Keys.ENTER).click().build().perform();
		  System.out.println("Profile is selected");
		  
		  //Select English as Language 
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
			
			
			   WebElement clickSaveBtn =  wait.until(ExpectedConditions.elementToBeClickable(TMULocators.saveBtn)); 
			  clickSaveBtn.click(); 
			  System.out.println(" Save button is clicked"); 
			  Thread.sleep(2000); 
			 			   
			  // click on Cancel button 
				/*
				 * WebElement cancel =
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(TMULocators.
				 * cancelBtn)); cancel.click(); System.out.println("Cancelled successfully");
				 * Thread.sleep(2000);
				 */
				 
			   
			   //Click on Save&New Button
				
				/*
				 * WebElement saveAndNewBtn =
				 * wait.until(ExpectedConditions.elementToBeClickable(TMULocators.saveAndNewBtn)
				 * ); saveAndNewBtn.click(); System.out.println("Save&New button is clicked");
				 * Thread.sleep(2000);
				 */
				  
            	}



// View profile
	@Test(enabled = false, priority =2)
	public void tapOnProfile() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 14);
		// Click on View profile
		//Thread.sleep(8000);
		/*
		 * Alert alert = driver.switchTo().alert(); alert.dismiss();
		 */
	
		WebElement viewprofile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='uiImage']")));
		viewprofile.click();
		Thread.sleep(2000);

		// Click on switch to Salesforce classic
		WebElement classic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Switch to Salesforce Classic")));
		classic.click();

		System.out.println("User switch to salesforce classic successfully");
		Thread.sleep(2000);
	    }

	@Test(enabled = false)
	public void createSurvey() throws InterruptedException {
		 Actions actions = new Actions(driver);
		// click on form tab
		// Thread.sleep(2000);

		// Use link list to locate the form tab
		
		/*
		 * List<WebElement> linkList = driver.findElements(By.name(""));
		 * System.out.println("Number of Elements:" +linkList.size());
		 * 
		 * for (int i=0 ; i<linkList.size() ; i++) {
		 * System.out.println(linkList.get(i));
		 * 
		 * if(linkList.get(i).getAttribute("title").contains("Forms Tab")) {
		 * linkList.get(i).click(); break; }
		 * 
		 * } System.out.println("Forms tab opened"); Thread.sleep(2000);
		 */
		 
		  Thread.sleep(10000); 
		  WebElement formBtn = driver.findElement(By.xpath("//a[@title='Forms Tab']")); 
		  actions.moveToElement(formBtn).click().build().perform(); 
		  //formBtn.click();
		 
		 
		Thread.sleep(2000);
		// Click on new form button to create new form
	    WebElement newFormbtn = driver.findElement(By.xpath("//input[@id='page:surveys:buttons:btnCreateNew']"));
	    actions.moveToElement(newFormbtn).click().build().perform();
		//newFormbtn.click();
		Thread.sleep(2000);
		
	
		// click on save and continue button in new form
		WebElement saveAndContinueBtn = driver.findElement(By.xpath("//button[@id='btnSaveContinue']"));
		saveAndContinueBtn.click();
	}
	
	
	
	
	/*
	 * @Test(enabled = false) public void TMU() throws InterruptedException {
	 * 
	 * Thread.sleep(12000); WebElement clickJob =
	 * driver.findElement(By.xpath("//div[@title='New']")); clickJob.click(); }
	 */
	}



