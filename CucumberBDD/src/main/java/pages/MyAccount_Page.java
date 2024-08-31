package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DateTimeGenerator;

public class MyAccount_Page extends BasePage {
	public WebDriver driver;
	public String sourceDate;
	DateTimeGenerator dtg;
	
	@FindBy(xpath="(//*[@id='dropdownCurrency'])[1]")
	WebElement myAccount_currencyDrpdwn;
	@FindBy(xpath="(//div[@class='dropdown-menu-inner']/a[8])[1]")
	WebElement myAccount_INRindex;
	@FindBy(xpath="//span[@class='h4']")
	WebElement myAccount_fetchDate;
	@FindBy(xpath="(//li[@class='nav-item'])[1]")
	WebElement myAccount_Bookings;
	@FindBy(xpath="(//li[@class='nav-item'])[2]")
	WebElement myAccount_myProfile;
	@FindBy(xpath="(//li[@class='nav-item'])[3]")
	WebElement myAccount_WishList;
	@FindBy(xpath="(//li[@class='nav-item'])[4]")
	WebElement myAccount_Newsletter;
	
	public MyAccount_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectINR() {
	
		myAccount_currencyDrpdwn.click();
		myAccount_INRindex.click();
	}
	
	public boolean verifyDate() {
		
		dtg=new DateTimeGenerator();
		sourceDate=myAccount_fetchDate.getText();
		if(sourceDate.equals(dtg.DateRetriver())) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void ClickOnoptions(String option) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch(option) {
		
		case "MY PROFILE":
			  myAccount_myProfile.click();
			  break;
			  
		  case "WHISLIST":
			  myAccount_WishList.click();
			  break;
			  
		  case "NEWSLETTER":
			  myAccount_Newsletter.click();
			  break;
			  
		  case "BOOKINGS":
			  myAccount_Bookings.click();
			  break;
		  default:
			  System.out.println("Give Proper Input");
		
		}

	}
}
