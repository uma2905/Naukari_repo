package dataProviderInTestNg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;   // ✅ CORRECT (for Excel)

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DataDriven_Excel {
WebDriver driver; 

@Test(dataProvider = "testData")
public void DemoProject(String username, String Password) throws InterruptedException {
	driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://demowebshop.tricentis.com/");
driver.findElement(By.xpath("//a[@class=\"ico-login\" and text()=\"Log in\"]")).click();
driver.findElement(By.id("Email")).clear();
driver.findElement(By.id("Email")).sendKeys(username);

driver.findElement(By.id("Password")).sendKeys(Password);
driver.findElement(By.cssSelector(".button-1.login-button")).click();
AssertJUnit.assertTrue(driver.getTitle().contains("Demo Web Shop. Login"));

Thread.sleep(3000);
}
@AfterMethod
public void ProgramTermiante() {
	driver.quit();
}
@DataProvider(name ="testData")
public Object[][] TestDtaFeed() throws IOException{
	FileInputStream file = new FileInputStream("C:\\Users\\User\\Desktop\\Excel_testing.xlsx");
	Workbook wb = new XSSFWorkbook(file);
	Sheet sheet = wb.getSheetAt(0);

	
 // excluding header, Returns last row index in the sheet and To know how many rows of data exist	
	int rows = sheet.getLastRowNum(); 
	int cols = sheet.getRow(0).getLastCellNum();   //Gets number of columns from first row (header)
  
 Object[][] data= new Object[rows][cols];
    
    for(int i=1; i<=rows; i++) { // Skip Header
    	for(int j =0; j<cols; j++)            {
    		Cell cell = sheet.getRow(i).getCell(j);
    		if(cell==null) {
    			data[i-1][j]="";
    		}else {
    			switch (cell.getCellType()) {
				case STRING:
					data[i-1][j]=cell.getStringCellValue();
					break;
case NUMERIC:
	   data[i-1][j] = String.valueOf((long) cell.getNumericCellValue());
					break;
				
    			case BOOLEAN:
    				data[i-1][j]=cell.getBooleanCellValue();
    				break;
    				default:
    				data[i-1][j]="";
    		}
    		}
    	}
    	
    }
    wb.close();
    file.close();
	return data;
	
	
		
}


}
