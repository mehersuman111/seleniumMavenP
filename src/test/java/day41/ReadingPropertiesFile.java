package day41;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		Properties propObj = new Properties();
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		
		propObj.load(file);
		
		//Reading data from Properties file
		String url = propObj.getProperty("appURL");
		System.out.println("The url is " +url);
		
		//Reading all the Keys from properties file
		Set<String> keys = propObj.stringPropertyNames();
		System.out.println(keys);
		
		Set<Object> keys1 = propObj.keySet();
		System.out.println(keys1);
		
		//Reading all the values from the properties file.
		
		Collection<Object> values = propObj.values();
		
		// After doing all operation we have to close the properties file.
		file.close();
	}	

}
