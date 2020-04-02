package com.nopcommerce.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilies.ReadConfig;

public class BaseClass {

	 // Call Readconfig utilities class then use variable here
	// Why We create Readconfig and configuration properties because it is reusablity
	//We have to change only in configuration property (Contain Variable and his values)
	//ReadConfig.java class is call configuration properties.
	//Then we call HERE in Base call
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseUrl=readconfig.getURL();
	public String username=readconfig.getusrname();
	public String Password=readconfig.getpwd();
	public static WebDriver driver;
	
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger=Logger.getLogger("nopcommerce");
		PropertyConfigurator.configure("log4j.properties");
		
		
		if (br.equals("chrome")) {
			// Chrome Browser
			System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
			driver= new ChromeDriver();
			
		}
		else if  (br.equals("Firefox")) {
			//Open firefox
			System.setProperty("webdriver.ie.driver",readconfig.getgecko());
			driver= new FirefoxDriver();
		}
		
		else if  (br.equals("ie")) {
			//Open Internet Explore
			System.setProperty("webdriver.ie.driver",readconfig.getiepath());
			driver= new InternetExplorerDriver();
			
		}
		
	}
	 
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	public static String randomstring1() {
		String generateString1= RandomStringUtils.randomAlphabetic(5);
		return(generateString1);
	}
	public static String randomstring() {
		String generateString1= RandomStringUtils.randomNumeric(4); //if we have to use numeric we use it.
		return(generateString1);
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}        
	    
	//  This Method is work only one Test case
	
		/*public void capturescrennshot(ITestResult result) throws IOException 
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			
    TakesScreenshot ts =(TakesScreenshot)driver;
	
    File src=ts.getScreenshotAs(OutputType.FILE);
    
    File trg =new File(System.getProperty("user.dir") + "/screenshot/" + result.getName() + ".png");
   
    FileUtils.copyFile(src, trg);
    
    driver.close();
	
    }

	}*/
	
}
