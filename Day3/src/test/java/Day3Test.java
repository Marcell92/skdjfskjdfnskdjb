import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Day3Test {
	
	public ExtentReports report;
	public ExtentTest test;
	
	WebDriver driver;
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\MyFolder\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void verifyHomePageTitle() {

		report = new ExtentReports("C:/Users/Admin/Desktop/AutomationReports/BasicReport.html", true);
		
		//for (int i=1; i<10; i++) {
		
		test = report.startTest("testRep"); //+ i);
		
		//}
	
		driver.manage().window().maximize();
		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");
		driver.get("https://www.bbc.co.uk/");
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("BBC - Home")) {
			// report the test as a pass
			test.log(LogStatus.PASS, "verify Title of the page");
		} else {
			test.log(LogStatus.FAIL, "verify Title of the page");
		}
		
		report.endTest(test);
		report.flush();
		
		driver.quit();
	}
	

}
