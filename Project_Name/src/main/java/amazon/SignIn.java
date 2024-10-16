package amazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
	
	
	@FindBy (xpath = "//input[@id='ap_email']")
	private WebElement emailOrPhone;
	
	@FindBy (xpath = "//input[@id='continue']")
	private  WebElement continueButton;
	
	@FindBy (xpath = "//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy (xpath = "//input[@id='signInSubmit']")
	private WebElement signIn;
	
	public SignIn (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enteremailOrPhone(String userId)
	{
		emailOrPhone.sendKeys(userId);
	}
	
	public void clickOnContinue()
	{
		continueButton.click();
	}
	
	public void enterpassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clicksignIn()
	{
		signIn.click();
	}
	
	
	
	
	
	
}
