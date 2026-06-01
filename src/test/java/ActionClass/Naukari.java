package ActionClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Naukari {
	static WebDriver driver;
	
	public static void takeScreenShots(String fileName) {  // Screenshot capturing 
		
	File scr= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);		
	try {
		FileUtils.copyFile(scr, new File(System.getProperty("user.dir")+
				"/Screenshot/" + fileName +".png"));
		
	} catch (IOException e) {
		e.getStackTrace();
	}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
//		ChromeOptions options =  new ChromeOptions();
//	options.addArguments("--headless=new");
//	options.addArguments("--window-size=1920,1080");
//	options.addArguments("--disable-gpu");
//	options.addArguments("--no-sandbox");
//	options.addArguments("user-agent=Mozilla/5.0");
//	options.addArguments("--disable-dev-shm-usage");
//	driver = new ChromeDriver(options);
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("login_Layer")).click();
		
		WebElement register =driver.findElement(By.xpath("//a[text()=\"Register for free\"]"));
		WebElement userName = driver.findElement(By.xpath("//input[@placeholder=\"Enter your active Email ID / Username\"]"));
		WebElement pass = driver.findElement(By.xpath("//input[@placeholder=\"Enter your password\"]"));
		WebElement Loginbtn = driver.findElement(By.xpath("//button[@class=\"btn-primary loginButton\"]"));
		Actions action = new Actions(driver);
		
		Action seriesOfAction;
		seriesOfAction = action
				.sendKeys(userName,"s.shankar2905@gmail.com")
				.sendKeys(pass,"Robin@123")
				.click(Loginbtn).build();
				seriesOfAction.perform();
				
		
			for(int i= 0; i<1; i++){
				List<WebElement>closebtn= driver.findElements(By.xpath("//div[@class='crossIcon chatBot chatBot-ic-cross']"));
		if(closebtn.size()> 0) {
			closebtn.get(0).click();
			System.out.println("Close pop-up");
		break;
		}else {			
					System.out.println("Pope up not displayed");
				}		
				
			}
		Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[@class=\"nI-gNb-drawer__icon-img-wrapper\"]")).click();
		 for(int i = 0; i<5; i++) {
			 try {
					WebElement viewProfile= driver.findElement(By.xpath("//a[text()=\"View & Update Profile\"]"));
					viewProfile.click();
					System.out.println("Clicked View Profile");
			 break;
			 }catch (Exception e) {
				System.out.println("Retriying.."+ i);
				Thread.sleep(1000);
				takeScreenShots("failed attempt .."+i);
			}
		 }
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement naukariLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"nI-gNb-header__logo nI-gNb-company-logo\"]")));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	


		WebElement uploadResume= driver.findElement(By.xpath("(//input[@type='file' and @class='fileUpload waves-effect waves-light btn-large'])[1]"));
		/* js.executeScript("arguments[0].scrollIntoView(true)", uploadResume); */
		 js.executeScript("arguments[0].scrollIntoView({behaviour:'smooth',block: 'center'});",uploadResume); // Naviagtes to center of the screen 
	
	boolean isMismatched = false;
	for(int i =1;i<=10; i++ ) {
		

uploadResume.sendKeys("C:\\Users\\User\\Documents\\Fireflink\\General\\Uma_ShankarS_QA_2.pdf");

System.out.println("Uploading resume attempt: "+ i);
String text = driver.findElement(By.xpath("//div[@class=\"updateOn typ-14Regular\"]")).getText();

String dateText = text.replace("Uploaded on ", "").trim();
// System.out.println(dateText);

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH);

LocalDate uiDate = LocalDate.parse(dateText, formatter);

LocalDate currentDat = LocalDate.now();

if (uiDate.equals(currentDat)) {
    System.out.println("Date Matched");
    isMismatched = true;
    break; // stop loop

}
else {
    System.out.println("Date mismatched retrying...");
    takeScreenShots("failed attempt .."+i);
  
}
	}
if(!isMismatched) {
	System.out.println("Upload falied after Max attempts");
	takeScreenShots("Final_Failure");
}
driver.quit();
	
	
}

	}
	
	
	
	
	

