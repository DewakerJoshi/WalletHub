package com.WalletHub.Tests;

import org.testng.annotations.Test;

import com.WalletHub.Objects.WalHubPostReviewObjects;


public class WalHubPostReviewTest extends BaseClass{
		
	@Test
	public void postReviewTest() 
	{
	
		WalHubPostReviewObjects whLoginPage = new WalHubPostReviewObjects();
		
		driver.get(walletHubLoginURL);
		driver.manage().window().maximize();
		logger.info("URL is entered");
		waitForLoad(driver);
		whLoginPage.clickLoginORSignUp();
		whLoginPage.enterEmail(email);
		whLoginPage.enterPswrd(pswrd);
		whLoginPage.hitLogin();
		whLoginPage.hitReviews();
		whLoginPage.hoverToStar();
		whLoginPage.clickOnStar();
		logger.info("Clicked on stars");
		whLoginPage.selectItemFromDropDown();
		whLoginPage.enterReviewSubmit();
		driver.get(PROFILE_URL);
		waitForLoad(driver); 
		whLoginPage.assertReviewPosted();
		whLoginPage.assertRatingProfile();
			

}
}
