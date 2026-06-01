package roboClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class robo {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://shoppersstack.com/");
		driver.manage().window().maximize();
		
		
		// Explict wait
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement Login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginBtn")));
		Login.click();
WebElement shopperLogin = driver.findElement(By.xpath("//strong[text()=\"Shopper\"]"));


// Create a instance of robo class 
Robot robo = new Robot();

robo.mouseWheel(2);
Thread.sleep(3000);
robo.mouseMove(40, 120);


// Created instance of action class 
Actions actions = new Actions(driver);
actions.moveToElement(shopperLogin).perform();

robo.keyPress(KeyEvent.VK_TAB);
robo.keyPress(KeyEvent.VK_DOWN);
Thread.sleep(2000);

robo.keyPress(KeyEvent.VK_DOWN);
Thread.sleep(3000);
robo.keyPress(KeyEvent.VK_UP);

Thread.sleep(4000);

	driver.quit();	
	}

}
