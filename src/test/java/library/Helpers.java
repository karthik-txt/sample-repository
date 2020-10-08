/**
 * 
 */
package library;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.Date;


/**
 * @author karthik
 *
 */
public class Helpers {

	public static String getScreenshot(WebDriver driver,String screenshotname) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"./screenshot"+screenshotname+getcurrentdate()+".png";
	try {
		FileUtils.copyFile(source, new File(path));
	} catch (IOException e) {
		System.out.println("while taking screenshot:"+e.getMessage());
	}
	 return path;	
	}
	
	public static String getcurrentdate() {
		DateFormat custom=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date=new Date();
		return custom.format(date);
	}
}
