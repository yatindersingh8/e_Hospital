package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class Home extends TestBase {
	public Home(){
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "/html/body/div/div/div[3]/div[2]/div[1]/a[2]")
	WebElement patient_Registration;
	
	@FindBy(id = "sd2")
	WebElement new_registration;
	
	@FindBy(id = "btnlogout")
	WebElement logout;
	
	public String Home_Page_URl(){
		return driver.getCurrentUrl();
		
	}
	
	public void Click_patient_Registration(){	
		System.out.println("HI");
		patient_Registration.click();
		
	}
	 public NewRegistration Click_new_registration(){
		 new_registration.click();
		 return new NewRegistration();
		 
	 }
	 public void Logout_Application(){
		 logout.click();	 
	 }

}
