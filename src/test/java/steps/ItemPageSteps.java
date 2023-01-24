package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ItemPage;
import utils.Base;

public class ItemPageSteps extends Base {
	
public ItemPage itemPage;
    
    public ItemPageSteps(Base base) {
        itemPage = PageFactory.initElements(driver, ItemPage.class);
    }

    @Then("I should navigate to item info page")
    public void i_should_navigate_to_item_info_page() {
        itemPage.verifyItemInfoPage();
    }
    @When("I click on Add to your basket")
    public void i_click_on_add_to_your_basket() {
        itemPage.addItemtoBasket();
    }
    
    @Then("product should be added to basket")
    public void product_should_be_added_to_basket() {
    	waitForElement(itemPage.itemsCount, 60);
    	itemPage.verifyItemCountInBasket();
    }
    @When("I click on go to cart")
    public void i_click_on_go_to_cart() {
        itemPage.goToCart();
    }
}
