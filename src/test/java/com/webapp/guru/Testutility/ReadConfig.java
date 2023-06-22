package com.webapp.guru.Testutility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pobj;
	public ReadConfig() {
		File src = new File("./Configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pobj = new Properties();
			pobj.load(fis);
		}
		catch (Exception e) {
			System.out.println("Exception is eeeeeoooo");
		
		}
	}
	public String getApplicationURL() {
		String url = pobj.getProperty("baseURL");
		return url;
	}
	public String getusername() {
		String username = pobj.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password = pobj.getProperty("password");
		return password;
	}
	
	public String getChromepath() {
		String chromepath = pobj.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFireFoxpath() {
		String firefoxpath = pobj.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getEdgepath() {
		String msedgepath = pobj.getProperty("msedgepath");
		return msedgepath;
	}
}
