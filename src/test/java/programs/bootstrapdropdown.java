/**
 * 
 */
package programs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ReportAggregates;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.model.Category;
import com.aventstack.extentreports.model.Device;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.model.Screencast;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import library.Helper;

/**
 * @author karthik
 *
 */
public class bootstrapdropdown {

	WebDriver driver;
	ExtentHtmlReporter report;
	ExtentReports extent;
	ExtentTest logger;
	@BeforeMethod
	public void bootstrap() {
		report=new ExtentHtmlReporter("./htmlreports/bootstrapdropdown.html");
		extent=new ExtentReports() ;
		extent.attachReporter(report);
		logger=extent.createTest("setting up the report");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		logger.info("launching the browser");
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	}
	
	@Test(priority=1)
	public void bootstrap1() {
		logger.log(Status.INFO, "testcase1");
		logger.info("bootstrap 1");
		driver.findElement(By.xpath("//div[@class='btn-group' and child::button[@title='HTML, CSS']]")).click();
		List<WebElement>list=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]/li"));
		System.out.println("number of checkbox are:"+list);
		for(WebElement ele:list) {
			String text=ele.getText();
			if(text.equals("Oracle")) {
				ele.click();
				break;
			}
			System.out.println("texts are:"+text);
		}
	}
	
	@Test(priority=2)
	public void bootstrap2() {
		logger.log(Status.INFO, "testcase2");
		logger.info("bootstrap 2");
		driver.findElement(By.xpath("//div[@class='btn-group' and child::button[@title='HTML, CSS']]")).click();
		List<WebElement>list=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]/li"));
		System.out.println("number of checkbox are:"+list);
		for(int i=0;i<list.size();i++) {
			WebElement ele=list.get(i);
			String text=ele.getText();
			if(text.equals("Oracle")) {
				ele.click();
				break;
			}
			System.out.println("texts are:"+text);
		}
	}
	
	@Test(priority=3)
	public void bootstrap3() {
		logger.log(Status.INFO, "testcase3");
		logger.info("bootstrap 3");
		driver.findElement(By.xpath("//div[@class='btn-group' and child::button[@title='HTML, CSS']]")).click();
		List<WebElement>list=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]/li"));
		System.out.println("number of checkbox are:"+list);
		Iterator<WebElement>itr=list.iterator();
		while(itr.hasNext()) {
			WebElement ele=(WebElement)itr.next();
			String text=ele.getText();
			if(text.equals("Oracle")) {
				ele.click();
				break;
			}
			System.out.println("texts are:"+text);
		}
	}
	
	@Test(priority=4)
	public void bootstrap4() {
		logger.log(Status.INFO, "testcase4");
		logger.info("bootstrap 4");
		driver.findElement(By.xpath("//div[@class='btn-group' and child::button[@title='HTML, CSS']]")).click();
		List<WebElement>list=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]/li"));
		System.out.println("number of checkbox are:"+list);
		List<String>actual=new ArrayList<String>();
		for(WebElement ele:list) {
			String text=ele.getText();
			actual.add(text);
		}
		System.out.println("text are:"+actual);
		List<String>expected=new ArrayList<String>();
		expected.addAll(expected);
		Collections.sort(expected);
		System.out.println("text are:"+expected);
		Assert.assertEquals(actual, expected, "failed due to mismatch");
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			String path=Helper.getscreenshot(driver, result.getName());
			logger.fail("fail", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}else if(ITestResult.SUCCESS==result.getStatus()) {
			String path=Helper.getscreenshot(driver, result.getName());
			logger.pass("Pass", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}else if(ITestResult.SKIP==result.getStatus()) {
			String path=Helper.getscreenshot(driver, result.getName());
			logger.skip("skip", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		extent.flush();
		driver.close();
		
	}
	
}
