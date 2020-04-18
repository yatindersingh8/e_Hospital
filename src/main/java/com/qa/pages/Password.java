package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class Password extends TestBase{
	
	@FindBy(id = "txt_pwd")
	WebElement Password;
	
	@FindBy(xpath= "//*[@id=\"loginprep\"]/div[2]/div/button")
	WebElement PWDSigninButton;
	
	@FindBy (xpath = "//*[@id=\"loginprep\"]/div[2]/div/a")
	WebElement ForgotPassword;
	
	@FindBy (xpath= "/html/body/div[2]/div/div/div/div[3]/a")
	WebElement UseAnotherAccount;
	
	@FindBy (xpath = "/html/body/div[2]/div/div/div/div[1]/strong")
	WebElement UsernameDetails;

	
	public Password(){
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String Verify_Password_Title(){
		return driver.getTitle();
	}
	 
	public void Enter_Password(String Pwd){
		Password.sendKeys(Pwd);
	}
	
	public Home Password_Signin_Button(){
		
		PWDSigninButton.click();
		return new Home();
		
	}
	
	public PasswordRecovery Click_Forgot_Password(){
		ForgotPassword.click();
		return new PasswordRecovery();
	}
	
	public boolean VerifyUsername(){
		return UsernameDetails.isDisplayed();
	}
    
	public Login Use_Another_Account() throws IOException {
		UseAnotherAccount.click();
		return new Login();
	}

}
