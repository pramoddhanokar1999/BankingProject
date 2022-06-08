
package pomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.UtilClass1;


public class Home_Page_G extends UtilClass1{
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='valign-wrapper']")
	private WebElement profileIcon;
	
	@FindBy(xpath="(//p[@class='truncate headerDggnd'])")
	private WebElement profileEmail;
	
	@FindBy(xpath="(//a[text()='Investments'])")
	private WebElement ClickInvestments;
	
	
	@FindBy(xpath="(//div[@class='valign-wrapper balance-wrap'])")
	private WebElement ClickCart;
	
	@FindBy(xpath="(//div[text()='All transactions'])")
	private WebElement AllTransactionsvisible;
	
	@FindBy(xpath="(//input[@id='wrs445Amount'])")
	private WebElement EnterAmount;
	
	
	@FindBy(xpath="(//input[@id='vpa_input'])")
	private WebElement EnterUPI;
	
	@FindBy(xpath="(//span[text()='DEPOSIT MONEY'])")
	private WebElement DepositMoneyButton;
	
	@FindBy(xpath="(//div[text()='CANCEL PAYMENT'])")
	private WebElement CANCELPAYMENTD;
	
	@FindBy(xpath="(//span[@class='absolute-center'])[3]")
	private WebElement OKYAbutton;
	
	
	
	
	
	public Home_Page_G(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	

	
	public void is_1_clickOnProfile()
	{
		expliciteWait(driver, profileIcon);
		profileIcon.click();
	}
	
	public boolean is_2_verifyUserProfile() throws IOException
	{
		expliciteWait(driver, profileEmail);
		String emailFromUI = profileEmail.getText();
		
		String emailFromConfig = getDataFromPropertyFile("email");
		
		if(emailFromUI.equals(emailFromConfig))
		{
			return true;
		}
		
		return false;
	}
	public void is_3ClickInvestments() throws InterruptedException
	{
		expliciteWait(driver, ClickInvestments);
		ClickInvestments.click();
	}


	public void is_4_ClickCart() throws InterruptedException
	{
		expliciteWait(driver, ClickCart);
		ClickCart.click();
		
		
	}
	
	public boolean isVisiable_5_AllTransactionsvisible()
	{	try {
		WebElement element = expliciteWait(driver,AllTransactionsvisible);
		return true ;
	     }
	   catch (Exception e ) {
		e.printStackTrace();    //or System.out.println(e);
		return false;
	   }
	}
	
	public void is_6_EnterAmount() throws InterruptedException
	{
		expliciteWait(driver, EnterAmount);
		EnterAmount.sendKeys("100");
	}
	
	public void is_7_EnterUPI() throws InterruptedException, IOException
	{
		expliciteWait(driver,EnterUPI);
		EnterUPI.sendKeys(getDataFromPropertyFile("UPI"));
	}
	
	public void is_ClickCDepositMoneyButton_8() throws InterruptedException, IOException
	{
		expliciteWait(driver,DepositMoneyButton).click();
	}
	
	public void is_ClickCANCELPAYMENTD_9() throws InterruptedException, IOException
	{
		expliciteWait(driver,CANCELPAYMENTD).click();
	}
	
	public void is_ClickOKYAbutton_10() throws InterruptedException, IOException
	{
		expliciteWait(driver,OKYAbutton);
		OKYAbutton.click();
	}
}

