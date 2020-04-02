package com.nopcommerce.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.pageobject.loginPage;

import junit.framework.Assert;

public class TC_Logintest_001 extends BaseClass{

	
	@Test
	public void Logintest() throws InterruptedException
	{
		driver.get(baseUrl);
		logger.info("Url Is opem....");
		
		loginPage lp = new loginPage(driver);
		lp.susername(username);
		logger.info("USername provied......"); // logger msg in console 
		//Logger is Use Create Automatic folder and show Report Also. you can see Folder Right side in Same Project. it is main intend to use log is capture our all activity in log file.
		
		lp.setpwd(Password);
		logger.info("Password provied......");// logger msg
		
		lp.gologin();
		logger.info("login button pass......");// logger msg
	
		Thread.sleep(5000);
	       
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.gologout();
			logger.info("logout done ......");
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	
	
}
