package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.Base;

public class HomePageSteps extends Base {

    public HomePage homePage;
    
    public HomePageSteps(Base base) {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }
	
	@Given("I open Apopro website")
	public void i_open_apopro_website() {
	    openBaseURL();
	}
	@Given("I accept all cookies")
	public void i_accept_all_cookies() {
		homePage.acceptCookies();
	}
	@When("I click on login CTA")
	public void i_click_on_login_cta() {
	    homePage.loginCTA.click();
	}
	
	@When("I browse an item {string}")
	public void i_browse_an_item(String item) {
	    homePage.searchAnItem(item);
	}
	@Then("list of items should be displayed")
	public void list_of_items_should_be_displayed() {
		waitForElement(homePage.listOfItems.get(0), 15);
		homePage.verifyListOfItems();
	}
	@When("I click on first item")
	public void i_click_on_first_item() {
	    homePage.selectFirstItem();
	}

}
