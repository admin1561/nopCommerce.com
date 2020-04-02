package com.nopcommerce.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageobject.AddCustomerPage;
import com.nopcommerce.pageobject.loginPage;

public class TC_AddCustomer_003 extends BaseClass {
    @Test
	public void addnewcustomer() throws InterruptedException {
		
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
		logger.info("Url Is opem....");
		
		loginPage lp = new loginPage(driver);
		lp.susername(username);
		logger.info("USername provied......"); // logger msg in console 
		//Logger is Use Create Automatic folder and show Report Also. you can see Folder Right side in Same Project. it is main intend to use log is capture our all activity in log file.
		
		lp.setpwd(Password);
		logger.info("Password provied......");// logger msg
		
		lp.gologin();
		logger.info("login button pass......");// logger msg
	
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.ClickonCustomers();
		logger.info("ClickonCustomers pass......");
		addcust.ClickonCustomersmenuitem();
		logger.info("ClickonCustomersmenuitem pass......");
		addcust.ClickOnAddnew();
		logger.info("ClickOnAddnew pass......");
		
		// When we have to use unique Email then we have to use this kind method which is take random charter and also use number too. we write Method end up code see Down the way below.
		String email =randomstring1()+"@gmail.com";
		addcust.SetEmail(email);
		logger.info("Email pass......");
		logger.info("Start All  fil information......");
		
		addcust.Setpassword("test1235");
		addcust.Setfirstname("Gary");
		addcust.Setlastname("siva");
		addcust.SetGender("Female");
		addcust.SetDOb("03/05/2020");
		addcust.Setcompnay("Mark&mark");
		addcust.ClickTax();
		Thread.sleep(3000);
		addcust.Newsletter("Your store name" );
		Thread.sleep(3000);
		addcust.SetCustomerRoles("Guests");
		Thread.sleep(3000);
		addcust.Setvendor("Vendor 2");
		Thread.sleep(3000);
		addcust.SetAdmontext("This is my first test");
		logger.info("All inforamtion is done ......");
		
		
		addcust.ClickSave();
		logger.info("validation started....");
		
		//String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		
		String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			//captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		
    	}
    }
	
	
	
}
