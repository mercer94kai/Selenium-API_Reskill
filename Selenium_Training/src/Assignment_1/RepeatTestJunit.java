package Assignment_1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RepeatTestJunit {
	
	@Parameterized.Parameters
	public static Object[][] data(){
		return new Object[10][0];
	}
	
//	public  RepeatTestJunit() {
//	}
	
	@Test
	public void test() {
		System.out.println("run");
	}

}
