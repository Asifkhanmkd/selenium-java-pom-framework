package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties initProp() {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("./src/main/resources/config.properties");
			prop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return prop;
	}
}