package com.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Home;
import com.qa.pages.Login;
import com.qa.pages.NewRegistration;
import com.qa.pages.Password;
import com.qa.util.TestUtil;

//import junit.framework.Assert;

public class NewRegistrationTest extends TestBase {
	public static final String FirstName = null;
	public static final String LastName = null;
	Password passwordpage;
	Login loginpage;
	Home homepage;
	TestUtil testutil;
    NewRegistration newregistration;
	public NewRegistrationTest() {
		super();	
	}
	
	/*@DataProvider
	public Object[][] newregistrationdata() throws InvalidFormatException{
		Object data[][] = testutil.getTestData("New_Registration");
		return data;
	}
	*/
	@BeforeMethod ()
	public void Setup() throws IOException, InterruptedException {
		TestBase tb = new  TestBase();
		tb.initialization();
		loginpage = new Login();
		testutil = new 	TestUtil();
		homepage = new Home();
		loginpage.Login(prop.getProperty("Username"));
		loginpage.SelectModule(prop.getProperty("Module"));
		passwordpage = loginpage.Clicking_Signin_Button();
		passwordpage.Enter_Password(prop.getProperty("Password"));
		homepage = passwordpage.Password_Signin_Button();
   	    testutil.MainFrame();
   	    testutil.SwitchMenuFrame();
   	    homepage.Click_patient_Registration(); 
   	    newregistration = homepage.Click_new_registration();
	}
	/*
	@DataProvider
	public Object[][] newregistrationdata(){
		Object data[][] = TestUtil.getTestData("New_Registration");
		return data;
	}
	*/
	
	@Test(priority = 1)
	public void Verify_Enter_Mobile_Popup_test(){
         testutil.SwitchToParentFrame();
		 testutil.SwitchMainFrame();
		 boolean linkpresent = newregistration.newregistration();
		 Assert.assertTrue(linkpresent);
			testutil.SwitchToParentFrame();
			testutil.BannerFrame();
			homepage.Logout_Application();
			testutil.SwitchToAlert_Accept();
			
	}
	
	@Test(priority = 2)
	public void Enter_Mobile_No_Textfield_Test(){
        testutil.SwitchToParentFrame();
		testutil.SwitchMainFrame();
		newregistration.Verify_Enter_Mobile_No_Textfield();
		testutil.SwitchToParentFrame();
		testutil.BannerFrame();
		homepage.Logout_Application();
		testutil.SwitchToAlert_Accept();
	}
	
	@Test(priority = 3)
	public void Verify_Search_Button_Ispresent_Test(){
        testutil.SwitchToParentFrame();
		testutil.SwitchMainFrame();
		boolean SearchButton = newregistration.Verify_Enter_Mobile_No_SearchButton_IsPresent();
		Assert.assertTrue(SearchButton);
		testutil.SwitchToParentFrame();
		testutil.BannerFrame();
		homepage.Logout_Application();
		testutil.SwitchToAlert_Accept();
	}
	@Test(priority = 4)
	public void Verify_Search_Button_Functioning_Test(){
        testutil.SwitchToParentFrame();
		testutil.SwitchMainFrame();
		newregistration.Verify_Enter_Mobile_No_Textfield();
		newregistration.Verify_Enter_Mobile_No_SearchButton();
		boolean searchresults = newregistration.Verify_Enter_Mobile_No_SearchResults();
		Assert.assertTrue(searchresults );
		testutil.SwitchToParentFrame();
		testutil.BannerFrame();
		homepage.Logout_Application();
		testutil.SwitchToAlert_Accept();
	}
	
	@Test(priority = 5)
	public void Verify_Skip_Button_Availability_Test(){
        testutil.SwitchToParentFrame();
		testutil.SwitchMainFrame();
		boolean skipbutton = newregistration.Verify_Skip_Button();
		Assert.assertTrue(skipbutton);
		testutil.SwitchToParentFrame();
		testutil.BannerFrame();
		homepage.Logout_Application();
		testutil.SwitchToAlert_Accept();
		}
	@Test(priority = 6)
	public void Verify_Skip_Button_Functioning_Test(){
        testutil.SwitchToParentFrame();
		testutil.SwitchMainFrame();
		newregistration.Click_Skip_Button();
		testutil.SwitchToParentFrame();
		testutil.BannerFrame();
		homepage.Logout_Application();
		testutil.SwitchToAlert_Accept();
		}
	@Test(priority = 7)
	public void Registration_Form_Redirection_Test(){
		newregistration.Skipping_Mobile_No();
		testutil.SwitchToParentFrame();
		testutil.BannerFrame();
		homepage.Logout_Application();
		testutil.SwitchToAlert_Accept();
		}

	/*
	@Test(dataProvider = "newregistrationdata")
	public void Patient_Initials_Test(String FirstName , String LastName){
		System.out.println("Hi");
		newregistration.Skipping_Mobile_No();
		//newregistration.Enter_Form(FirstName, LastName);;
		
		}
	
*/
	@AfterMethod
	public void Teardown(){
		driver.quit();
	}
}
