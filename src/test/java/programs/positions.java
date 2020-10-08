/**
 * 
 */
package programs;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import library.Helper;
import library.Helpers;

/**
 * @author karthik
 *
 */
public class positions {

	WebDriver driver;
	ExtentHtmlReporter report;
	ExtentReports extent;
	ExtentTest logger;
	String temp;
	@BeforeClass
	public void reportsetup() {
		report=new ExtentHtmlReporter("./htmlreports/autosuggestion.html");
		extent=new ExtentReports();
		extent.setSystemInfo("HostName", "softwareTestingMaterial");
		extent.setSystemInfo("User Name", "KARTHIK P");
		report.config().setDocumentTitle("Autosuggestion");
		report.config().setReportName("Autosuggestion");
		report.config().setTheme(Theme.DARK);
		extent.attachReporter(report);
		report.getStartTime();
		logger=extent.createTest("Report setup started");
//		.//ul[@class='erkvQe']/li[position()>2 and position()<10]
	}
	
	@BeforeMethod
	public void browserlaunch() {
		logger=extent.createTest("To lanuch the browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		
	}
	
	@Test(priority=1)
	public void verifytitle() {
		logger=extent.createTest("To verify the google title");
		Assert.assertEquals(driver.getTitle(), "Google");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
		List<WebElement>list=driver.findElements(By.xpath("//ul[@class='erkvQe']/li//div[contains(@class,'jKW')]//following::span[position()>=2 and position()<17]"));
		System.out.println(list.size());
		for(WebElement ele:list) {
			String text=ele.getText();
			System.out.println("text is:"+text);
		}
	}
	
	@Test(priority=2)
	public void verifylog() {
		logger=extent.createTest("To verify the log");
		Boolean img=driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		Assert.assertTrue(img);
		logger.createNode("image is present");
		Assert.assertFalse(img);
		logger.createNode("image is not present");
		if(img) {
			System.out.println("image is present:"+img);
		}else {
			System.out.println("image is not present:"+img);
		}
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Testcase failed",ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable().getMessage()+"Testcase failed", ExtentColor.RED));
			temp=Helpers.getScreenshot(driver, result.getName());
			//logger.fail("Test case is failed snapshot in the below", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			//logger.fail("Test case is failed snapshot in the below", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}else if(ITestResult.SKIP==result.getStatus()) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"Test case skipped", ExtentColor.ORANGE));
			temp=Helper.getscreenshot(driver, result.getName());
			logger.skip("Test case skipped" +MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			
		}else if(ITestResult.SUCCESS==result.getStatus()) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getStatus()+"Test Case passed", ExtentColor.GREEN));
			temp=Helper.getscreenshot(driver, result.getName());
			logger.pass("Test case Passed"+ MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		extent.flush();
		driver.close();
		
	}
}
