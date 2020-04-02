
package com.nopcommerce.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver ldriver;
	
	  public AddCustomerPage(WebDriver rdriver) // Take as Constructor
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
	  //Find Element 
	  //Use Can USe this FindElement also below
	  
	  By linkCustomer=By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/a/span");
	  By SublinkCustomer=By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a/span");
	  
	  By SublinkAddnew= By.xpath("//i[@class='fa fa-plus-square']");
	   
	   By textEmail=By.xpath("//input[@id='Email']");
	   By textpwd=By.xpath("//input[@id='Password']");
	   
	   By texfname=By.id("FirstName");
	   By texlname=By.id("LastName");
	   
	   By rdiMale=By.xpath("//input[@id='Gender_Male']");
	   By rdiFmale=By.xpath("//input[@id='Gender_Female']");
	  
	   By texDOB=By.xpath("//*[@id=\"DateOfBirth\"]");
	   
	   By texCompany=By.id("Company");
	   
	   By chekTaxExe=By.id("IsTaxExempt");
	   
	   By chekStorename=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[1]/div[9]/div[2]/div[1]/label/input");
	   By chekTestStore2=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[1]/div[9]/div[2]/div[2]/label/input");
	   
	   By clickCutmRols=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	   By listitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	   By listitemForummodera=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]");
	   By listitemguest=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
	   By listitemRegister=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]");
	   By listitemvendors=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");
	   
	   By dropvendor=By.xpath("//*[@id=\"VendorId\"]");
	   
	   By textAdmin=By.xpath("//*[@id=\"AdminComment\"]");
	   
	   By clickSave=By.xpath("/html/body/div[3]/div[3]/div/form/div[1]/div/button[1]/i");
	   
	   //Action 
	   
	   public void ClickonCustomers() {
		   ldriver.findElement(linkCustomer).click();
	   }
	   
	   public void ClickonCustomersmenuitem() {
		   ldriver.findElement(SublinkCustomer).click();
	   }
	   public void ClickOnAddnew() {
		   ldriver.findElement(SublinkAddnew).click();
	   }
	   public void SetEmail(String email) {
		   ldriver.findElement(textEmail).sendKeys(email);
	   }
	   public void Setpassword(String pwd) {
		   ldriver.findElement(textpwd).sendKeys(pwd);
	   }
	   public void Setfirstname	(String fname) {
		   ldriver.findElement(texfname).sendKeys(fname);
	   }
	   public void Setlastname	(String lname) {
		   ldriver.findElement(texlname).sendKeys(lname);
	   }
	   public void SetGender(String gender) {
		   if(gender.equals("Male")) {
			   ldriver.findElement(rdiMale).click();
			 }
		   else if(gender.equals("Female")) {
			   ldriver.findElement(rdiFmale).click();
		   }
		   else {
			   ldriver.findElement(rdiMale).click();//Default
		   }
		   
	}
	   public void SetDOb	(String DOB) {
		   ldriver.findElement(texDOB).sendKeys(DOB);
		   
	   }
	   public void Setcompnay	(String Cname) {
		   ldriver.findElement(texCompany).sendKeys(Cname);
	   }
	   public void ClickTax	( ) {
		   ldriver.findElement(chekTaxExe).click();
	   }
	   public void Newsletter(String Cstore) {
		   if(Cstore.equals("Your store name")) 
		   {
		   ldriver.findElement(chekStorename).click();
	   
		   }else if(Cstore.equals("Test Store 2")) 
		   {
		   ldriver.findElement(chekTestStore2).click();
	        }
	        else {
		   ldriver.findElement(chekTestStore2).click();//Default
	   }
	   }
	   
	   public void SetCustomerRoles	(String role) {
		   ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
		   ldriver.findElement(clickCutmRols).click();
		   
		   WebElement listitem;
		   
		   switch(role)
		   {
		   case "Administrators":
		        listitem=ldriver.findElement(listitemAdministrators);break;
		   case "ForModeutors":
		        listitem=ldriver.findElement(listitemForummodera);break;
		   case "Guests":
		        listitem=ldriver.findElement(listitemguest);break;
		   case "Register":
		        listitem=ldriver.findElement(listitemRegister);break;
		   case "Vendors":
		        listitem=ldriver.findElement(listitemvendors);break;
		   default:
		        listitem=ldriver.findElement(listitemForummodera);    
		   }
		   
		    //listitem.click();
		   //If Click Action not work So we have Use below mwthod
		   
		   JavascriptExecutor js =(JavascriptExecutor)ldriver;
		   js.executeScript("arguments[0].click();",listitem);
	   }
		   public void Setvendor(String vlaue) 
		   {
			   Select drp= new Select(ldriver.findElement(dropvendor));
			   drp.selectByVisibleText(vlaue);
		   }
		   
		   public void SetAdmontext(String note) {
			   ldriver.findElement(textAdmin).sendKeys(note);
		   }
		   public void ClickSave() {
				   ldriver.findElement(clickSave).click();
				   
		   }
			   
		   
		
		   
		   
		   
		   
		   
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   

