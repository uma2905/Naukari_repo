package Simplepackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day3_selenium {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.shoppersstack.com/");
		Thread.sleep(2000);
		String sc= driver.getTitle();
		 String cs= "ShoppersStack";
		 if(sc.equalsIgnoreCase(cs)) {
			 System.out.println("Test passed");
		 }
		 else {
			 System.out.println("Test failed");
		 }
		 driver.manage().window().maximize();
		 driver.findElement(By.id("loginBtn")).click();
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("robhinrebel5552@gmail.com");
			driver.findElement(By.xpath("//input[@id=\'Password\']")).sendKeys("Robin@123");
			driver.findElement(By.xpath("//span[text()='Login']")).click();
			driver.findElement(By.xpath("//input[@id=\"search\"]")).click();
			driver.findElement(By.xpath("//input[@list='browsers']")).sendKeys("Mobiles");
			driver.findElement(By.name("searchBtn")).click();
			driver.findElement(By.className("navbar_selectBlock__UPLw4")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//span[text()=\"APPLE iPhone 13 Pro max\"]")).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)");   
		
	}
}
