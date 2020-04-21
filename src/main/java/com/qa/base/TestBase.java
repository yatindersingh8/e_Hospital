package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.util.TestUtil;
import com.qa.util.WebEventlistner;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventlistner eventListner;
	//Defining public type constructor
	public   TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream File = new FileInputStream("./src/main/java/com/qa/config/config.properties");
			prop.load(File);
			
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		}
	
		public void initialization(){
			System.out.println(prop.getProperty("Browser"));
			String BrowserName = prop.getProperty("Browser");
		    
			if(BrowserName.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver","E:\\ehospital\\Hospital\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			else if(BrowserName.equals("FireFox"))
			{
				System.setProperty("webdriver.gecko.driver","E:\\ehospital\\Hospital\\Drivers\\geckodriver.exe");
				//driver = new FirefoxDriver();
				 final FirefoxOptions options = new FirefoxOptions();
			        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			        options.addPreference("browser.popups.showPopupBlocker", false);
			        options.addPreference("security.sandbox.content.level", 5);

			    driver = new FirefoxDriver(options);
				
			}
			
			else if(BrowserName.equals("IE"))
			{
				System.setProperty("webdriver.ie.driver","E:\\ehospital\\Hospital\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
			else
			{
				System.out.println("Enter the correct Browser Details");
			}
			e_driver = new EventFiringWebDriver(driver); //Create  object of event listner to handle event firing element
			eventListner = new WebEventlistner();
			e_driver.register(eventListner);
			driver = e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeout.,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitWaitTime,TimeUnit.SECONDS);
			
			// Reading the URL from property file
			
			driver.get(prop.getProperty("URL"));
			//String ModuleName = prop.getProperty("Module");
			
		}
	}


