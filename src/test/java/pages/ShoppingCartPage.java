package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ShoppingCartPage {
	
    
	@FindBy(css = ".cart_empty")
	public WebElement cartEmptyLaout;
	
	@FindBy(xpath = "//a[contains(@class, 'remove-btn')]")
	public WebElement removeItemButton; 
    
    public void removeItem() {
    	this.removeItemButton.click();
    }
    
    public void verifyCartEmptyLayout() {
    	Assert.assertTrue(this.cartEmptyLaout.isDisplayed());
    }
}
