package com.nlt.util;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportBase {

	public static ExtentReports extent=null;
	public static ExtentSparkReporter spark=null;
	public	static ExtentTest test=null;

	@BeforeSuite
	public void setUp() {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter("EdxTestReport.html");
		extent.attachReporter(spark);
		 
		spark.config().setDocumentTitle("Automation Testing Demo Report");
		spark.config().setReportName("Website Pilot Report");
		spark.config().setTheme(Theme.DARK);

	}

	@AfterMethod
	public void getResult(ITestResult result){
		
		test.log(Status.INFO,"Starting TestCase");
		
		if(result.getStatus() == ITestResult.FAILURE){
			
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS){
			
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
		else{
			
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
		test.log(Status.INFO,"TestCase Completed");
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}


}
