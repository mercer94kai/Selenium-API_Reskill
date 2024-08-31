package Assignment_2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sel_Asg_2 {
	
	public static boolean flag;
	public static WebDriver driver;
	//public static boolean loader;
	
	public static void switchToWindowIndex(int index) {
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> windowStrings = new ArrayList<>(windowHandles);
	    String reqWindow = windowStrings.get(index);
	    driver.switchTo().window(reqWindow);
	   // System.out.println("Switched to " + driver.getTitle());
	}
	
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
	      driver= new ChromeDriver();
	      driver.get("https://www.online.citibank.co.in/");
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      /*
	      loader=driver.findElement(By.tagName("body")).isDisplayed();
	      
	      if(loader)
	      {
	    	  System.out.println("Page is loaded");
	      }
	      else
	      {
	    	  System.out.println("Page is not loaded");
	      }
	      */
	
	      WebDriverWait wait1 = new WebDriverWait(driver, 10 );
		  
	      //*** Verifying “Credit Cards” in the dropdown
	      
	      wait1.until(ExpectedConditions.elementToBeClickable(By.className("applyTxt")));
		  driver.findElement(By.className("applyTxt")).click();
//		  
//		  FluentWait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)
//				  							.withTimeout(Duration.ofMinutes(1))
//				  							.pollingEvery(Duration.ofSeconds(1))
//				  							.ignoring(NoSuchElementException.class);
		  
	      List<WebElement> list=driver.findElements(By.xpath("//*[@class=\"applyDiv\"]/ul/li"));
	      //System.out.println(list.size());
	      
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
	      
	      if (flag)
	      {
	    	  System.out.println("---->Dropdown contains Credit Cards option");
	      }
	      else {
	    	  System.out.println("---->Dropdown doesn't contain Credit Cards option");
	      }

	      
	      driver.findElement(By.id("loginId")).click();
	      
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      //***Switching to new window and verify title of new window and URL 
	      
	      switchToWindowIndex(1);
	     
	       if (driver.getTitle().equals("Citibank India") && driver.getCurrentUrl().equals("https://www.citibank.co.in/ibank/login/IQPin1.jsp"))
		  {
			  System.out.println("---->Page Title & URL are verified for Citibank India page");
		  }
		  else {
			  System.out.println("Error: Wrong page!");
		  }
	      
	      System.out.println("===>"+driver.getTitle());
	      System.out.println("===>"+driver.getCurrentUrl());
	      //*** Entering username and clicking on login button
	       
		  driver.findElement(By.id("User_Id")).sendKeys("TESTUSER");
		  driver.findElement(By.xpath("//*[@class=\"cl fl ls_login\"]")).click();
		  
		  //***Verifying message displayed – “Please enter your internet password” 
		  
		  switchToWindowIndex(2);
		  String Msg=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/blockquote/p")).getText();

		  if (Msg.equals("Please enter your internet password ."))
		  {
			  System.out.println("Message is Verified");
		  }
		  else
		  {
			  System.out.println("Error: wrong message showing");
		  }
		  
		  
		  driver.close();						//** closing the 3rd window
		  
		  switchToWindowIndex(1);
		  driver.close();						//** closing the 2nd window
		  
		  switchToWindowIndex(0);
		  
		  //*** In the main citi website click on “Home Loans” and verify it has opened Home loans page
		  
		  driver.findElement(By.id("topMnuhomeloans")).click();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  if(driver.findElement(By.id("homelendingSubMenu")).isEnabled())
		  {
			  System.out.println("Home Loans page is Visible");
		  }
		  else
		  {
			  System.out.println("Home Loans page is not Visible");
		  }
	}

}
