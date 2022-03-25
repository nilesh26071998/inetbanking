package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listener extends BaseClass1 implements ITestListener {
	ExtentTest	test;
	ExtentReports extent=com.inetbanking.utilities.ExtendReport.config();
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	public ExtentTest logger;

	public void onTestStart(ITestResult result) {
	test=extent.createTest(result.getMethod().getMethodName());
	extenttest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS,"Test Passed");
		
		
	}

	
//	public void onTestFailure(ITestResult result) {
//		extenttest.get().fail(result.getThrowable());
//		String Testmethodname=result.getMethod().getMethodName();
//		WebDriver driver =null;
//		try {
//
//			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//
//			} catch (Exception e) {
//
//			}
//		try {
//			extenttest.get().addScreenCaptureFromPath(getScreenshotpath(Testmethodname,driver),result.getMethod().getMethodName());
//			getScreenshotpath(Testmethodname,driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//	}
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
		}
		
	}
		


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	
	}
