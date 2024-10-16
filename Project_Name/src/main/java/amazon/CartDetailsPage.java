package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartDetailsPage {

	@FindBy (xpath = "//span[text()='Apple iPhone 13 (128GB) - Midnight']")
	private WebElement productName;
	
	@FindBy (xpath = "(//span[text()='42,999.00'])[2]")
	private WebElement productPrice;
	
	private WebDriver driver;
	
	public CartDetailsPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getproductName()
	{
		return productName.getText().trim();
	}
	
	public String getproductPrice()
	{
		return productPrice.getText().trim();
	}
	
	
}
