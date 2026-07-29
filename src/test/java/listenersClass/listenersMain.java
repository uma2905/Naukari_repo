package listenersClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class listenersMain {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	JavascriptExecutor js =(JavascriptExecutor)driver;

Listener listen = new Listener();          // calling the class
WebDriver eventHandler = new EventFiringDecorator(listen).decorate(driver); // Creating a object 
 // driver = new EventFiringDecorator(listen).decorate(driver); [Optimize way]
/*
 * calling event firing class interface [creating an object and instantiate
 * with new Eventfirefing webdiver and linking the driver along with it ]*/

  //driver.register(listen); [deprecated in selenium used to register the implementation process]
 
eventHandler.navigate().to("https://demowebshop.tricentis.com/");
eventHandler.manage().window().maximize();
js.executeScript("window.scrollBy(0,500)");
Thread.sleep(4000);
eventHandler.findElement(By.xpath("//a[@href=\"/customer/info\"]")).click();

Thread.sleep(1000);
eventHandler.navigate().to("https://demowebshop.tricentis.com/register");  // Navigating to register page
eventHandler.navigate().back(); // Navigating to first page
Thread.sleep(2000);

eventHandler.quit();
System.out.println("End of listner");
}
}
