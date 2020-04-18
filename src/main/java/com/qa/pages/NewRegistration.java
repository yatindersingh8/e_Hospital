package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class NewRegistration extends TestBase {
	//TestUtil testutil;
	TestUtil testutil = new TestUtil();
	public NewRegistration(){
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "idCustom2_popup")
	WebElement entermobileNo_popup;
	
	@FindBy(id = "txt_mobile")
	WebElement entermobileNo_textbox;
	
	@FindBy(id = "btnSearch")
	WebElement entermobileNo_searchbutton;
	
	@FindBy(id = "patsearch")
	WebElement entermobileNo_searchresults;
	
	@FindBy(id = "idCustom2_cancelButton")
	WebElement entermobileNo_skip;
	
	@FindBy(xpath = "//*[@id=\"patient_name_patient_name_initials\"]")
	Select patient_initials;
	
	@FindBy(id="patient_name_patient_name_first")
	WebElement patient_firstname;
	
	@FindBy(id="patient_name_patient_name_last")
	WebElement patient_Lastname;
	
	@FindBy(id="fathers_name")
	WebElement patient_Fathername;
	
	
	public boolean newregistration(){
		return entermobileNo_popup.isDisplayed();	
	}
	
	public void Verify_Enter_Mobile_No_Textfield(){		
		entermobileNo_textbox.sendKeys("9899370619");		
	}
	public boolean Verify_Enter_Mobile_No_SearchButton_IsPresent(){		
		return entermobileNo_searchbutton.isDisplayed();
	}
	
	public void Verify_Enter_Mobile_No_SearchButton(){
		entermobileNo_searchbutton.click();
	}
	public boolean Verify_Enter_Mobile_No_SearchResults(){
		return entermobileNo_searchresults.isDisplayed();
	}
	public boolean Verify_Skip_Button(){
		return entermobileNo_skip.isDisplayed();
	}
	public void Click_Skip_Button(){
	    entermobileNo_skip.click();
	}
	
	public void Skipping_Mobile_No(){
        testutil.SwitchToParentFrame();
		testutil.SwitchMainFrame();
		entermobileNo_skip.click();
	}
	
	
	public void Select_Initial(String IN){
		//testutil.SwitchMainFrame();
		//patient_initials.selectByValue(IN);
		patient_initials.selectByVisibleText(IN);
		
	}
	
	public void Enter_Form(String FirstName , String LastName){
		patient_firstname.sendKeys(FirstName);
		patient_Lastname.sendKeys(LastName);
		//patient_Fathername.sendKeys(FatherName);
		
	}
	
}
