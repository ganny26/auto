package com.TestNG.firstTestCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	public String  getPropertyFromConfig(String key){
		Properties prop = new Properties();
		InputStream input = null;
		String filePath = null;
		try {
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			filePath = prop.getProperty(key);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return filePath;
	}	
}
