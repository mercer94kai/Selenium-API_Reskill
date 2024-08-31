package Assignment_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	public static WebDriver driver;
	@org.junit.Test
	public void test() {
				
		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
	      driver= new ChromeDriver();
	      driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
	      driver.manage().window().maximize();

	}

}
