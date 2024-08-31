package test;

import java.io.IOException;

import org.openqa.selenium.By;

import test.BasePage;
import test.Homepage;
import test.Registration;

public class Mainpage extends BasePage {
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		BasePage bp = new BasePage();
		bp.initDriver("chrome");
		bp.launchApp();

		Homepage hp= new Homepage(driver);
		Registration rpg= new Registration(driver);
		
		/*
		hp.clickSignupBtn();
		//System.out.println(driver.getTitle());
		rpg.enterFirstName("aaa");
		rpg.enterLastName("bbb");
		rpg.enterEmail("aaa@wwety.com");
		rpg.enterUserName("bbbA");
		rpg.enterPass("bbb@1234");
		rpg.enterConPass("bbb@1234");
		rpg.clickRegistrationButton();
		System.out.println(driver.getTitle());
		rpg.VerifyConfMsg("aaa bbb");
		
		//rpg.clickHomepageBtn();
		
		*/
		hp.verifyLogin("JohnC", "John@1234", "John Cena");
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[1]/li[1]/a")).click();
		System.out.println(driver.getTitle());
		/*
		hp.clickComposeBtn();
		hp.writeMail("naveen", "GUI Test", "This mail is for testing");
		hp.verifySendMsgAck();
		*/
	}

}
