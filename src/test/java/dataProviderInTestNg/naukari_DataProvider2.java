package dataProviderInTestNg;


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

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class naukari_DataProvider2 {


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
		
		@Test
		(dataProvider ="data")
		public void naukariUpdate(String userName, String password, String path) throws InterruptedException {
			
			driver = new ChromeDriver();
//			ChromeOptions options =  new ChromeOptions();
//		options.addArguments("--headless=new");
//		options.addArguments("--window-size=1920,1080");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--no-sandbox");
//		options.addArguments("user-agent=Mozilla/5.0");
//		options.addArguments("--disable-dev-shm-usage");
//		driver = new ChromeDriver(options);
			driver.get("https://www.naukri.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.id("login_Layer")).click();
			
			WebElement register =driver.findElement(By.xpath("//a[text()=\"Register for free\"]"));
//		
			driver.findElement(By.xpath("//input[@placeholder=\"Enter your active Email ID / Username\"]")).sendKeys(userName);
					
            driver.findElement(By.xpath("//input[@placeholder=\"Enter your password\"]")).sendKeys(password);
			driver.findElement(By.xpath("//button[@class=\"btn-primary loginButton\"]")).click();
			Actions action = new Actions(driver);
			

			
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
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement naukariLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"nI-gNb-header__logo nI-gNb-company-logo\"]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		

////input[@type='file' and @class='fileUpload waves-effect waves-light btn-large'])[1]"));
			WebElement uploadResume= driver.findElement(By.xpath("//input[@id='attachCV']"));
			/* js.executeScript("arguments[0].scrollIntoView(true)", uploadResume); */
			 js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block: 'center'});",uploadResume); // Naviagtes to center of the screen 
		
			 
			 
			 List<WebElement>deleteResume = driver.findElements(By.xpath("//span[@data-title=\"delete-resume\"]"));
			 
					 if(deleteResume.size()>0) {
						 deleteResume.get(0).click();
						 
		 WebElement deleteBtn=  driver.findElement(By.xpath("(//button[@class=\"btn-dark-ot\" and text()='Delete'] )[2]"));
					
					 js.executeScript("arguments[0].click();", deleteBtn);
					 
					 System.out.println("Old Resume Deleted");
					 
Thread.sleep(3000);					 
					 }else {
	System.out.println("No Resume present");
}
					 


	 
			 
		boolean isMismatched = false;
		for(int i =1;i<=10; i++ ) {
			

Thread.sleep(3000);


		uploadResume.sendKeys(path);

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
	}}
		
		@AfterMethod
		public void closeBrowser() {
			driver.close();
		}		
		@DataProvider(name ="data")
		public  Object[][] testDataFiled(){
			Object[][] data= new Object[4][3];
			
			
			// Data for QA resume

			data[0][0]="s.shankar2905@gmail.com";
			data[0][1]="Robin@123";

			data[0][2]=System.getProperty("user.dir")+"/resume/Uma_Shankar_QA_Engineer_Resume.docx";
			

			

			
			// Data for ProductAnalyst resume
			data[1][0]="s.umashankar5552@gmail.com";
			data[1][1]="Robin@123";

			data[1][2]=System.getProperty("user.dir")+"/resume/Uma_Shankar_Resume.docx";


			
			//Data for IAM resume
			data[2][0]="iamumashankar3@gmail.com";
			data[2][1]="Robin@123";
			data[2][2]=System.getProperty("user.dir")+"/Resume/Uma_Shankar_IAM_Engineer_Resume.docx";
			
			
			// Buddy 
			
			data[3][0]="umabuddy5552@gmail.com";
			data[3][1]="6361888970";
			data[3][2]=System.getProperty("user.dir")+"/Resume/Reddy_resume.docx";
			
			return data;

		}
		
		
		
		
		


}

