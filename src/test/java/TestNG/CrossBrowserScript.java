package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript {
	WebDriver driver;
	String  currentBrowser;
	
@Parameters("browser")
@BeforeClass
public void setup(String browser) {
	System.out.println("=========== Executing on Borwser: "+ browser+"============");
	if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("firefox")){
		driver =new FirefoxDriver();
	}
	else if(browser.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}
}

@Test
public void openWebSite(String browserName) throws InterruptedException {
	driver.get("https://demowebshop.tricentis.com/");
	driver.manage().window().maximize();
	System.out.println("Title of the page"+driver.getTitle());
	Thread.sleep(3000);
	currentBrowser=browserName;
	try {
		driver.findElement(By.className("ico-register"));
	System.out.println("Current Browser is exicuting the dummy element "+currentBrowser);
	}catch (Exception e) {
		// TODO: handle exception
	System.out.println("Catch block executing");
	}
}

@AfterMethod
public void quit() {

		driver.quit();
	}
	
}


