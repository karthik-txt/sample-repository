/**
 * 
 */
package programs;

import static org.testng.Assert.assertEquals;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.template.utility.CaptureOutput;
import library.checkbox;

/**
 * @author karthik
 *
 */
public class handleradobuttoandcheckbox {

	WebDriver driver;
	ExtentHtmlReporter report;
	ExtentReports extent;
	ExtentTest logger;
	String temp;
	@BeforeClass
	public void reportsetup() {
		report=new ExtentHtmlReporter("./htmlreports/checkbox.html");
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("HostName", "Automation Tester");
		extent.setSystemInfo("User Name", "Karthik");
		report.config().setDocumentTitle("Handling rdiobutton and checkbox");
		report.config().setReportName("Radiobutton");
		report.config().setTheme(Theme.DARK);
		report.getStartTime();
		logger=extent.createTest("Report setup started");
	}
	
	@BeforeMethod
	public void launchthebrowser() {
		logger=extent.createTest("launching the browser");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
	}
	
	@Test(priority=1)
	public void handleradiobutton() {
		List<WebElement>list=driver.findElements(By.xpath("//input[@name='lang'][@type='radio']"));
		System.out.println("number of radio button:"+list.size());
		for(WebElement ele:list) {
			String text=ele.getAttribute("value");
			System.out.println(text);
		}
		System.out.println("**************************");
	
		Iterator<WebElement> itr=list.iterator();
		while(itr.hasNext()) {
			WebElement ele1=itr.next();
			String text1=ele1.getAttribute("id");
			System.out.println(text1);
		}
		System.out.println("**************************");
		List<WebElement>list1=driver.findElements(By.xpath("//input[@name='lang'][@type='radio']"));
		List<String>actual=new ArrayList<String>();
		System.out.println("number of radio button:"+actual.size());
		for(WebElement ele2:list1) {
			String text2=ele2.getAttribute("id");
			actual.add(text2);
			System.out.println(text2);
		}
		List<String>expected=new ArrayList<String>();
		expected.addAll(actual);
		Collections.sort(expected);
		System.out.println("ascending order:"+expected);
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=2)
	public void checkbox() {
		List<WebElement>list=driver.findElements(By.xpath("//input[@name='lang'][@type='checkbox']"));
		System.out.println("number of check box:"+list.size());
		for(WebElement ele:list) {
			String text=ele.getAttribute("id");
			System.out.println(text);
		}
		System.out.println("**************************");
		Iterator<WebElement>itr=list.iterator();
		while(itr.hasNext()) {
			WebElement ele1=itr.next();
			String text1=ele1.getAttribute("id");
			System.out.println(text1);
		}
		System.out.println("**************************");
		List<WebElement>list1=driver.findElements(By.xpath("//input[@name='lang'][@type='checkbox']"));
		List<String>actual=new ArrayList<String>();
		System.out.println("number of check box:"+list1);
		for(WebElement ele2:list1) {
			String text2=ele2.getAttribute("id");
			actual.add(text2);
			System.out.println(text2);
		}
		
		List<String>expected=new ArrayList<String>();
		expected.addAll(actual);
		Collections.sort(expected);
		System.out.println("checkbox in ascending order:"+expected);
		Assert.assertEquals(actual, expected);
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			temp=checkbox.getscreenshot(driver, result.getName());
			logger.log(Status.FAIL, MarkupHelper.createLabel("Test Case Failed", ExtentColor.RED));
			logger.fail(result.getThrowable().toString() +"Please find the screenshot below", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}else if(ITestResult.SKIP==result.getStatus()) {
			temp=checkbox.getscreenshot(driver, result.getName());
			logger.log(Status.SKIP, MarkupHelper.createLabel("Test Case skipped", ExtentColor.ORANGE));
			logger.skip(result.getThrowable().toString() +"Please find the screenshot below", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}else if(ITestResult.SUCCESS==result.getStatus()) {
			temp=checkbox.getscreenshot(driver, result.getName());
			logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Pass", ExtentColor.GREEN));
			logger.pass(result.getThrowable().toString() +"Please find the screenshot below", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		extent.flush();
		driver.close();
	}
	
}

