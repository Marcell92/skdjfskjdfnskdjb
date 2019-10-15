import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DDT {
	
	public ExtentReports report;
	public ExtentTest test;
	
	WebDriver driver;
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\MyFolder\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	FileInputStream file;
	XSSFWorkbook workbook;

	@Test
	public void test() {
		
		report = new ExtentReports("C:/Users/Admin/Desktop/AutomationReports/BasicReport.html", true);
		
	    try {
	       file = new FileInputStream (Constants.testdataPath + Constants.data1);
	    } catch (FileNotFoundException e) {}
	   
	    try {
	        workbook = new XSSFWorkbook(file);
	    } catch (IOException e) {}
	    
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFCell cell = sheet.getRow(1).getCell(1);
	    
	    System.out.println(cell.getStringCellValue());
		
	}

}
