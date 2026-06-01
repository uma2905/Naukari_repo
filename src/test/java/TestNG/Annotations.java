package TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Annotations {
 public String baseURl="https://demowebshop.tricentis.com/";
 public WebDriver driver;
 
 
 @Test
 public void verifyHomePage() {
	 System.out.println("Launching the Chrome Browser");
	 WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get(baseURl);
	 String expectedTitle = "Demo Web Shop";
	 String actualTitle= driver.getTitle();
	 Assert.assertEquals(actualTitle,expectedTitle);
	 driver.quit();
 }
 
 
}
