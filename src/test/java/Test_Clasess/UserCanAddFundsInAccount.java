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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClasses.BaseClass1;

import UtilClasses.UtilClass1;
import pomClasses.Fund_Page_G;
import pomClasses.Home_Page_G;
import pomClasses.LoginPage_G;

public class UserCanAddFundsInAccount extends UtilClass1 {
	
	WebDriver driver ;

	LoginPage_G lp;
	Home_Page_G hp;
	Fund_Page_G fp;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	  @BeforeClass
	  public void beforeClass() throws InterruptedException {
		    driver=BaseClass1.getChromeDriver();
			htmlReporter = BaseClass1.getHtmlReporter();
			report = BaseClass1.getExtentReport();
			test = BaseClass1.getTestForReporter("VerifyUserCanAddFundToAccount");
			
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  lp = new LoginPage_G(driver);
		  hp= new Home_Page_G(driver);
		  fp = new Fund_Page_G(driver);
 	  }
     SoftAssert soft = new SoftAssert();
 
  @Test(priority=1)
  public void VeriyUserCanLogin() throws InterruptedException, IOException { 
	  lp.is_ClickLoginRegister1();
	  lp.is_2_Enter_emailID();
	  lp.is_3_ClickContinueButton();
	  lp.is_4_Enter_password();
	  lp.is_5_ClickSubmitButton();
	  lp.is_enterPin_6();
	  Thread.sleep(10000);
	 
  }
  @Test(priority = 2)
  public void VeriyUserCanHomePage() throws IOException, InterruptedException {
	  hp.is_1_clickOnProfile();
	  hp.is_2_verifyUserProfile();
	  hp.is_3ClickInvestments();
	  hp.is_4_ClickCart();

	 
  }
  @Test(priority=3)
  public void VeriyUserCanVeriyUserCanFundPage() throws InterruptedException, IOException {
	  
	 Assert.assertTrue(fp.is_verifyAllTransactionVIsiable1());
	  
	 fp.verifyFundPageLoaded2();  //3 ,4 
	 fp.is_ClickCANCELPAYMENTD5();
	 fp.is_ClickOKYAbutton6();

  }
  
  @AfterMethod
  public void afterMethod(ITestResult result) throws IOException {
	  
	  if(result.getStatus() == ITestResult.SUCCESS){
			test.log(Status.PASS, "Test is passed " + result.getName());
		}
		else
		{
			String path = hp.getScreenShot(driver, result.getName());
			test.log(Status.FAIL, "Test is failed " + result.getName(), 
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  report.flush();
	// driver.quit();  
     } 
}
