package stepdefintions;

import io.cucumber.java.en.Given;
import pages.BasePage;
import pages.Login_Page;
import pages.Main_Page;
import pages.MyAccount_Page;
import utils.WaitHelper;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.devtools.page.Page.CaptureScreenshotFormat;

import io.cucumber.java.en.*;

public class LoginStepDefinitions extends BasePage{
	  Main_Page main_Page;
	  Login_Page login_Page;
	  MyAccount_Page acc_Page;
	  WaitHelper waithelper;
	  
	
	@Given("user is already on login page")
	public void user_is_already_on_login_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
	   initDriver("chrome");
	   launchApp();
	   main_Page= new Main_Page(driver);
	   login_Page= new Login_Page(driver);
	   acc_Page=new MyAccount_Page(driver);
	   waithelper= new WaitHelper(driver);
	 
	   main_Page.clickMyAccDropdown();
	   main_Page.clickLoginLInk();
	
	   
	}


	
	@And("title of login page is login")
	public void title_of_login_page_is_login() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("Login", getBrowserTitle());
		
	    
	}
	//@When("^user enters \"(.*)\" and \"(.*)\"$")
	@When("user enters {string} and {string}")
	public void user_enters_username_and_password(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		login_Page.enterEmail(username);
		login_Page.enterPassword(password);
		
		
	   
	}
	@Then("user clicks on Login button")
	public void user_clicks_on_Login_button() {
	    // Write code here that turns the phrase above into concrete actions
		login_Page.clickLoginButton();
	
	    
	}
	@Then("User is on home page")
	public void user_is_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		waithelper.waitForPageLoaded();
		Assert.assertEquals("My Account", getBrowserTitle());
		
	   
	}
	
	@But("User is not on home page")
	public void user_is_not_on_home_page() {
		waithelper.waitForPageLoaded();
		Assert.assertEquals("Login", getBrowserTitle());
	}
	
	@Then("login error is displayed")
	public void login_error_is_displayed() {
		waithelper.waitForPageLoaded();
		Assert.assertEquals("Invalid Email or Password", login_Page.getLoginErrorMessage());
		
	}
	
	@Then("User clicks on currency dropdown and select INR")
	public void user_clicks_on_currency_dropdown_and_select_INR() {
			acc_Page.selectINR();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Then("User verifies date displayed is currentdate")
	public void user_verifies_date_displayed_is_currentdate() {
	    Assert.assertEquals("Invalid Date", true, acc_Page.verifyDate());
	}
	
	@Then("User  clicks on {string} link")
	public void user_clicks_on_link(String string) {
		acc_Page.ClickOnoptions(string);
	}

	@And("user closes browser")
	public void user_closes_browser() {
		
		driver.close();
		
	}

}
