package com.inetbanking.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReport {
	 static ExtentReports extent;
	public static  ExtentReports config()
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		 String path=System.getProperty("user.dir")+"/reports/"+repName;
	     ExtentSparkReporter Reporter=new ExtentSparkReporter(path);
	     Reporter.config().setReportName("Web automation result");
	     Reporter.config().setDocumentTitle("Test result");
	      
	     
	     extent=new ExtentReports();
	     extent.attachReporter(Reporter);
	     extent.setSystemInfo("tester","nileshbuchade");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Nilesh");
	     return extent; 
	     
	}
}
