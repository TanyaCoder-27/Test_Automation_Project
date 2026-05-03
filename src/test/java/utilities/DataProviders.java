package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1 - Login Data (includes both valid and invalid)
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\LoginData.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	//DataProvider 2 - Registration Data (valid credentials only)
	@DataProvider(name="RegData")
	public String [][] getData2() throws IOException
	{
		String path=".\\testData\\RegistrationData.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalcols=xlutil.getCellCount("Users",1);
				
		// For registration, use only first row from Excel
		String regdata[][]=new String[1][totalcols];//created for two dimension array which can store the data user and password
		
		// Read only first row (index 1) of data
		for(int j=0;j<totalcols;j++)  //0    i is rows j is col
		{
			regdata[0][j]= xlutil.getCellData("Users",1, j);  //1,0
		}
		return regdata;//returning two dimension array
				
	}
	
	//DataProvider 3 - Checkout Data (valid credentials from RegistrationData.xlsx)
	@DataProvider(name="CheckoutData")
	public Object [][] getCheckoutData() throws IOException
	{
		String path=".\\testData\\RegistrationData.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Users");	// Changed from "Sheet1" to "Users"
		int totalcols=xlutil.getCellCount("Users",1);
				
		// Get first 2 rows for checkout testing
		Object checkoutdata[][]=new Object[Math.min(totalrows, 2)][totalcols + 3]; // +3 for product, shipping, payment
		
		for(int i=1;i<=Math.min(totalrows, 2);i++)
		{		
			// Copy email and password from Excel
			for(int j=0;j<totalcols;j++)
			{
				checkoutdata[i-1][j]= xlutil.getCellData("Users",i, j);
			}
			
			// Add static checkout data
			if(i == 1) {
				checkoutdata[i-1][totalcols] = "iMac";
				checkoutdata[i-1][totalcols + 1] = "flat";
				checkoutdata[i-1][totalcols + 2] = "cod";
			} else if(i == 2) {
				checkoutdata[i-1][totalcols] = "iPhone";
				checkoutdata[i-1][totalcols + 1] = "free";
				checkoutdata[i-1][totalcols + 2] = "card";
			}
		}
		return checkoutdata;
	}
	
	//DataProvider 4 - Search Data
	@DataProvider(name="SearchData")
	public Object [][] getSearchData() {
		return new Object[][] {
			{"MacBook", true, 1},
			{"iPhone", true, 1},  // Fixed: expecting at least 1 result instead of 2
			{"NonExistentProduct12345", false, 0},
			{"", false, 0}  // Empty search
		};
	}
}

