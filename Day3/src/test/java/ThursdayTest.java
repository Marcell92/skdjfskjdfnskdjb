import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ThursdayTest {
	
	
	WebDriver driver = null;

	Actions action = null;
	
	public ExtentReports report;
	public ExtentTest test;

	@Before

	public void setUp() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\MyFolder\\chromedriver.exe");

		driver = new ChromeDriver();

		action = new Actions(driver);

		driver.get("http://demoqa.com/");

		driver.manage().window().maximize();

	}

	@Test
	@Ignore

	public void dragAndDropTest() throws InterruptedException {

		driver.get("http://demoqa.com/draggable/");

		WebElement dragMeAround = driver.findElement(By.cssSelector("#draggable > p"));

		Thread.sleep(1500);

		action.dragAndDropBy(dragMeAround, 100, 100).perform();

		Thread.sleep(1500);
	}
	
	@Test

	public void reorder() throws InterruptedException {
		
		report = new ExtentReports("C:/Users/Admin/Desktop/AutomationReports/BasicReport.html", true);
		
		test = report.startTest("Actions");

		driver.get("http://demoqa.com/sortable/");

		WebElement item1 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[1]"));
		WebElement item2 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[2]"));
		WebElement item3 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[3]"));
		
		

		Thread.sleep(1500);
		
		Point location = item2.getLocation();

		action.doubleClick(item1).perform();
		Thread.sleep(1500);
		test.log(LogStatus.PASS, "double click ok");
		action.moveToElement(item2).perform();
		Thread.sleep(1500);
		test.log(LogStatus.PASS, "moved to element");
		action.dragAndDrop(item2, item1).perform();
		Thread.sleep(1500);
		test.log(LogStatus.PASS, "swapped positions");
		action.dragAndDropBy(item3, 500, 1000).perform();
		
		Point location1 = item2.getLocation();
		
//		assertEquals("http://thedemosite.co.uk/savedata.php", item2.getLocation());
		
		assertNotEquals(location, location1);
		test.log(LogStatus.PASS, "assert passed");
		
		report.endTest(test);
		report.flush();
		

		Thread.sleep(1500);
	}

	@After
	public void tearDown() {

		driver.quit();

	}

}
