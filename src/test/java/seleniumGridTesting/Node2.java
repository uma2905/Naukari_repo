package seleniumGridTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Node2 {
	WebDriver driver;
  @Test
  public void f() {
		
		URL gridUrl;
		try {
			gridUrl = new URL("http://10.99.242.248:4444");
		
	FirefoxOptions options =new FirefoxOptions();
	options.setPlatformName("WINDOWS");
	driver = new RemoteWebDriver(gridUrl, options);
	driver.get("https://www.selenium.dev/downloads/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	System.out.println(driver.getTitle());
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	//WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(by.)
		}catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.quit();
  }
}
