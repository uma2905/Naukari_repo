package ActionClass;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action1 {

	
	public static void main(String[] args) throws InterruptedException  {
		WebDriver actionDriver = new ChromeDriver();
		try {
		
		actionDriver.get("https://shoppersstack.com/");
		actionDriver.manage().window().maximize();
//		actionDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		// Explicit wait for title page
		
		WebDriverWait Login = new WebDriverWait(actionDriver, Duration.ofSeconds(10));
		WebElement welcome = Login.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()=\"Welcome to ShoppersStack. Enjoy shopping with us.\"]")));
		
		// Click and send input actions
		actionDriver.findElement(By.id("loginBtn")).click();
		actionDriver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("robinrebel5552@gmail.com");
		actionDriver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("Robin@123");
		actionDriver.findElement(By.xpath("//span[@class=\"MuiButton-label\" and text()= \"Login\"]")).click();
		
		// Explicit wait for after login
		WebDriverWait wait = new WebDriverWait(actionDriver,Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()=\"Hello, \"]")));
		
		// Scroll action for element Without using wait function 
		Actions builders= new Actions(actionDriver);
		WebElement Help = actionDriver.findElement(By.xpath("//a[text()=\"Help Center\"]"));
		builders.moveToElement(Help).build().perform();
		Thread.sleep(2000);
		
		// scroll for element use scroll action class search element
		
WebElement search =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"search\"]")));
	builders.moveToElement(search).build().perform();
	Thread.sleep(3000);

	
	// Scroll till Register element

			WebElement subscriptionbtn =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=\"registered office address:\"]")));
			builders.moveToElement(subscriptionbtn).build().perform();
			subscriptionbtn.click();
		Thread.sleep(2000);
	
		// Scroll to search using action class Serach button 
		
		WebElement searchbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBtn")));
		builders.moveToElement(searchbtn).build().perform();
		Thread.sleep(2000);
							
				

		// Action class
		
		Action seriesOfActions;
		seriesOfActions = builders
				.click(search)
				.sendKeys(search, "puma")
				//.click(searchbtn).build();
				.keyDown(searchbtn, Keys.SHIFT)
				.keyUp(searchbtn,Keys.SHIFT).build();
		seriesOfActions.perform();
		Thread.sleep(3000);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		
		
		}
	finally {
	System.out.println("Executing final block ");
	if(actionDriver != null) {
		actionDriver.quit();
	}

	}
	

	}
	
	
	
}
		
	
	
	
