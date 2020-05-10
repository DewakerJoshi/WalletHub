package com.WalletHub.Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WalletHub.Tests.BaseClass;


public class FbLoginPageObjects extends BaseClass {
	
	WebDriverWait wait=new WebDriverWait(driver,20);

	public FbLoginPageObjects()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "email") private WebElement txtUserName;
	@FindBy(name = "pass") private WebElement txtPassWord;
	@FindBy(id = "loginbutton") private WebElement btnLogin;
	@FindBy(name = "xhpc_message") private WebElement txtMessageArea;
	@FindBy(how=How.XPATH, using = "//div[@class ='_45wg _69yt']/child::button[@type = 'submit']") private WebElement btnPost;
	
	public void enterUsername(String Username)
	{
		txtUserName.sendKeys(Username);
	}
	public void enterPassword(String Password)
	{
		txtPassWord.sendKeys(Password);
	}
	public void hitLogin()
	{
		btnLogin.click();
	}
	public void enterMessage() throws InterruptedException 
	{	
        wait.until(ExpectedConditions.visibilityOf(txtMessageArea));
		txtMessageArea.click();
		txtMessageArea.sendKeys("Hello World");
	}

	/*public void isAlertPresent(WebDriver driver)
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
		System.out.println("This is Alert Message");
	}*/
	
	
	public void clickPost() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(btnPost));
		btnPost.click();
	}
}
