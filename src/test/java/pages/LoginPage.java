package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {
	
	@FindBy(id = "Email")
	public WebElement emailTextField;
	
    @FindBy(id = "password")
    public WebElement passwordTextField;
    
    @FindBy(id = "login-submit")
    public WebElement loginSubmitButton;
    
    @FindBy(className = "alert-danger")
    public WebElement loginErrorMessage;
    
    @FindBy(css = "[ng-if='loginForm.Email.$error.required']")
    public WebElement emailRequiredErrorMessage;
    
    @FindBy(xpath = "//div[contains(@ng-if,'inputIsInvalid') and contains(@ng-if, 'Password')]")
    public WebElement passwordRequiredErrorMessage;
    
    public void login(String email, String password) {
    	this.emailTextField.sendKeys(email);
    	this.passwordTextField.sendKeys(password);
    	this.loginSubmitButton.click();
    }
    
    public void verifyLoginErrorMessage(String message) {
    	System.out.println("Actual: "+loginErrorMessage.getText());
    	System.out.println("Expected: "+message);
    	Assert.assertTrue(loginErrorMessage.getText().contains(message));
    	
    }
    
    public void verifyLogin() {
    	//TODO - don't have valid credentials to verify next checkpoint
    }
    

}
