package com.WalletHub.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WalletHub.Tests.BaseClass;

public class WalHubPostReviewObjects extends BaseClass{
	
	WebDriverWait wait=new WebDriverWait(driver,20);
	Actions action = new Actions(driver);
	
	
	public WalHubPostReviewObjects()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH, using = "//span[@class = 'brgm-button brgm-signup']") private WebElement btnLoginORSignUp;
	@FindBy(how=How.XPATH, using = "//span[@class='nav-txt' and text()= 'Reviews']") private WebElement btnReviews;
	@FindBy(how=How.XPATH, using = "//input[@name='em']") private WebElement txtEmail;
	@FindBy(how=How.XPATH, using = "//input[@name='pw']") private WebElement txtPswrd;
	@FindBy(how=How.XPATH, using = "//button[@class ='btn blue center reg-tabs-bt touch-element-cl']") 
	private WebElement btnlogin;
	@FindBy(how=How.XPATH, using = "//div[@class='review-action ng-enter-element']//review-star//div[@class='rating-box-wrapper']") 
	private WebElement stars;
	@FindBy(how=How.XPATH, using = "//div[@class='review-action ng-enter-element']//review-star//div[@class='rating-box-wrapper']//*[name()='svg'][4]") 
	private WebElement star4;
	@FindBy(how=How.XPATH, using = "//span[@class='dropdown-placeholder' and @ng-reflect-clean-h-t-m-l='Select...']") 
	private WebElement dropDownItem;
	@FindBy(how=How.XPATH, using = "//textarea[@placeholder='Write your review...']") 
	private WebElement txtReviewArea;
	@FindBy(how=How.XPATH, using = "//div[text()='Submit']") 
	private WebElement btnSubmit;
	@FindBy(how=How.XPATH, using = "//div[@class='rvc-header']/h4") private WebElement txtReviewPosted;
	@FindBy(how=How.XPATH, using = "//div[@class=\"pr-rec-item pr-rec-item-first-row\"]//review-star[@ng-reflect-rating='4']")
	private WebElement starValidate;
	@FindBy(how=How.XPATH, using = "//li[@ng-reflect-clean-h-t-m-l='Health Insurance']")
	private WebElement itemHealthIns;
	
	public void clickLoginORSignUp()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnLoginORSignUp));
		btnLoginORSignUp.click();
	}
	public void enterEmail(String email)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
		txtEmail.sendKeys(email);
	}
	public void enterPswrd(String pswrd)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txtPswrd));
		txtPswrd.sendKeys(pswrd);
	}
	public void hitLogin()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnlogin));
		btnlogin.click();
	}
	public void hitReviews()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnReviews));
		btnReviews.click();
	}
	public void hoverToStar()
	{
		wait.until(ExpectedConditions.visibilityOf(star4));
		action.moveToElement(star4).perform();
	}
	public void clickOnStar()
	{
		wait.until(ExpectedConditions.visibilityOf(star4));
		action.moveToElement(star4).click().build().perform();
	}
	public void selectItemFromDropDown()
	{
		wait.until(ExpectedConditions.elementToBeClickable(dropDownItem));
		action.click(dropDownItem).pause(2000).build().perform();
		itemHealthIns.click();
	}
	public void enterReviewSubmit()
	{
		wait.until(ExpectedConditions.elementToBeClickable(txtReviewArea));
		txtReviewArea.sendKeys(REVIEWNOTE);
		wait.until(ExpectedConditions.visibilityOf(btnSubmit));
		btnSubmit.click();
	}
	public void assertReviewPosted()
	{	
		wait.until(ExpectedConditions.visibilityOf(txtReviewPosted));
		Boolean status = txtReviewPosted.isDisplayed();
		do
		{
			txtReviewPosted.isDisplayed();
			if(status = false)
			{
				wait.until(ExpectedConditions.visibilityOf(btnSubmit));
				btnSubmit.click();	
			}
		}while(status = true);
	}
	public void assertRatingProfile()
	{
		wait.until(ExpectedConditions.visibilityOf(starValidate));
		starValidate.isDisplayed();
	}
}
