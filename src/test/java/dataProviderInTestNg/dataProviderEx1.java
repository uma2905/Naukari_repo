package dataProviderInTestNg;

import org.bouncycastle.its.ITSPublicEncryptionKey.symmAlgorithm;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderEx1 {

	
	@Test(dataProvider="getData")
	public void setData(String username, String password, String path ) {
		System.out.println("User name is :"+ username);
		System.out.println("User Password is: password");	
	}
@DataProvider
public Object[][] getData(){
	Object[][] data = new Object[3][2];
	
	// row 1
	        data[0][0]="user1";
			data[0][1]="Uma";
	
// Row 2
		data[1][0]="user2";
		data[1][1]= "Robin";
		
		
		// Row 3
		
		data[2][0]= "user3";
		data[2][1]= "Shankar";
		return data;
		
		
	
}
}
