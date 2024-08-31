package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeGenerator {

	public Object DateRetriver() {
	 	Date date = new Date();  
	 	SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
	    String strDate = formatter.format(date);
	    return strDate;  
	}


}
