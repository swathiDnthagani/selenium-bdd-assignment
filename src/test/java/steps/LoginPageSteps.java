package steps;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.Base;

public class LoginPageSteps extends Base {
	
public LoginPage loginPage;
    
    public LoginPageSteps(Base base) {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

	@When("login with username as {string} and password as {string}")
	public void login_with_username_as_and_password_as(String userName, String password) {
	    loginPage.login(userName, password);
	}
	
	@Then("I should see field specific error messages")
	public void i_should_see_field_specific_error_messages() {
	    Assert.assertTrue(loginPage.emailRequiredErrorMessage.isDisplayed());
	    Assert.assertTrue(loginPage.passwordRequiredErrorMessage.isDisplayed());
	}
	
	@Then("I should see the {string}")
	public void i_should_see_the(String errorMessage) {
	    loginPage.verifyLoginErrorMessage(errorMessage);
	}
	
	@When("I login with valid credentials")
	public void i_login_with_valid_credentials() {
	    loginPage.login("validEmail", "password");
	}
	
	@Then("I should see successful login")
	public void i_should_see_successful_login() {
	    loginPage.verifyLogin();
	}
}
