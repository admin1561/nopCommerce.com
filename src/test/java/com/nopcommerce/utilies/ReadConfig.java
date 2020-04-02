package com.nopcommerce.utilies;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	{
	File src = new File("./Configuration/config.Properties");  //This File path is take which we have create Configuration file.How to create path,just right click which we created file
	// Then go to properties copy the path and paste here. above path is same "." This is mean it all directory cover. it is short path create.
	
	try {
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
	}catch(Exception e) {
		System.out.println("Exception is :" +e.getMessage());
	}
	
	}
	
	public String getURL()
	{
		String url =pro.getProperty("baseUrl");
		return url;
	}
	public String getusrname()
	{
		String user =pro.getProperty("username");
		return user;
	}
	public String getpwd()
	{
		String passw =pro.getProperty("Password");
		return passw;
	}
	public String getchromepath()
	{
		String cpath =pro.getProperty("Chromepath");
		return cpath;
	}
	public String getiepath()
	{
		String internetexplor =pro.getProperty("iepath");
		return internetexplor;
	}
	public String getgecko()
	{
		String Firefox =pro.getProperty("geckopath");
		return Firefox;
	}
	
	
	
	
}
