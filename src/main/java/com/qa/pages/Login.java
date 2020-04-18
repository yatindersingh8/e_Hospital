package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class Login extends TestBase {


//pAGE fACTORY mODEL 
	//Username Textfiled
	@FindBy(id = "txtuid")
	 WebElement Username;
	//Module Dropdown
	@FindBy(id = "ddl_mod")
	 Select Module;
	//Features of Ehospital
	@FindBy(xpath="/html/body/div/div/div[2]/div[2]/div[1]/div/div[1]")
	WebElement Feature_of_ehospial;
	
	//About E-Hospital
	@FindBy (xpath="/html/body/div/div/div[2]/div[2]/div[2]/div/div[1]")
	WebElement About_eHsopital;
	
	//Signin Button 
	@FindBy (xpath= "//*[@id=\"loginform\"]/div[3]/div/button")
	WebElement LoginButton;
	
	//eHospital Logo
	@FindBy(xpath="/html/body/nav/a/img")
	WebElement Logo;
	
	//Initializing page Objects
	public Login() throws IOException {
		super();
		PageFactory.initElements(driver, this); // Initializing Page Factory variable
		
	}
	 //Actions
	
	public String Validate_Login_Page_Title(){
		return driver.getTitle();
	}
	
	public boolean Validate_Logo(){
		return Logo.isDisplayed();
	}
	
	public void  Login(String Un){   
		Username.sendKeys(Un);
		//return new Password();
	    }
	
	public void SelectModule(String Mo){
		String ModuleName = Mo;  
		if(ModuleName.equals("Registration"))
		{
		Select ModuleDropDown = new Select(driver.findElement(By.name(prop.getProperty("Module_name"))));
		ModuleDropDown.selectByValue("reg_url");
		}
		
		if(ModuleName.equals("Other Modules"))
		{
		Select ModuleDropDown = new Select(driver.findElement(By.name(prop.getProperty("Module_name"))));
		ModuleDropDown.selectByValue("default_url");
		}
		
		if(ModuleName.equals("Reports"))
		{
		Select ModuleDropDown = new Select(driver.findElement(By.name(prop.getProperty("Module_name"))));
		ModuleDropDown.selectByValue("rpt_url");
		}
		
		else
		{
			System.out.println("Invalid Module detail Entered");
		}
		
	}

	
	public void Selecting_Registration_Module(String mn){ // ModuleName is aligned for Module
		
		Module.selectByValue("reg_url");
		
	}
	
	public void Validate_Signin_Button(){
		LoginButton.isDisplayed();
		
	}
	
	public Password Clicking_Signin_Button(){
		LoginButton.click();
		return new Password();
		
	}
	public boolean Validating_Featureofehospital(){
		
		return Feature_of_ehospial.isDisplayed();
	}
	
    public boolean Validating_Aboutehospital(){
		
    	return About_eHsopital.isDisplayed();
	}

}
