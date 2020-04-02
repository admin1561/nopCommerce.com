package com.nopcommerce.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	public WebDriver ldriver;
	
  public loginPage(WebDriver rdriver) // Take as Constructor
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtuser;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpass;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input")
	@CacheLookup
	WebElement btnlogin;
	
	
	@FindBy(xpath="/html/body/div[3]/div[1]/div/div/ul/li[3]/a")
	@CacheLookup
	WebElement btnlogout;
	
	//Action part
	public void susername(String uname)
	{
		txtuser.sendKeys(uname);
	}
	
	public void setpwd(String pname)
	{
		txtpass.sendKeys(pname);
	}
	public void gologin()
	{
		btnlogin.click();
	}
	public void gologout()
	{
		btnlogout.click();
	}
	
	
	
	
	
	
	
}
