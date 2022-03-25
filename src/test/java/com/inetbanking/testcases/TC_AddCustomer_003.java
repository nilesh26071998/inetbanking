package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomer;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass1 {
	@Test
	public void Addcustomer() throws IOException, InterruptedException
	{
   
	LoginPage lp=new LoginPage(driver);
	lp.setusername(username);
	logger.info("User name is provided");
	lp.setpassword(Password);
	logger.info("Passsword is provided");
	lp.login();
	
	Thread.sleep(3000);
	
	AddCustomer addcust=new AddCustomer(driver);
	
	addcust.getlink();
	
	logger.info("providing customer details....");
	
	
	addcust.getname("Nilesh");
	addcust.getgender("male");
	addcust.custdob("26","07","1998");
	Thread.sleep(5000);
	addcust.custaddress("INDIA");
	addcust.custcity("HYD");
	addcust.custstate("AP");
	addcust.custpinno("5000074");
	addcust.custtelephoneno("987890091");
	
	String email=randomestring()+"@gmail.com";
	addcust.custemailid(email);
	addcust.custpassword("123456789");
	addcust.custsubmit();
	//addcust.custpassword("123456789");
	
	Thread.sleep(3000);
	
	logger.info("validation started....");
	
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	
	if(res==true)
	{
		Assert.assertTrue(true);
		logger.info("test case passed....");
		
	}
	else
	{
	logger.info("test case failed....");
		getScreenshotpath("addNewCustomer",driver);
		Assert.assertTrue(false);
	}
		
}

	
	}

