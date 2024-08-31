package test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration extends BasePage {
	public WebDriver driver;
	@FindBy(id="registration_firstname")
	WebElement first_Name;
	@FindBy(id="registration_lastname")
	WebElement last_Name;
	@FindBy(id="registration_email")
	WebElement email_id;
	@FindBy(id="username")
	WebElement UsrNm;
	@FindBy(id="pass1")
	WebElement pass;
	@FindBy(id="pass2")
	WebElement con_pass;
	@FindBy(id="registration_submit")
	WebElement reg_btn;
	@FindBy(xpath="//*[@id=\"cm-content\"]/div/div[2]/div/p[1]")
	WebElement Conf_Msg;
	@FindBy(xpath="//*[@id=\"navbar\"]/ul[2]/li[2]/a")
	WebElement dropdown_btn;
	@FindBy(xpath="//*[@id=\"navbar\"]/ul[2]/li[2]/ul/li[1]/div/a/p")
	WebElement dropdown_ver;
	
	
	@FindBy(xpath="//*[@id=\"navbar\"]/ul[1]/li[1]/a")
	WebElement Home_btn;
	
	
	
	public Registration(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String firstName) {
		first_Name.clear();
		first_Name.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		last_Name.clear();
		last_Name.sendKeys(lastName);
	}
	public void enterEmail(String email) {
		email_id.clear();
		email_id.sendKeys(email);
	}
	
	public void enterUserName(String usrName) {
		UsrNm.clear();
		UsrNm.sendKeys(usrName);
	}
	
	public void enterPass(String pwd) {
		pass.clear();
		pass.sendKeys(pwd);
	}
	
	public void enterConPass(String conPwd) {
		con_pass.clear();
		con_pass.sendKeys(conPwd);
	}
	public void clickRegistrationButton() {
		reg_btn.click();
	}
	
	public void VerifyConfMsg(String msg) {
		
	/*	if(Conf_Msg.getText().contains(msg))
			{
			System.out.println("Registration Acknowledged");
			}
		else
			{
			System.out.println("Registration Not Acknowledged");
			}
	*/
	//Assert.assertTrue(Conf_Msg.getText().contains(msg));
	dropdown_btn.click();
	Assert.assertTrue(dropdown_ver.getText().contains(msg));
	
	}
	
	public void clickHomepageBtn() {
		Home_btn.click();
	}
}
