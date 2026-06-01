package Simplepackage;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts_in_selenium_day5 {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
	//	ChromeDriver driver = new ChromeDriver();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.zeptonow.com/");
Thread.sleep(200);
		String act_title=driver.getTitle();
		if(act_title.equals("Zepto"))
		{
			System.out.println("Test passed");
			
		}
		else {
			System.out.println("Test is failed");
		}
		
		try {
			
			driver.findElement(By.id("Fake")).click();
		}
		catch (NoSuchElementException e) {
			System.out.println("Element not found");
			driver.findElement(By.xpath("//img[@alt='Zepto Logo']")).click();

		
		}
		driver.close();
	}

}

