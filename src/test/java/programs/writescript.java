/**
 * 
 */
package programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author karthik
 *
 */
public class writescript {

	WebDriver driver;
	/*@Test(priority=1)
	public void script() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\kk\\frameworkdemo1\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("learnautomation.com");
		driver.findElement(By.xpath("// input[@id='pass']")).sendKeys("mukesh123");
		driver.findElement(By.xpath("//button[@id='u_0_b']")).click();
		String data=driver.findElement(By.xpath("//div[@role='alert']")).getAttribute("innerHTML");
		System.out.println("data:"+data);
		Assert.assertTrue(data.contains("match any account"), "Failed due to mismatch");
		//Assert.assertEquals(data, "The email address or phone number that you've entered doesn't match any account.Sign up for an account.");
		System.out.println("pass");
	}*/
	
	/*@Test(priority=2)
	public void dropdown() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//div[@class='_6ltg' and child::a[@id='u_0_2']]")).click();
		
		WebElement ele=driver.findElement(By.xpath("//select[@name='birthday_month' and parent::span]"));
		Select month=new Select(ele);
		month.selectByIndex(2);
		Thread.sleep(2000);
		month.selectByValue("6");
		Thread.sleep(2000);
		month.selectByVisibleText("Oct");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@class='_8idr img' and parent::div[@class='_8ien']]")).click();
	}*/
	
	
	/*@Test(priority=3)
	public void dropdown1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//div[@class='_6ltg' and child::a[@id='u_0_2']]")).click();
		WebElement ele=driver.findElement(By.xpath("//select[@name='birthday_month' and parent::span]"));
		Select month=new Select(ele);
		WebElement default_month=month.getFirstSelectedOption();
		System.out.println("default month is:"+default_month.getText());
		
		month.selectByVisibleText("Oct");
		
		WebElement after_month=month.getFirstSelectedOption();
		System.out.println("after selecting the month:"+after_month.getText());
		driver.findElement(By.xpath("//img[@class='_8idr img' and parent::div[@class='_8ien']]")).click();
	}*/
	
	/*@Test(priority=4)
	public void dropdown2() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//div[@class='_6ltg' and child::a[@id='u_0_2']]")).click();
		WebElement ele=driver.findElement(By.xpath("//select[@name='birthday_month' and parent::span]"));
		Select month=new Select(ele);
		List<WebElement>list=month.getOptions();
		System.out.println("number of dropdowns are:"+list.size());
		for(WebElement ele1:list) {
			String text=ele1.getAttribute("innerHTML");
			System.out.println(text);
		}
		driver.findElement(By.xpath("//img[@class='_8idr img' and parent::div[@class='_8ien']]")).click();
	}*/
	
/*	@Test(priority=5)
	public void dropdown3() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//div[@class='_6ltg' and child::a[@id='u_0_2']]")).click();
		WebElement ele=driver.findElement(By.xpath("//select[@name='birthday_month' and parent::span]"));
		Select month=new Select(ele);
		List<WebElement>list=month.getOptions();
		System.out.println("number of dropdowns are:"+list.size());
		for(WebElement ele1:list) {
			String text=ele1.getAttribute("innerHTML");
			if(text.equals("Oct")) {
				ele1.click();
				break;
				
			}
			System.out.println(text);;
			driver.findElement(By.xpath("//img[@class='_8idr img' and parent::div[@class='_8ien']]")).click();
		}
	}*/
	
	/*@Test(priority=6)
	public void dropdown4() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//div[@class='_6ltg' and child::a[@id='u_0_2']]")).click();
		WebElement ele=driver.findElement(By.xpath("//select[@name='birthday_month' and parent::span]"));
		Select month=new Select(ele);
		
		List<WebElement>list=month.getOptions();
		System.out.println("number of dropdowns are:"+list.size());
		for(int i=0;i<list.size();i++) {
			String text=list.get(i).getText();
			if(text.equals("Oct")) {
				list.get(i).click();
				break;
			}
			System.out.println(text);
			Thread.sleep(2000);
		//	driver.findElement(By.xpath("//img[@class='_8idr img' and parent::div[@class='_8ien']]")).click();
		}
	}*/
	
	/*@Test(priority=7)
	public void dropdown5() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//div[@class='_6ltg' and child::a[@id='u_0_2']]")).click();
		WebElement ele=driver.findElement(By.xpath("//select[@name='birthday_month' and parent::span]"));
		Select month=new Select(ele);
		List<WebElement>list=month.getOptions();
		System.out.println("number of dropdowns are:"+list.size());
		Iterator<WebElement>itr=list.iterator();
		while(itr.hasNext()) {
			WebElement ele1=itr.next();
			String text=ele1.getText();
			if(text.equals("Oct")) {
				ele1.click();
				break;
			}
			System.out.println(text);
		}
	}*/
	
	@Test(priority=8)
	public void dropdown6() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//div[@class='_6ltg' and child::a[@id='u_0_2']]")).click();
		WebElement ele=driver.findElement(By.xpath("//select[@name='birthday_month' and parent::span]"));
		Select month=new Select(ele);
		List actual=new ArrayList();
		List<WebElement>list=month.getOptions();
		System.out.println("number of dropdowns are:"+list.size());
		for(WebElement ele1:list) {
			String text=ele1.getAttribute("innerHTML");
			actual.add(text);
		}
		System.out.println("drop down names are:"+actual);
		List temp=new ArrayList();
		temp.addAll(actual);
		Collections.sort(temp);
		System.out.println("drop down names are:"+temp);
		Assert.assertEquals(actual, temp, "failed");
		
	}
	
	
}
