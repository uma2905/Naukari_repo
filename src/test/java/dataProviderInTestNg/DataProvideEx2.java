package dataProviderInTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideEx2 {
	
	static WebDriver driver;
	
	@Test(dataProvider="testdata")
	public void testFirefox(String usName, String password) {
 driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[@class=\"ico-login\" and text()=\"Log in\"]")).click();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(usName);
	
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector(".button-1.login-button")).click();
		
	}
 @DataProvider(name= "testdata")
	 public Object[][] TestDataFeed(){
		 Object [][] faceBookdata= new Object[2][2];
		
		 
		 // Enter data to row 1 user 1
		 faceBookdata[0][0]="robinrebel5552@gmail.com";
		 faceBookdata[0][1]="Robin@123";
		 
		 // Enter data to row2 user2
		 
		 faceBookdata[1][0]="lid4i9oqauk670mwzshu6lzejzn4@gmail.com";
				 faceBookdata[1][1]="Robin@123";
		 return faceBookdata;
		
	 }
 
 }

