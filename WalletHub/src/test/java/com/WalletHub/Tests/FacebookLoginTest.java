package com.WalletHub.Tests;

import org.testng.annotations.Test;
import com.WalletHub.Objects.FbLoginPageObjects;


public class FacebookLoginTest extends BaseClass{
	
	BaseClass baseClass = new BaseClass();
	
	@Test
	public void loginTest() throws InterruptedException
	{
	
		FbLoginPageObjects loginPage = new FbLoginPageObjects();
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL is entered");
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.hitLogin();
		baseClass.waitForLoad(driver);
		logger.info("PageLoaded completely");
		loginPage.enterMessage();
		logger.info("Enter message executed");
		loginPage.clickPost();
		logger.info("Posted");
		}
}
