/* package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class readproperties {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = null;
		
		//Reading property file
		Properties prop = new Properties();
		FileInputStream File = new FileInputStream("E:\\ehospital\\Hospital\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(File);
		
		//System.out.println(prop.getProperty("URL"));
		
		String BrowserName = prop.getProperty("Browser");
		
		if(BrowserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\ehospital\\Hospital\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if(BrowserName.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","E:\\ehospital\\Hospital\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		if(BrowserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","E:\\ehospital\\Hospital\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else
		{
			System.out.println("Enter the correct Browser Details");
		}
		
		// Reading the URL from property file
		
		driver.get(prop.getProperty("URL"));
		
		Thread.sleep(3000);
		
		driver.findElement(By.name(prop.getProperty("Username_name"))).sendKeys(prop.getProperty("Username"));
		System.out.println("Entering USername");
		
		// Handling Module dropdown
	
		String ModuleName = prop.getProperty("Module");
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
		
		// Clicking the Login Button
		driver.findElement(By.xpath(prop.getProperty("Login_Button_Xpath"))).click();
		
		// Entering password 
		
		driver.findElement(By.name(prop.getProperty("Password_name"))).sendKeys(prop.getProperty("Password"));
		
		Thread.sleep(10000);
		
		//Click Signin Button
		
		driver.findElement(By.cssSelector(".btn")).click();

	}

}

*/