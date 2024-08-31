package Assignment_4;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Datasource.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Database_Page {
	
	public WebDriver driver;
	public static List<WebElement> prodList;
	public static int flag;
	private static String prodId;
	private static String prodName;
	private static String prod_cartID;
	private String dbURL= "https://dhtmlx.com/docs/products/demoApps/dhtmlxDBAdmin/index.html";
	private By treeBtn_1 = By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[1]/div");
	private By treeBtn_2 = By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[1]/div");
	private By openProductTable = By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[4]/span");
	private By proDataList= By.xpath("//table[@class=\"obj row20px\"]/tbody/tr");
	public String ExcelPath="Resources/Products_Data.xlsx";
	
	public Database_Page(WebDriver driver) 
	{
		this.driver = driver;
	}
	public void launchWebDriver() {
			
		  System.out.println("*********Launching WebDriver*********");
		  System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
	      driver= new ChromeDriver();
	      driver.get(dbURL);
	      driver.manage().window().maximize();
	     
	}
	
	public void CloseWebDriver() {
		driver.close();
	}
	
	public void accessProductTable()
	{
		System.out.println("*********Accessing Product Table In DB*********");
		driver.findElement(treeBtn_1).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(treeBtn_2).click();
		driver.findElement(openProductTable).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void storeProductTableData()
	{
		System.out.println("*********Fetching Product Table Data*********");
		prodList=driver.findElements(proDataList);
	}
	
	public void verifyDataSheet(ExcelXUtil exlObj, List<WebElement> prodList) {
	
		  System.out.println("*********Verifying Excel Data*********");
		
		  exlObj=new ExcelXUtil(ExcelPath);
		  
		  int row= exlObj.getRowCount("Sheet1");
	      int column= exlObj.getColumnCount("Sheet1", row-1);
	      
	      for (int i=1;i<row-1;i++)
	      {
	    		   prodId=exlObj.getCellValue("Sheet1", i, 0);
	    		   prodName=exlObj.getCellValue("Sheet1", i, 1);
	    		   prod_cartID=exlObj.getCellValue("Sheet1", i, 2);
	    		   
	    		   System.out.println("Verifying data For Row["+i+"]: "+prodId+" "+prodName+" "+prod_cartID);
	    		   for (WebElement e: prodList)
	   			{
	   				if (e.getText().contains(prodId+" "+prodName+" "+prod_cartID))
	   				{
	   					//exlObj.writCellValue("Sheet1", i, 3, "PASSED");    
	   					//System.out.println("PASSED");
	   					flag=1;
	   					break;
	   				}
	   				else
	   				{
	   					//System.out.println("FAILED");
	   					flag=0;
	   				}
	   				
	   			}
	    		   if (flag==1)
	    		   {
	    			   try {
						exlObj.writCellValue("Sheet1", i, 3, "PASSED");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    		   }
	    		   else
	    		   {
	    			   try {
						exlObj.writCellValue("Sheet1", i, 3, "FAILED");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    		   }
	   	     
	     }
	      
	      System.out.println("RESULT: Verification Process is completed....\n Please Chech the updated Excel file");
		
	}
	
}
