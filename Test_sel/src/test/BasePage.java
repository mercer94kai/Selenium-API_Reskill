package test ;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigurationRead;

public class BasePage {
	
	public static  WebDriver driver;
	ConfigurationRead prop;
	
	public void initDriver(String browserName) {
		
		
		prop = new ConfigurationRead();
		String driversPath=System.getProperty("user.dir")+"\\resources";
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driversPath+"\\chromedriver.exe");
			this.driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driversPath+"\\geckodriver.exe");
			this.driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public String getBrowserTitle() {
		return driver.getTitle();
	}
	
	public void launchApp() throws IOException {
		 this.driver.get(prop.readProperties().getProperty("URL"));
	}
	
	

}
