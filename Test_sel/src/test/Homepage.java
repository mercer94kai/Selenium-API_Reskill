package test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {
	public WebDriver driver;
	@FindBy(xpath="//*[@id=\"login-block\"]/div/ul/li[1]/a")
	WebElement Signup_btn;
	@FindBy(xpath="//*[@id=\"profileCollapse\"]/div/ul/li[2]/a")
	WebElement Compose_btn;
	@FindBy(className="select2-search__field")
	WebElement Send_to_box;
	@FindBy(id="compose_message_title")
	WebElement Subject_box;
	@FindBy(xpath="//*[@id=\"cke_1_contents\"]/iframe")
	WebElement findPath;
	@FindBy(xpath="/html/body/p[1]")
	WebElement writeMsg;
	@FindBy(id="compose_message_compose")
	WebElement Send_msg_btn;
	@FindBy(xpath="//*[@id=\"cm-content\"]/div/div[2]/div/div[1]")
	WebElement ack_Msg;
	
	@FindBy(id="login")
	WebElement login_box;
	@FindBy(id="password")
	WebElement pwd_box;
	@FindBy(id="form-login_submitAuth")
	WebElement login_btn;
	@FindBy(xpath="//*[@id=\"homepage-course\"]/div/p[1]")
	WebElement loginver_msg;
	
	
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSignupBtn() {
		Signup_btn.click();
	}
	
	public void clickComposeBtn() {
		Compose_btn.click();
	}
	
	public void writeMail(String recipient, String subject, String msgbody) throws InterruptedException {
		Send_to_box.sendKeys("naveen");
		Thread.sleep(3000);
		Send_to_box.sendKeys("\n");
		Subject_box.sendKeys("Testing");
		driver.findElement(By.id("cke_1_contents"));
		driver.switchTo().frame(1);
		System.out.println("Switched frame");
		//writeMsg.sendKeys("This mail is for testing");
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		Send_msg_btn.click();
	}
	
	public void verifySendMsgAck() {
		
		if (ack_Msg.getText().contains("The message has been sent to "))
			{
			System.out.println("Message was sent successfully ");
			}
		else 
			{
			System.out.println("Error Sending Message");
			}
	}
	
	public void verifyLogin(String username, String Password, String fullName)
	{
		login_box.sendKeys(username);
		pwd_box.sendKeys(Password);
		login_btn.click();
		Assert.assertTrue(loginver_msg.getText().contains(fullName));
	}
}
