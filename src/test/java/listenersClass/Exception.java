import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exception{
	
	static WebDriver demo;
	public static void main(String[] args) throws InterruptedException {
		demo = new ChromeDriver();
	demo.get("https://demowebshop.tricentis.com/");
	demo.manage().window().maximize();
	demo.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	demo.findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
	demo.findElement(By.id("Email")).sendKeys("lid4i9oqauk670mwzshu6lzejzn4@gmail.com");
	demo.findElement(By.id("Password")).sendKeys("Robin@123");
	demo.findElement(By.xpath("//input[@class=\"button-1 login-button\"]")).click();
		Thread.sleep(10);
	
		
		
	try {                                                          // NoSuchElementExcpetion
		demo.findElement(By.className("dummy"));
		
	}catch (NoSuchElementException e) {                            
		System.out.println("Inside catch block");
		System.out.println("Elements not found");
		
		throw(e); // throw the exception // e.printStackTrace();[used to print error]
			}
	
	try {                                                              //NoSuchAlertException
		demo.switchTo().alert().accept();
	}
	catch (NoAlertPresentException e) {
		System.out.println("No alter found");
		
	}
	
	try {                                                               //NosuchframeException
		demo.switchTo().frame("demo");
		
	} catch (NoSuchFrameException e) {
		System.out.println("No Frame found");
	}
	
	try {                                                                 //NoWindowFound Exception
		demo.switchTo().window("demo");
		
	} catch (NoSuchWindowException e) {
		System.out.println("No window found ");
	}
	
	finally {
		demo.quit();
	}		}
	
	}
