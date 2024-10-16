package amazon;


	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Browser;
import popUpMessages.RecommendedAcce;
	
	public class ValidateAddtoCart extends Browser {

	
		private WebDriver driver;
		private HomePage homepae;
		private SignIn signin;
		private ProductDetails productdetails;
		private CartDetailsPage cartDetailsPage;
		private RecommendedAcce recommendedAcce;
		private List<String> add;
		
		@Parameters("browser")
		@BeforeTest
		void launchbrowser(String expectedBrowser)
		{
			driver = launchBrowser(expectedBrowser);
		}
		
		
		@BeforeClass
		void initializePOM()
		{
			homepae = new HomePage(driver);
			signin = new SignIn (driver);
			productdetails = new ProductDetails(driver);
			recommendedAcce = new RecommendedAcce(driver);
			cartDetailsPage = new CartDetailsPage (driver);
		}
		
		@BeforeMethod
		void loginAmazon()
		{
			driver.get("https://www.amazon.in");
			//homepae.clickaccountList();
			//homepae.clickOnsigIn();
			//signin.enteremailOrPhone("8149629885");
			//signin.clickOnContinue();
			//signin.enterpassword("Smile@123");
			//signin.clicksignIn();
		}
	

		@Test
		void verifyAddtoCart()
		{
			homepae.enterProductname("Apple Mobile");
			homepae.clicksearchButton();
			homepae.clicksearchsuggetion();
			
			 add = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(add.get(1));
			
			String expectedProductname =  productdetails.getProductname();
			String expectedProductprice =  productdetails.getproductPrice();
			productdetails.clickaddtoCart();
			
			recommendedAcce.clickCart();
			
			String actualProductname = cartDetailsPage.getproductName();
			String actualProductprice = cartDetailsPage.getproductPrice();
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualProductname, expectedProductname);
			softAssert.assertEquals(expectedProductprice, actualProductprice);
			softAssert.assertAll();
			
		}
		
		@AfterMethod
		void logoutAmazon()
		{
			driver.close();
			driver.switchTo().window(add.get(0));
			homepae.clicklogOutButton();
			
		}
		
		@AfterClass
		void removePOM()
		{
			homepae = null;
			signin = null;
			productdetails = null;
			recommendedAcce = null;
			cartDetailsPage= null;
			System.gc();
		}
		
		@AfterTest
		void closeBrowser()
		{
			driver.quit();
		}
			
			
		

}
