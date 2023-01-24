package steps;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ShoppingCartPage;
import utils.Base;

public class ShoppingCartPageSteps extends Base {
	
public ShoppingCartPage shoppingCartPage;
    
    public ShoppingCartPageSteps(Base base) {
    	shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
    }

    @Then("I should navigate to your shopping cart page")
    public void i_should_navigate_to_your_shopping_cart_page() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://apopro.dk/Cart");
    }
    @When("I remove items from basket")
    public void i_remove_items_from_basket() {
        shoppingCartPage.removeItem();
    }
    @Then("basket should be empty")
    public void basket_should_be_empty() {
    	waitForElement(shoppingCartPage.cartEmptyLaout, 60);
        shoppingCartPage.verifyCartEmptyLayout();
    }
}
