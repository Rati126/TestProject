package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult {
	
	@FindBy (xpath ="//span[text()='Apple iPhone 13 (128GB) - Midnight']")
	private WebElement titleofProduct;
	
	@FindBy  (xpath ="//span[text()='42,999']")
	private WebElement priceOfproduct;
	
	public SearchResult (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickonselectItem()
	{
		titleofProduct.click();
	}
    public void checkpriceofPrice()
    {
    	priceOfproduct.click();
    }
}
