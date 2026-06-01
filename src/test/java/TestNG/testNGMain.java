package TestNG;

import java.sql.Driver;

import org.jspecify.annotations.Nullable;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;

@Listeners(testNg.class) // calling a class
public class testNGMain {
WebDriver driver;
@Test
public void runDemoShopTest()throws InterruptedException {
	//WebDriverManager.chromedriver().setup();
	
	
	
driver= new ChromeDriver();
	driver.get("https://demowebshop.tricentis.com/");
	JavascriptExecutor js = (JavascriptExecutor)driver; 
		driver.manage().window().maximize();
		driver.findElement(By.id("small-searchterms")).sendKeys("Elite Desktop PC");
		driver.findElement(By.xpath("//input[@class=\"button-1 search-box-button\"]")).click();
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3009);
	js.executeScript("window.scrollBy(0,500)");;
Thread.sleep(2200);

}

//Forcefully failed this as verify the listners
@Test
public void TestTofiail() { // this method helps in failure of the test case
	System.out.println("This method to test fail");
	Assert.assertTrue(false); // Asserting that the expression is true
}


}
