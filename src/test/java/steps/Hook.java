package steps;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import utils.Base;


/**
 * @author 
 * 
 */

public class Hook extends Base {


    public Hook(Base base) {
    }

    @Before
    public void InitializeTest(Scenario scenario) {

        System.out.println("Opening the browser : Chrome");
        //System.setProperty("webdriver.chrome.driver", "D:/drivers/chromedriver/chromedriver.exe");
        Base.driver = new ChromeDriver();
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser");
        Base.driver.quit();
    }

    @BeforeStep
    public void BeforeEveryStep(Scenario scenario) {
        //@To-DO
    }

    @AfterStep
    public void AfterEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
    	//@To-DO
    }

}
