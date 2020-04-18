package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Login;
import com.qa.pages.Password;

public class LoginTest extends TestBase {

	Login loginpage;
	Password passwordpage;
	public LoginTest() {
		super();	
	}
	
	@BeforeMethod
	public void Setup() throws IOException {
		TestBase tb = new  TestBase();
		tb.initialization();
		loginpage = new Login();
		passwordpage = new Password();
	}
	
	
	@Test(priority = 1)
	public void LoginPageTitelTest(){
		String Title = loginpage.Validate_Login_Page_Title();
		Assert.assertEquals(Title, "e-Hospital@NIC Govt. of India", "Login Page Title Did Not Match ");
	}
	
	@Test (priority = 2)
	public void eHospitalLogoTest(){
		boolean Logo = loginpage.Validate_Logo();
		Assert.assertTrue(Logo);
	}
	
	@Test (priority = 3)
	public void UsernameTest(){
		loginpage.Login(prop.getProperty("Username"));
		loginpage.SelectModule(prop.getProperty("Module"));
		//loginpage.Clicking_Signin_Button();
		passwordpage =  loginpage.Clicking_Signin_Button();
	}
	
	@AfterMethod
	public void Teardown(){
     driver.quit();
	}
	

}
