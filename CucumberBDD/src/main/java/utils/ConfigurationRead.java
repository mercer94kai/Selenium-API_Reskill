package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationRead {
	
	
	public Properties readProperties() 
	{
		Properties prop=null;
		try {
			
		
	String value= null;
	String projectPath=	System.getProperty("user.dir");
	File textFile= new File(projectPath+"\\src\\test\\resources\\config.properties");
	FileInputStream fis;
	
		fis = new FileInputStream(textFile);
		prop = new Properties();
		prop.load(fis);
		
		
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return prop;

	}

}
