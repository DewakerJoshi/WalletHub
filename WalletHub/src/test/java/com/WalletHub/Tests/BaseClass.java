package com.WalletHub.Tests;
	import org.apache.log4j.Logger;
	import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Parameters;

import com.WalletHub.Utilities.ReadConfig;

		public class BaseClass {
		
		ReadConfig readconfig = new ReadConfig();	
		public String baseURL = readconfig.getApplicationURL();
		public String username = readconfig.getUsername();
		public String password = readconfig.getPassword();
		public String walletHubLoginURL = readconfig.getWalletHubURL();
		public String email = readconfig.getEmail();
		public String pswrd = readconfig.getPswrd();
		public static WebDriver driver;
		public static Logger logger;
		public String REVIEWNOTE = readconfig.getReviewNote();
		public String PROFILE_URL = readconfig.getProfileURL();
		//public WebDriverWait wait=new WebDriverWait(driver,20);
		
		@BeforeClass
		@Parameters("browser")
		public void setUp(String browser)
		{
			logger = Logger.getLogger("BaseClass");
			PropertyConfigurator.configure("Log4j.properties");
			
			
			if(browser.equalsIgnoreCase("chrome"))
			{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		    driver= new ChromeDriver(options);
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
			System.setProperty("webdriver.gecko.driver", "/AutomationFramwrkPrj/src/main/resources/Drivers/geckodriver.exe");
		    driver= new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("IE"))
			{
			System.setProperty("webdriver.ie.driver", "/AutomationFramwrkPrj/src/main/resources/Drivers/IEDriverServer.exe");
		    driver= new InternetExplorerDriver();
			}
			
			
		}

		@AfterClass
		public void tearDown()
		{
			driver.close();
		}
		
		
		 public void waitForLoad(WebDriver driver) {
		        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() 
		        {
		            public Boolean apply(WebDriver driver)
		            {
		                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
		            }
		         };
		         new WebDriverWait(driver, 30).until(pageLoadCondition);
		      }
		
		 public void waitForVisibility(WebDriver driver, By Locator)
		 {
			 WebDriverWait wait = new WebDriverWait(driver,30);
			 
	         wait.until(ExpectedConditions.visibilityOfElementLocated((Locator)));
		 }
		

		 //This method generates random string

	/*	 public String generateRandomString(){

		     StringBuffer randStr = new StringBuffer();
		     for(int i=0; i<RANDOM_STRING_LENGTH; i++){
		         int number = getRandomNumber();
		         char ch = CHAR_LIST.charAt(number);
		         randStr.append(ch);
		     }
		     return randStr.toString();
		 }*/
		 
		}
