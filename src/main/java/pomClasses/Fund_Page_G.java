package pomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.UtilClass1;


public class Fund_Page_G extends UtilClass1{
WebDriver driver ;
//1
	@FindBy(xpath="(//div[text()='All transactions'])")
	private WebElement AllTransaction;
	
	
//2	
	@FindBy(xpath="//div[text()='Balance available']")
	private WebElement fundAvailableText;

	@FindBy(xpath="(//input[@id='wrs445Amount'])")
	private WebElement amountInputField;
//3
	@FindBy(xpath="(//input[@id='vpa_input'])")
	private WebElement EnterUPI;
//4	
	@FindBy(xpath="(//span[text()='DEPOSIT MONEY'])")
	private WebElement DepositMoneyButton;
//5	
	@FindBy(xpath="//(//div[@id='amupNew89TransformDiv']/div)")
	private WebElement amountConfirmText;
//6
	@FindBy(xpath="(//div[text()='CANCEL PAYMENT'])")
	private WebElement CANCELPAYMENTD;
//7	
	@FindBy(xpath="(//span[@class='absolute-center'])[3]")
	private WebElement OKYAbutton;
	

	
	public Fund_Page_G (WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public boolean is_verifyAllTransactionVIsiable1()
	{
	try {
	expliciteWait(driver,AllTransaction); 
	return true ;
	}
	catch(Exception e ) {
		e.printStackTrace();
		return false;
        }
	}

	public boolean verifyFundPageLoaded2() throws InterruptedException, IOException
	{
		amountInputField.clear();
		
		String amountToEnter = "500";
		
		amountInputField.sendKeys(amountToEnter);
		
		is_VerifyEnterUPI3();
		
		DepositMoneyButton.click();
		
		WebElement element = expliciteWait(driver, amountConfirmText);
		
		double getEnteredAmout = Double.parseDouble(element.getText().split("₹")[1]);
		
		int k = (int) getEnteredAmout;
		
		System.out.println(k);
		
		if(amountToEnter.equals(String.valueOf(k)))
		{
			return true;
		}
		
		return false;
	}
	
	
	public void is_VerifyEnterUPI3() throws InterruptedException, IOException
	{
		expliciteWait(driver,EnterUPI);
		EnterUPI.sendKeys(getDataFromPropertyFile("UPI"));
		
	}
	
	public void is_ClickCDepositButton4() throws InterruptedException, IOException
	{
		expliciteWait(driver,DepositMoneyButton).click();
	}
	

	public void is_ClickCANCELPAYMENTD5() throws InterruptedException, IOException
	{
		
		expliciteWait(driver,CANCELPAYMENTD).click();
	}
	
	
	
	public void is_ClickOKYAbutton6() throws InterruptedException, IOException
	{
		expliciteWait(driver,OKYAbutton);
		OKYAbutton.click();
	}
	
	

}


////1
//	@FindBy(xpath="//div[text()='Balance available']")
//	private WebElement fundAvailableText;
////2	
//	@FindBy(xpath="(//input[@id='wrs445Amount'])")
//	private WebElement AmountInputField;
////3
//	@FindBy(xpath="(//input[@id='vpa_input'])")
//	private WebElement EnterUPI;
////4	
//	@FindBy(xpath="(//span[text()='DEPOSIT MONEY'])")
//	private WebElement DepositMoneyButton;
////5	
//	@FindBy(xpath="//(//div[@id='amupNew89TransformDiv']/div)")
//	private WebElement DepositAmountConfirmText;
////6
//	@FindBy(xpath="(//div[text()='CANCEL PAYMENT'])")
//	private WebElement CANCELPAYMENTD;
////7	
//	@FindBy(xpath="(//span[@class='absolute-center'])[3]")
//	private WebElement OKYAbutton;
//	
//
//	
//	public Fund_Page_G (WebDriver driver)
//	{
//		PageFactory.initElements(driver, this);
//		this.driver=driver;
//	}
//	
//	public boolean is_verifyFundPageLoaded1()
//	{
//		WebElement element = expliciteWait(driver, fundAvailableText);
//		
//		String text = element.getText().trim();
//		
//		String dataFromExcel ="0.00";   //"Balance available";
//		
//		if(text.equals(dataFromExcel))
//		{
//			return true;
//		}
//		
//		return false;
//	}
//
//	public void is_EnterDepositAmount2() throws InterruptedException
//	{
//		AmountInputField.clear();
//		String amountToEnter = "500";
//		
//		AmountInputField.sendKeys(amountToEnter);
////		
////		depositButton.click();
////		
////		WebElement element = expliciteWait(driver, amountConfirmText);
////		
////		double getEnteredAmout = Double.parseDouble(element.getText().split("₹")[1]);
////		
////		int k = (int) getEnteredAmout;
////		
////		System.out.println(k);
////		
////		if(amountToEnter.equals(String.valueOf(k)))
////		{
////			return true;
////		}
////		
////		return false;
//	}
//	
//	
//	public void is_EnterUPI3() throws InterruptedException, IOException
//	{
//		expliciteWait(driver,EnterUPI);
//		EnterUPI.sendKeys(getDataFromPropertyFile("UPI"));
//	}
//	
//	public void is_ClickCDepositButton4() throws InterruptedException, IOException
//	{
//		expliciteWait(driver,DepositMoneyButton).click();
//	}
//	
//	
//	public boolean is_verifyDepositAmountLoade5()
//	{
//		
//		WebElement element = expliciteWait(driver, DepositAmountConfirmText);
//		
//		double getEnteredAmout = Double.parseDouble(element.getText().split("₹")[1]);
//		
//		int k = (int) getEnteredAmout;
//		
//		System.out.println(k);
//		
//		if(DepositAmountConfirmText.equals(String.valueOf(k)))
//		{
//			return true;
//		}
//		
//		return false;
//	}
//	
//	public void is_ClickCANCELPAYMENTD6() throws InterruptedException, IOException
//	{
//		
//		expliciteWait(driver,CANCELPAYMENTD).click();
//	}
//	
//	
//	
//	public void is_ClickOKYAbutton7() throws InterruptedException, IOException
//	{
//		expliciteWait(driver,OKYAbutton);
//		OKYAbutton.click();
//	}
	
	
	
	
	
	
	
	
	
	
	



//@FindBy(xpath="//div[text()='Balance available']")
//private WebElement fundAvailableText;
//
//@FindBy(xpath="//input[@id='wrs445Amount']")
//private WebElement amountInputField;
//
//@FindBy(xpath="//div[@id='amupNew89TransformDiv']/div")
//private WebElement amountConfirmText;
//
//@FindBy(xpath="//span[text()='DEPOSIT MONEY']")
//private WebElement depositButton;
//
//
//
//
//
//
//public Fund_Page(WebDriver driver)
//{
//	PageFactory.initElements(driver, this);
//	this.driver=driver;
//}
//
//
//public boolean verifyFundPageLoaded()
//{
//	WebElement element = expliciteWait(driver, fundAvailableText);
//	
//	String text = element.getText().trim();
//	
//	String dataFromExcel = "Balance available";
//	
//	if(text.equals(dataFromExcel))
//	{
//		return true;
//	}
//	
//	return false;
//}
//
//public boolean enterDepositAmount()
//{
//	amountInputField.clear();
//	String amountToEnter = "500";
//	
//	amountInputField.sendKeys(amountToEnter);
//	
//	depositButton.click();
//	
//	WebElement element = expliciteWait(driver, amountConfirmText);
//	
//	double getEnteredAmout = Double.parseDouble(element.getText().split("₹")[1]);
//	
//	int k = (int) getEnteredAmout;
//	
//	System.out.println(k);
//	
//	if(amountToEnter.equals(String.valueOf(k)))
//	{
//		return true;
//	}
//	
//	return false;
//}
//
