package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckAsser {
	
	@FindBy (xpath = "//span[text()='Apple iPhone 16 (128 GB) - Pink']")
	private WebElement mobile;
	
	@FindBy (xpath = "//span[text()='79,900']")
	private WebElement price;
	
	public CheckAsser (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void iphone()
	{
		String actualResult = mobile.getText();
		if (actualResult.equals("Apple iPhone 16 (128 GB) - Pink"))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test fail");
		}
		
	}
	
	public void amount()
	{
		String actualValue = price.getText();
		String expectedValue = "79,90";
		
		if (actualValue.equals(expectedValue))
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test fail");
		}
		
	}
	
	public static void main (String [] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/s?k=Iphone16&crid=38VD8RW3RT9FF&sprefix=iphone16%2Caps%2C210&ref=nb_sb_noss_2");
		
		CheckAsser asser = new CheckAsser(driver);
		
		asser.iphone();
		asser.amount();
		
		
		
		
		
	}
	
	
	

} 
