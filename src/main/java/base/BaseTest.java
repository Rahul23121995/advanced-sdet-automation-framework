package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.DriverFactory;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initializeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}