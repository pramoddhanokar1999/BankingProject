package pomClasses;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.UtilClass1;

public class LoginPage_G extends UtilClass1 {
	WebDriver driver ;
	@FindBy(xpath=("(//span[text()='Login/Register'])"))
	private WebElement ClickLoginRegister ;
	
	@FindBy(xpath=("(//input[@id='login_email1'])"))
	private WebElement Enter_emailID ;
	
	@FindBy(xpath=("//span[text()='Continue']"))
	private WebElement ContinueButton ;
	
	@FindBy(xpath=("(//input[@id='login_password1'])"))
	private WebElement Enter_password ;
	
	@FindBy(xpath=("(//span[text()='Submit'])"))
	private WebElement ClickSubmitButton;
	
	@FindBy(xpath=("(//input[@type='number'])[1]"))
	private WebElement pinField ;
	
	public LoginPage_G (WebDriver driver ) {
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	
	
	public void is_ClickLoginRegister1() {
		ClickLoginRegister.click();
	}
	
	public void is_2_Enter_emailID() throws IOException
    {
		expliciteWait(driver,Enter_emailID);
		Enter_emailID.sendKeys(getDataFromPropertyFile("email"));   // Data  from Excel file
	}
	
	public void is_3_ClickContinueButton() {
		expliciteWait(driver, ContinueButton);
		ContinueButton.click();

	}
	
	public void is_4_Enter_password()  throws IOException
   {
		expliciteWait(driver, Enter_password);
		Enter_password.sendKeys(getDataFromPropertyFile("password"));  // Data  from Excel file
	}
	
	public void is_5_ClickSubmitButton() {
		expliciteWait(driver, ClickSubmitButton);
		ClickSubmitButton.click();

	}	
	
	public void is_enterPin_6() throws IOException, InterruptedException
	{
	
		String pin =getDataFromPropertyFile("pin");
		
		char[] digit = pin.toCharArray();
		System.out.println(Arrays.toString(digit));  //Return is char[]
		Thread.sleep(3000);
		
		expliciteWait(driver, pinField);
         List<WebElement> elements = driver.findElements(By.xpath("//input[@type='number']"));
		
		for(int i=0; i<digit.length; i++)
		{
			elements.get(i).sendKeys(String.valueOf(digit[i]));     // Data  from Excel file
		}

	}
	

	

	
	
}
