package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails {
	
	@FindBy (xpath = "//span[@id='productTitle']")
	private WebElement productName;
	
	@FindBy (xpath = "(//span[@class='a-price-whole'])[1]")
	private WebElement productPrice;
	
	@FindBy (xpath = "(//input[@id='add-to-cart-button'])[2]")
	private WebElement addtoCart;
	
	@FindBy (xpath = "//input[@id='buy-now-button']")
	private WebElement buyNow;
	
	private WebDriver driver;
	
	public ProductDetails (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void gotoFrame()
	{
		driver.switchTo().frame(buyNow);
	}
	
    public String getProductname()
    {
    	return productName.getText().trim();
    }
    
    public String getproductPrice()
    {
    	return productPrice.getText().trim();
    }
    public void clickaddtoCart()
    {
    	addtoCart.click();
    }
    public void clickbuyNow()
    {
    	buyNow.click();
    }
    
    
    
}
