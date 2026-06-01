package dataProviderInTestNg;

import org.testng.annotations.Test;

public class DataDriver_Excel_main {
	
	@Test(dataProvider = "testData", dataProviderClass = DataDriven_Excel.class)
	public void testLogin(String Email,String Password ) {
		System.out.println(Email + " | " + Password);
	}

}
