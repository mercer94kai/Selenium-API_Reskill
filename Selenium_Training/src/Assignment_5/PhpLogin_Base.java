package Assignment_5;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;


@RunWith(Parameterized.class)
public class PhpLogin_Base {
	
	public static WebDriver driver;
	public String UsrNm;
	public String Pswrd;
	PhpLogin_Page pageObj;
	
	public PhpLogin_Base(String UsrNm, String Pswrd) {
		this.UsrNm=UsrNm;
		this.Pswrd=Pswrd;
	}
	
    @Parameters
	public static Collection<Object[]>data(){
		return Arrays.asList(new Object[][] {
			{"user@phptravels.com","demouser"},
			//{"admin@phptravels.com","demoadmin"}
		});
	}
	
  @Test
  public void VerifyLogin () {
	  
	  pageObj=new PhpLogin_Page(driver);
	  pageObj.launchWebDriver();
	  pageObj.Login_into_Page(UsrNm,Pswrd);
	  pageObj.loginStatus();
	  pageObj.CloseWebDriver();
  }
}
