package com.qa.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static final ThreadLocal<Properties> propThread= new ThreadLocal<>();

	public static void initProp() {
		
		String env= System.getProperty("env","qa");
		String filePath= "config/config-" + env + ".properties"; 
	
		
		try(InputStream input= ConfigReader.class.getClassLoader().getResourceAsStream(filePath)){
			if(input==null) {
			throw new FileNotFoundException("Config File not found: "+ filePath);	
				
			}
			
			Properties prop = new Properties();
			prop.load(input);
			
			propThread.set(prop);
			
		}catch(IOException e) {
			throw new RuntimeException("Failed to load config: "+filePath,e);
			
		}
			
	}
		
		public static String get(String key) {
           
			return propThread.get().getProperty(key);
			
		}
		public static void unload() {
	        propThread.remove();
	    }
}