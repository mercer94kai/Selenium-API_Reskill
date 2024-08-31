package Assignmnet_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testng_cls_2 {
	
	public static WebDriver driver;
	  public static boolean flag;

	  public static void switchToWindowIndex(int index) {
		    Set<String> windowHandles = driver.getWindowHandles();
		    List<String> windowStrings = new ArrayList<>(windowHandles);
		    String reqWindow = windowStrings.get(index);
		    driver.switchTo().window(reqWindow);
		}
	  
	  @Parameters({"browserName"})
	  @BeforeTest	
	  public void setupBrowser(String browser) {
		  
		  if(browser.equals("Chrome"))
		  	{
			  System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
			  driver= new ChromeDriver();
		  	}
		  else if(browser.equals("Firefox")) 
		  	{
			  System.setProperty("webdriver.chrome.driver", "Resources\\geckodriver.exe");
			  driver= new FirefoxDriver();
		  	}
	  }
	  
	  @Test
	  public void verifyPageIsLoaded() throws InterruptedException {
		  
		  driver.get("https://www.online.citibank.co.in/");
	      driver.manage().window().maximize();

		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  WebDriverWait wait1 = new WebDriverWait(driver, 10);
	      wait1.until(ExpectedConditions.elementToBeClickable(By.id("loginId")));

	      Assert.assertTrue(driver.findElement(By.id("loginId")).isEnabled(), "Page isn't loaded properly");
		  
	      }
	  
	  @Test(dependsOnMethods="verifyPageIsLoaded")
	  public void verifyDropdownItem() throws InterruptedException {
		  
		  driver.findElement(By.className("applyTxt")).click();
	      List<WebElement> list=driver.findElements(By.xpath("//*[@class=\"applyDiv\"]/ul/li"));
	      
	      for (WebElement e1 : list)
	      	{
	    	  System.out.println(e1.getText());
	    	  if (e1.getText().equals("Credit Cards"))
	    	  	{
	    		  flag=true;
	    		  break;
	    	  	}
	    	  else
	    	  	{
	    		  flag=false;
	    	  	}
	      	}
	      
	      Assert.assertTrue(flag, "--->Dropdown doesn't contain Credit Cards option");
	   }
	  
	  @Test(dependsOnMethods="verifyDropdownItem")
	  public void verifyNewWindowTitle() throws InterruptedException {
		  
		  driver.findElement(By.id("loginId")).click();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      switchToWindowIndex(1);
	      String getTitle=driver.getTitle();
	      String getURL=driver.getCurrentUrl();
	      
	      Assert.assertTrue(driver.getTitle().equals("Citibank India"), "Error: Wrong browser title!"); 
	       
		  Assert.assertTrue(driver.getCurrentUrl().equals("https://www.citibank.co.in/ibank/login/IQPin1.jsp"), "Error: Wrong page URL!");
	     
	     }
	  
	  @Test(dependsOnMethods="verifyNewWindowTitle")
	  public void verifyWindowMsg() throws InterruptedException {
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.id("User_Id")).sendKeys("TESTUSER");
		  driver.findElement(By.xpath("//*[@class=\"cl fl ls_login\"]")).click();
		  
		  switchToWindowIndex(2);
		  String Msg=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/blockquote/p")).getText();
		  
		  Assert.assertEquals(Msg, "Please enter your internet password .", "Error: wrong message showing");
	      }
	  
	  @Test(dependsOnMethods="verifyWindowMsg")
	  public void verifyHLpageIsLoaded() throws InterruptedException {
		  
		  driver.close();							  
		  switchToWindowIndex(1);
		  
		  driver.close();						
		  switchToWindowIndex(0);
		  
		  driver.findElement(By.id("topMnuhomeloans")).click();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		  Assert.assertTrue(driver.findElement(By.id("homelendingSubMenu")).isEnabled(), "Home Loans page is not Visible");
		  
	      }
	  
	  @AfterTest
	  public void closeBrowser() {

		  driver.close();
	  }
}
