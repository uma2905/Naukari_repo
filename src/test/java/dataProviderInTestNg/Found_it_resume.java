package dataProviderInTestNg;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Found_it_resume {
	
	 static WebDriver driver;

	public static void takeScreenShots(String fileName) {
File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
try {
	FileUtils.copyDirectory(scr,new File(System.getProperty("user.dir")+"/Screenshot/"+fileName +".png"));
}
catch (IOException e) {
	e.getStackTrace();
	}
		
		
	}
	
	
}
