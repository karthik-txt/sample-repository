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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import library.Helper1;

/**
 * @author karthik
 *
 */
public class handlecalendertable {

	WebDriver driver;
	ExtentHtmlReporter report;
	ExtentReports extent;
	ExtentTest logger;
	@BeforeMethod
	public void reportsetup() {
		report=new ExtentHtmlReporter("./htmlreports/calendertable.html");
		extent=new ExtentReports();
		extent.attachReporter(report);
		logger=extent.createTest("report setup started");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		logger.info("launching the browser");
		driver.manage().window().maximize();
		driver.get("https://www.abhibus.com/");
	}
	
	@Test
	public void calendertable1() {
		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
		List<WebElement>list=driver.findElements(By.xpath("//div[contains(@class,'ui-datepicker-group ui-datepicker-group-first')]//td"));
		System.out.println("number of days are:"+list.size());
		for(WebElement ele:list) {
			String text=ele.getText();
			if(text.equals("23")) {
				ele.click();
				break;
			}
			System.out.println("number of days are:"+text);
		}
		
	}
	
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			String Temp=Helper1.getscreenshot(driver, result.getName());
			logger.fail("fail", MediaEntityBuilder.createScreenCaptureFromPath(Temp).build());
		}else if(ITestResult.SUCCESS==result.getStatus()) {
			String Temp=Helper1.getscreenshot(driver, result.getName());
			logger.pass("Pass", MediaEntityBuilder.createScreenCaptureFromPath(Temp).build());
		}else if(ITestResult.SKIP==result.getStatus()) {
			String Temp=Helper1.getscreenshot(driver, result.getName());
			logger.skip("skip", MediaEntityBuilder.createScreenCaptureFromPath(Temp).build());			
		}
		extent.flush();
		driver.close();
	}
	
	
}
