package Simplepackage;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


//import io.appium.java_client.functions.ExpectedCondition;

public class day4selenium {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.shoppersstack.com/");
		driver.manage().window().maximize();                                      // waits in selenium
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.id("loginBtn")).click();
		Thread.sleep(2000);
		
		WebElement Email =driver.findElement(By.xpath("//input[@id='Email']"));
		WebElement Password= driver.findElement(By.xpath("//input[@id=\'Password\']"));
		sendKeysWhenVisible(driver, Email, 10, "robhinrebel5552@gmail.com");
		sendKeysWhenVisible(driver, Password, 10, "Robin@123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(3000);
		
		WebElement men=driver.findElement(By.xpath("//a[@id=\"men\"]"));
		
		click_on(driver, men, 10);		
		
		driver.quit();
	}
	public static void sendKeysWhenVisible(WebDriver driver, WebElement element, int timeout, String value) {
	    new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
	    element.sendKeys(value);
	}
	public static void click_on(WebDriver driver, WebElement element, int i) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}
	

	}




