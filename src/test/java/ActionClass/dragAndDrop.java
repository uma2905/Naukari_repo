package ActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dragAndDrop {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver(); // Creating the webdriver 
		driver.get("https://jqueryui.com/"); // Navigating to URL
		driver.manage().window().maximize();

		// Explicit wait 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class=\"project jquery-ui\"]//a[@title=\"jQuery UI\" and text()=\"jQuery UI\"]")));
		
		// Verifying the title 
		String title  = driver.getTitle();
		String givenTitle ="jQuery UI";

	if (title.equalsIgnoreCase(givenTitle)){
		System.out.println("The title is matched");
	}
	else {
		driver.quit();
		System.out.println("The title is not matching");
	}
	
	// Creating the action class
	Actions builder = new Actions(driver);
	
	WebElement DraggableBtn = driver.findElement(By.xpath("//ul//li//a[text()='Droppable']"));
	DraggableBtn.click();
	WebElement Search = driver.findElement(By.xpath("//input[@aria-label=\"Search jQuery UI\"]"));
	Search.click();
	Search.sendKeys("Demo");
	
	// Switching the frame 
			driver.switchTo().frame(0);
	
	WebElement drag = driver.findElement(By.id("draggable"));
	WebElement TargetElement = driver.findElement(By.id("droppable"));
	
	
	// Creating object to perform the actions
	Action seriesOfAction;
		seriesOfAction = builder
				
				.clickAndHold(drag)
				.moveToElement(TargetElement)
				.release()
			.build();
		seriesOfAction.perform();
	
		
	
		
	Thread.sleep(3000);
	
	
//	This method can be used but the seleenium will thro Stale element excpetion
//builder.dragAndDrop(drag, TargetElement).build().perform();
 
//	// Alternative to the action method to drag and drop 
//	/builder.clickAndHold(drag).moveToElement(TargetElement).release().build().perform(); 
	
	Thread.sleep(3000);
	driver.quit();
	
	
	}
	}


