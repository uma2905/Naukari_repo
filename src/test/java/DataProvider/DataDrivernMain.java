package DataProvider;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class DataDrivernMain extends DataDrivernExcel{
	
public DataDrivernMain(String filePath) {
		super(filePath);
	
	}

static	WebDriver driver;

	public static void takeScreenShot(String filename) {
		File scr= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File(System.getProperty("user.dir")+"Screenshot" + filename +".png"));
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void main(String[] args) {
	

	}

}
