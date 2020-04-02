package com.nopcommerce.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageobject.loginPage;
import com.nopcommerce.utilies.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass{
    
	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd) throws InterruptedException	
	{
		driver.get(baseUrl);
		driver.manage().window().maximize();
		logger.info("Url Is opem....");
		
		loginPage lp = new loginPage(driver);
		
		lp.susername(user);
		logger.info("USername provied......"); // logger msg in console 
		//Logger is Use Create Automatic folder and show Report Also. you can see Folder Right side in Same Project. it is main intend to use log is capture our all activity in log file.
		
		lp.setpwd(pwd);
		logger.info("Password provied......");// logger msg
		
		lp.gologin();
		logger.info("login button pass......");// logger msg
	
		Thread.sleep(2000);
	       
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.gologout();
			logger.info("logout done ......");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login is Failed....");
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][]getData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/src/test/java/TestDataExcelFile/TC002DDT TestData.xlsx";
		int rowcount=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new  String[rowcount][colcount];
		for(int i = 1; i <= rowcount; i++)
		{
			for(int j = 0; j < colcount; j++ )
			{
				logindata[i - 1 ][j]= XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return logindata;
	}
	 
	
	
}
