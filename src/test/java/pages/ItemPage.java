package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ItemPage {
	
	@FindBy(xpath = "//div[@id='product-wrap']//section[contains(@class, 'row')]//a[contains(@class, 'btn-primary')]")
	public WebElement addToBasketButton;
	
    @FindBy(xpath = "//a[@href='/Cart']//span[contains(@ng-show,'itemsCount')]")
    public WebElement itemsCount;
    
    @FindBy(xpath = "//a[@href='/Cart' and contains(@class, 'btn-primary')]")
    public WebElement goToCartButton;
    
	@FindBy(css = ".cart_empty")
	public WebElement cartEmptyLaout;
	
	@FindBy(xpath = "//a[contains(@class, 'remove-btn')]")
	public WebElement removeItemButton; 

    

    
    public void addItemtoBasket() {
    	this.addToBasketButton.click();
    }
    
    public void verifyItemInfoPage() {
    	Assert.assertTrue(this.addToBasketButton.isDisplayed());
    }
    
    public void verifyItemCountInBasket() {
    	Assert.assertTrue(Integer.parseInt(this.itemsCount.getText()) > 0 );
    }
    
    public void goToCart() {
    	this.goToCartButton.click();
    }
    
    public void removeItem() {
    	this.removeItemButton.click();
    }
    
    public void verifyCartEmptyLayout() {
    	Assert.assertTrue(this.cartEmptyLaout.isDisplayed());
    }
}
