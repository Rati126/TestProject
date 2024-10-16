package popUpMessages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecommendedAcce {
	
	@FindBy (xpath = "//span[@id='attach-sidesheet-view-cart-button']//input")
	private WebElement goToCart;
	
	
	public RecommendedAcce (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickCart()
	{
		goToCart.click();
	}
	

}
