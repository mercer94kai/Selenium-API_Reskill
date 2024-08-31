package Assignment_5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhpLogin_Page {

	public WebDriver driver;
	private String Page_URL="https://www.phptravels.net/home";
	private String Btn_1="(//*[@id='dropdownCurrency'])[2]";
	private String Btn_2="//a[@class='dropdown-item active tr']";
	private String UsrNm="username";
	private String Psw="password";
	private String Login_Btn="//*[@id=\"loginfrm\"]/button"; 
	private String targetURl="https://www.phptravels.net/account/";
	
	public PhpLogin_Page(WebDriver driver) {
		this.driver=driver;
	}
	
	public void launchWebDriver() {
		
		  System.out.println("*********Launching WebDriver*********");
		  System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
	      driver= new ChromeDriver();
	      driver.get(Page_URL);
	      driver.manage().window().maximize();
	     
	}
	
	public void CloseWebDriver() {
		driver.close();
	}
	
	public void Login_into_Page(String arg1, String arg2) {
		
		System.out.println("User_Name:"+arg1+"\n Password:"+arg2+"\n");
		
		driver.findElement(By.xpath(Btn_1)).click();
		driver.findElement(By.xpath(Btn_2)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name(UsrNm)).sendKeys(arg1);
		driver.findElement(By.name(Psw)).sendKeys(arg2);
		driver.findElement(By.xpath(Login_Btn)).click();
	}
	
	public void loginStatus() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().equals(targetURl))
		{
			System.out.println("*****Login is Successfull*****");
		}
		else
		{
			System.out.println("*****Login is not Successfull*****");
		}
	}
	
	
}
