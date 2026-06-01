package DataProvider;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.apache.poi.ss.usermodel.Cell;

public class DataDrivernExcel {
	
	//WebDriver driver;
	Workbook wb;
Sheet sheet;
	public DataDrivernExcel(String filePath) {
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\User\\Desktop\\Excel_testing.xlsx");
			wb= new XSSFWorkbook(file);
			sheet = wb.getSheetAt(0);
		} catch (Exception e) {
		e.printStackTrace();	
		}
		}
		public String getData(int rowNum, int colNum) {
			if (sheet.getRow(rowNum)== null)return ""; {
			Cell cell = sheet.getRow(rowNum).getCell(colNum);
			if(cell == null) return "";
			switch (cell.getCellType()) {
			case STRING: {
				
				return cell.getStringCellValue();
			}
			case BOOLEAN:{
				return String.valueOf(cell.getBooleanCellValue());
			}
			case NUMERIC:{
			
				 return String.valueOf((long) cell.getNumericCellValue());
			}
			default:
				return "";
			}
		
		}}
		public void close() {
			try {
				wb.close();
			
			} catch (Exception e) {
				e.printStackTrace();			}
			
		}
 	
}


