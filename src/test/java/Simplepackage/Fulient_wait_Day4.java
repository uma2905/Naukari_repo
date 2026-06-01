package Simplepackage;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Fulient_wait_Day4 {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		// Fluent Wait
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		    .withTimeout(Duration.ofSeconds(30))
		    .pollingEvery(Duration.ofSeconds(1))
		    .ignoring(NoSuchElementException.class);

		WebElement content = fluentWait.until(new Function<WebDriver, WebElement>() {
		    public WebElement apply(WebDriver driver) {
		        return driver.findElement(By.xpath("//h4[text()='Hello World']"));
		    }
		});
		System.out.println(content.getText());
	}

}// Run this program in testNg
