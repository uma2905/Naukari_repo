package seleniumGridTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {

	static WebDriver driver;
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		URL gridUrl = new URL("http://10.99.242.248:4444");
	ChromeOptions options =new ChromeOptions();
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

