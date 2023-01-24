package utils;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author
 * 
 */

public class Base {

	public static WebDriver driver;

	public ConfigManager configManager = new ConfigManager();

	public String applicationURL = configManager.getProperty("basURL");

	public void openBaseURL() {
		driver.get(applicationURL);
		driver.manage().window().maximize();
	}

	public void mouseHover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	public void waitForElement(final WebElement element, long timeoutInSeconds) {

		try {
			ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver input) {

					return element.isDisplayed();
				}
			};
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
					.ignoring(StaleElementReferenceException.class);
			wait.until(expectation);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
