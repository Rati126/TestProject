package amazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifySignIn {
	
	private WebDriver driver;
	private HomePage homepae;
	private SignIn signin;
	

	@BeforeClass
	void launchBrowser ()
	{
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@BeforeMethod
	void homePage()
	{
		driver.get("https://www.amazon.in");
	}
	
	@Test
	void verifysignIn()
	{
		homepae = new HomePage(driver);
		homepae.clickaccountList();
		homepae.clickOnsigIn();
		signin = new SignIn (driver);
		signin.enteremailOrPhone("8149629885");
		signin.clickOnContinue();
		signin.enterpassword("Smile@123");
		signin.clicksignIn();
	}
	
	@AfterMethod
	void logoutAmazon()
	{
		homepae = new HomePage(driver);
		homepae.clickaccountList();
		homepae.clicklogOutButton();
	}
	
	@AfterClass
	void closeBrowser()
	{
		driver.quit();
	}

}
