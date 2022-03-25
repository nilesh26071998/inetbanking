package com.inetbanking.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;


public class TC_LoginTest_0001 extends BaseClass1 {

	
	@Test
	public void login() throws IOException
	{
	
		logger.info("URL is Open");
		
		LoginPage l1=new LoginPage(driver);
		l1.setusername(username);
		
		logger.info("username is Enter");
		l1.setpassword(Password);
		
		logger.info("Password is Enter");
		l1.login();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			getScreenshotpath("login",driver);
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
	
	
}
