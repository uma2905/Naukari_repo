package Simplepackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class Demo_selenium_edureka {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.shoppersstack.com/user-signin");

	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("robhinrebel5552@gmail.com");
	driver.findElement(By.xpath("//input[@id=\'Password\']")).sendKeys("Robin@123");
	driver.findElement(By.xpath("//span[text()='Login']")).click();
	Thread.sleep(100000);
	driver.findElement(By.xpath("//input[@id=\"search\"]")).sendKeys("Mobiles");


driver.quit();
	}
	}


