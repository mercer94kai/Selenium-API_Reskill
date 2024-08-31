package Assignmnet_3;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testng_cls_1 {

	WebDriver driver;	
	
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
	  public void printItems() throws InterruptedException {
		  
		  driver.get("http://automationpractice.com/index.php?");
	      driver.manage().window().maximize();
	      Thread.sleep(2000);
	      
	      driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
	      Thread.sleep(2000);
	      
	      List<WebElement> products= driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
	      int index=1;

	      for (WebElement e1 : products)
	      {
	    	  String p_name= driver.findElement(By.xpath("//*/li["+index+"]/div/div[2]/h5/a")).getText();
	    	  
	    	  String p_price= driver.findElement(By.xpath("//*/li["+index+"]/div/div[2]/div[1]/span[1]")).getText();
	    	  System.out.println(p_name +" :"+p_price);
	    	  index++;
	      }
	  }
	  
	  @AfterTest
	  public void closeBrowser() {

		  driver.close();
	  }

}
