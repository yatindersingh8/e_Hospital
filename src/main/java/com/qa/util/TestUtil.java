package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PageLoadTimeout = 20;
	public static long ImplicitWaitTime = 20;
	public static String TESTDATA_SHEET_PATH = "E:\\ehospital\\Hospital\\src\\main\\java\\com\\qa\\testdata\\eHospital_TestData.xlsx";
	static Workbook book;
	static Sheet sheet;

	
	public TestUtil() {
		super();	
	}
	
	public void MainFrame(){
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"ehosfrm\"]")));
		
	}
	public void SwitchMenuFrame(){
		
		driver.switchTo().frame("contents");
	}
    public void SwitchMainFrame(){
		
		driver.switchTo().frame("main");
	}
	public void SwitchToAlert_Accept(){
		//driver.switchTo().alert();
		driver.switchTo().alert().accept();
	}
	public void SwitchToParentFrame(){
		driver.switchTo().parentFrame();
	}
	
	public void BannerFrame(){
		
		driver.switchTo().frame("banner");
	}
	
	
	public static Object[][] getTestData(String sheetName){
		
		FileInputStream file = null;
		try{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} 
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			book = WorkbookFactory.create(file);
		}
		catch (InvalidFormatException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum()+ "---------------" + sheet.getRow(0).getLastCellNum());
		for(int i = 0; i < sheet.getLastRowNum(); i++){
			for(int k = 0; k < sheet.getRow(0).getLastCellNum(); k++){
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}
    
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	

	

}
