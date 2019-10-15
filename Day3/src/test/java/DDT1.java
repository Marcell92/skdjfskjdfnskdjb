import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class DDT1 {
	
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

	@SuppressWarnings("deprecation")
	@Test
	public void test() throws InterruptedException, InvalidFormatException, IOException {

		report = new ExtentReports("C:/Users/Admin/Desktop/AutomationReports/BasicReport.html", true);
		
		test = report.startTest("testRep1");
		
		ExcelWriter.ExcelGenerator();
		
		test.log(LogStatus.PASS, "employee data inserted into excel");
		
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "maximizing window");
		
		driver.get(Constants.url + Constants.addUser);
		test.log(LogStatus.INFO, "navigating to the demosite");
		
	    try {
	       file = new FileInputStream (Constants.employeedata);
	    } catch (FileNotFoundException e) {}
	   
	    try {
	        workbook = new XSSFWorkbook(file);
	    } catch (IOException e) {}
	    
	    XSSFSheet sheet = workbook.getSheetAt(0);
	    XSSFCell uname = sheet.getRow(1).getCell(0);
	    XSSFCell passwd = sheet.getRow(0).getCell(1);
	    
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).click();
	    
	    try {
	    driver.findElement(By.name("username")).sendKeys(uname.getStringCellValue());
	    } catch (IllegalStateException i) {}
	    
	    Thread.sleep(1000);
	    
	    test.log(LogStatus.INFO, "entering username from excel file");
	    
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).click();
	    
	    try {
	    driver.findElement(By.name("password")).sendKeys(passwd.getStringCellValue());
	    } catch (IllegalStateException i) {}
	    
	    test.log(LogStatus.INFO, "entering passwd from excel file");
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.name("FormsButton2")).click();
	    
	    assertEquals("http://thedemosite.co.uk/savedata.php", driver.getCurrentUrl());
	    
	    test.log(LogStatus.PASS, "user added successfully");
	    
		report.endTest(test);
		report.flush();
		
		driver.quit();
		
	}

}

