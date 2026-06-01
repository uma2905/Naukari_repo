package Simplepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class day2_selemium {
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.ie.driver", "Users\\User\\Downloads\\IEDriverServer_x64_4.14.0.exe");
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.shoppersstack.com/");
	
	
	try {                                             // 
	    driver.findElement(By.id("Fake"));
	} catch (org.openqa.selenium.NoSuchElementException e) {
	    System.out.println("Element Not Found");
	}
	
String at= driver.getTitle();                         // Verification of title step
String et= "ShoppersStack";
if(at.equalsIgnoreCase(et)) {
	System.out.println("Test sucessfull");
}
else
{
	System.out.println("Test failed");
}
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	
	driver.findElement(By.id("loginBtn")).click();
	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("robhinrebel5552@gmail.com");
	driver.findElement(By.xpath("//input[@id=\'Password\']")).sendKeys("Robin@123");
	driver.findElement(By.xpath("//span[text()='Login']")).click();
	
	
	Thread.sleep(10000);                                       // This command is used to stop the execution for particular seconds
	driver.findElement(By.xpath("//input[@id=\"search\"]")).click();
	driver.findElement(By.xpath("//input[@list='browsers']")).sendKeys("Mobiles");
	driver.findElement(By.name("searchBtn")).click();
	
	driver.findElement(By.className("navbar_selectBlock__UPLw4")).click();
	
	driver.navigate().to("https://demowebshop.tricentis.com/");        // This command is used to navigate to different page using URL
	Thread.sleep(4000);
	new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Demo Web Shop"));
	driver.findElement(By.className("ico-login")).click();

	driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
	driver.findElement(By.id("Email")).sendKeys("robhinrebel5552@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("Robin@123");
	Thread.sleep(2000);
 at=driver.getTitle();                            // Switching and verifying pages 
 et="Demo Web Shop. Login";
 if (at.equalsIgnoreCase(et)) {
	 System.out.println("The page has loged in into demo web and verifed");
}
 else {
	System.out.println("The Navigation and verification failed ");
}
	
 driver.navigate().back();    // Switching back to main page
 driver.navigate().refresh();
	Thread.sleep(3000);
	
	System.out.println("current page URl"+driver.getCurrentUrl());
	System.out.println("Current page title"+ driver.getTitle());
	
at= driver.getTitle();                         // Verification of title step
et= "ShoppersStack";
if(at.equalsIgnoreCase(et)) {
	System.out.println("Test sucessfull Navigate to main page");
}
else
{
	System.out.println("Test failed");
	
}
	
	driver.quit();

	

	} //

}

