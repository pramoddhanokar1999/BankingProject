package Test_Clasess;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClasses.BaseClass1;
import pomClasses.Fund_Page_G;
import pomClasses.Home_Page_G;
import pomClasses.LoginPage_G;

public class VerifyUserCanWithdrawAmount {
	
	WebDriver driver;
	LoginPage_G lp;
	Home_Page_G hp;
	Fund_Page_G fp;
	
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String bName) throws InterruptedException
	{
		 driver=BaseClass1.getChromeDriver();
			htmlReporter = BaseClass1.getHtmlReporter();
			report = BaseClass1.getExtentReport();
			test = BaseClass1.getTestForReporter("VerifyUserCanAddFundToAccount");
			
	}
	
	@BeforeMethod()
	public void beforeMethod()
	{
		lp = new LoginPage_G(driver);
		hp = new Home_Page_G(driver);
		fp = new Fund_Page_G(driver);
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test is passed " + result.getName());
		}
		else
		{
			String path = hp.getScreenShot(driver, result.getName());
			test.log(Status.FAIL, "Test is failed " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}
	
	
	@AfterClass
	public void afterClass()
	{
		report.flush();
	}

}
