package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Home;
import com.qa.pages.Login;
import com.qa.pages.Password;
import com.qa.util.TestUtil;

public class PasswordTest extends TestBase  {
	Password passwordpage;
	Login loginpage;
	TestUtil testutil;
	Home homepage;
	public PasswordTest() {
		super();	
	}
	@BeforeMethod
	public void Setup() throws IOException {
		TestBase tb = new  TestBase();
		tb.initialization();
		loginpage = new Login();
		testutil = new 	TestUtil();
		homepage = new  Home();
		//passwordpage = new Password();
		loginpage.Login(prop.getProperty("Username"));
		loginpage.SelectModule(prop.getProperty("Module"));
		passwordpage = loginpage.Clicking_Signin_Button();

		
	}
	
	@Test(priority = 1)
	public void verify_password_page_Title(){
		String passwordpagetitle  = passwordpage.Verify_Password_Title();
		Assert.assertEquals(passwordpagetitle, "e-Hospital@NIC Govt. of India"," Password Page Title Did Not Match ");	
	}
	
	@Test(priority = 2)
	public void Verify_Username_is_Displayed_Test(){
		Boolean usernamedisplayed = passwordpage.VerifyUsername();
		Assert.assertTrue(usernamedisplayed);
	}
	@Test(priority = 3)
	public void Enter_Password_Test() throws InterruptedException{
		passwordpage.Enter_Password(prop.getProperty("Password"));
		passwordpage.Password_Signin_Button();
		//testutil.SwitchToParentFrame();
		testutil.MainFrame();
		testutil.BannerFrame();
		homepage.Logout_Application();
		testutil.SwitchToAlert_Accept();
	}
	
	@Test(priority = 4)
	public void ClickingForgot_Password_Test(){
		passwordpage.Click_Forgot_Password();
	}
	
	@Test(priority = 5)
	public void Use_Another_user_Test() throws IOException{
		loginpage = passwordpage.Use_Another_Account();
		
	}
	
	
	@AfterMethod
	public void Teardown(){
     driver.quit();
	}
}
