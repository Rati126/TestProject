package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath = "//span[text()='Account & Lists']")
	private WebElement accountList;
	
	@FindBy(xpath = "//span[text()='Sign in']")
	private WebElement sigIn;
	
	@FindBy (xpath = "//span[text()='Sign out']")
	private WebElement logOutButton;
	
	@FindBy (xpath ="//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;
	
	@FindBy (xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchButton;
	
	@FindBy (xpath = "//span[text()='Apple iPhone 13 (128GB) - Midnight']")
	private WebElement searchsuggetion;
	
	private Actions act;
	
	public HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		act = new Actions (driver);
	}
	
	public void clickaccountList()
	{
		accountList.click();
	}
	public void clickOnsigIn()
	{
		act.moveToElement(accountList).moveToElement(sigIn).click().build().perform();
	}
	public void clicklogOutButton()
	{
		act.moveToElement(accountList).moveToElement(logOutButton).click().build().perform();
	}
	
	public void enterProductname(String productname)
	{
		searchBox.sendKeys(productname);
	}
	public void clicksearchButton()
	{
		searchButton.click();
	}
	public void clicksearchsuggetion()
	{
		searchsuggetion.click();
	}
	
	
	
	

}
