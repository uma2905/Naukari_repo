package Simplepackage;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnnotationExample2 {

	public String baseUrl ="https://demowebshop.tricentis.com/";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching the browser");
		/*
		 * [ WebDriverManager.chromiumdriver().setup(); ]
		 * Can be used to download the required driver and also help command that automatically handles the browser
		 * driver needed for Chromium-based browsers.
		 */
		
		
		driver= new ChromeDriver();
		driver.get(baseUrl);
	}
	@Test
	public void verifyHomePageTitle(){
		String expectedValue="Tricentis Demo Web Shop";
		String actualValue=driver.getTitle();
		Assert.assertEquals(expectedValue, actualValue);
	}
	@AfterTest
	public void closeBrowsr() {
		driver.close();
	}
	
}
