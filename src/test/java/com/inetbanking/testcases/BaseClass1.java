package com.inetbanking.testcases;

import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.inetbanking.utilities.ReadConfig;

public class BaseClass1 {
	ReadConfig readconfig=new ReadConfig();
	public String username=readconfig.getUsername();
	public String Password=readconfig.getPassword();
	public String URL=readconfig.getApplicationURL();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public WebDriver Setup(String br)
	
	{
	logger = Logger.getLogger("ebanking");
    PropertyConfigurator.configure("Log4j.properties");
	
	if(br.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
	driver =new ChromeDriver();
	}
	
	else if(br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		driver =new FirefoxDriver();
	}
	else if(br.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
		driver =new InternetExplorerDriver ();
	}
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(URL);
	return driver;
	
	}

//	@AfterClass
//	public void tearDown()
//	{
//		driver.quit();
//	}
////	
//	public String getScreenshotpath(String testcasename,WebDriver driver) throws IOException
//	{
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File source=ts.getScreenshotAs(OutputType.FILE);
//		String dest=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
//		FileUtils.copyFile(source,new File(dest));
//		return dest;
//	}
	public void getScreenshotpath(String tname,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String  target = System.getProperty("user.dir") + "/Screenshots/" + tname + ".png";
		FileUtils.copyFile(source,new File(target));
		System.out.println("Screenshot taken");
	}
//	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
}
