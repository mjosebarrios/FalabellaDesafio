package StepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Hooks {

    public static WebDriver driver;

    Scenario scenario = null;

    @Before
    public void initDriver(Scenario scenario) throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        //driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        this.scenario = scenario;

    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
