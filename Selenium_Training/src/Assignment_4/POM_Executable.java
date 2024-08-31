package Assignment_4;

import Datasource.*;
import org.openqa.selenium.WebDriver;

public class POM_Executable {

	public static WebDriver driver;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Database_Page dbObj = new Database_Page(driver);
		dbObj.launchWebDriver();
		dbObj.accessProductTable();
		dbObj.storeProductTableData();
		
		ExcelXUtil exlObj = new ExcelXUtil(dbObj.ExcelPath); 
		dbObj.verifyDataSheet(exlObj,dbObj.prodList);
		
		dbObj.CloseWebDriver();
	}

}
