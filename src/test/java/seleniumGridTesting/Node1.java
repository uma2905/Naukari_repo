package seleniumGridTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Node1 {
	WebDriver driver;
	
  @Test
  public void f() throws MalformedURLException {
		
		URL gridUrl = new URL("http://10.99.242.248:4444");
	FirefoxOptions options =new FirefoxOptions();
	options.setPlatformName("WINDOWS");
	driver = new RemoteWebDriver(gridUrl, options);
	driver.get("https://shoppersstack.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	System.out.println(driver.getTitle());
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	//WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(by.)
	driver.quit();
  }
}
