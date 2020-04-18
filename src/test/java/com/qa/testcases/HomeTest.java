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

public class HomeTest extends TestBase {
	
	Password passwordpage;
	Login loginpage;
	Home homepage;
	TestUtil testutil;
	public HomeTest() {
		super();	
	}
	@BeforeMethod
	public void Setup() throws IOException {
		TestBase tb = new  TestBase();
		tb.initialization();
		loginpage = new Login();
		testutil = new 	TestUtil();
		loginpage.Login(prop.getProperty("Username"));
		loginpage.SelectModule(prop.getProperty("Module"));
		passwordpage = loginpage.Clicking_Signin_Button();
		passwordpage.Enter_Password(prop.getProperty("Password"));
		homepage = passwordpage.Password_Signin_Button();
		
	}
	
	@Test(priority = 1)
	public void verify_home_page_URL_Test(){
		 String homep = homepage.Home_Page_URl();
		 Assert.assertEquals(homep, "https://server1.ehospital.nic.in/ehospital/home");
		 testutil.MainFrame();
		 testutil.BannerFrame();
		 homepage.Logout_Application();
	}
     @Test(priority = 2)
     public void verify_patient_registration_link_Test(){
    	 testutil.MainFrame();
    	 testutil.SwitchMenuFrame();
    	 homepage.Click_patient_Registration();
    }

     @Test(priority = 3)
     public void verify_new_registration_link_Test(){
    	 testutil.MainFrame();
    	 testutil.SwitchMenuFrame();
    	 homepage.Click_patient_Registration(); 
    	 homepage.Click_new_registration();
     }
     
     
	@AfterMethod
	public void Teardown(){
		driver.quit();
	}

}
