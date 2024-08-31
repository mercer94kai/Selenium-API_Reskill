package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends BasePage {
	public WebDriver driver;
	@FindBy(name="username")
	WebElement email_textBox;
	@FindBy(name="password")
	WebElement password_textBox;
	@FindBy(xpath="//button[text()='Login']")
	WebElement login_Button;
	@FindBy(xpath="//*[@id='loginfrm']/div[1]/div")
	WebElement error_div;
	
	public Login_Page(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) {
		email_textBox.clear();
		email_textBox.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		password_textBox.clear();
		password_textBox.sendKeys(password);
	}
	
	public void clickLoginButton() {
		login_Button.click();
	}
	
	public String getLoginErrorMessage() {
		return error_div.getText();
	}
	
	


}
