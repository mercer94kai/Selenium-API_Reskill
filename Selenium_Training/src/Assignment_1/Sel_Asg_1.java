package Assignment_1;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Sel_Asg_1 {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		
		 // System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
	    //  WebDriver driver= new ChromeDriver();
		 
		/*
		  ChromeOptions option= new ChromeOptions();
		  option.setCapability("browserName", BrowserType.CHROME);
	   
		  FirefoxOptions option = new FirefoxOptions();
		  option.setCapability("browserName", BrowserType.FIREFOX);
		  */
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("browserName", BrowserType.CHROME);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.106:4444"), capability);
		  
		  
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
	      
	      Thread.sleep(2000);
	      driver.close();
	      
	}

}
