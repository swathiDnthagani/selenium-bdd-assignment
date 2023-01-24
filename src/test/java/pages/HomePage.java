package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {
	
	@FindBy(css = "coi-banner-wrapper")
	public WebElement cookiesBanner;
	
    @FindBy(xpath = "//button[@class='coi-banner__accept' and @aria-label='Accepter alle']")
    public WebElement aceeptAllBtn;
    
    @FindBy(xpath = "//a[@href='/Account/Login']")
    public WebElement loginCTA;
    
	@FindBy(css = "#query")
	public WebElement searchField;
	
	@FindBy(xpath = "//div[@ng-repeat='product in suggestions.Products']")
	public List<WebElement> listOfItems; 

    
    public void acceptCookies() {
    	this.aceeptAllBtn.click();
    }
    
    public void searchAnItem(String item) {
    	this.searchField.sendKeys(item);
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void verifyListOfItems() {
    	Assert.assertTrue(this.listOfItems.size() > 0);
    }
    
    public void selectFirstItem() {
    	this.listOfItems.get(0).click();
    }
    
}
