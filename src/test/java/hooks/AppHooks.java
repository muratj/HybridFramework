package hooks;

import factory.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.PropReader;

import java.util.concurrent.TimeUnit;

public class AppHooks {
    public WebDriver driver;
    @Before(order = 0)
    public void setup() {
        String browser = PropReader.getProp("browser");
        WebDriverFactory.init_driver(browser);
        driver = WebDriverFactory.getDriver();
    }
    @Before(order = 1)
    public void getApp() {
        driver.get(PropReader.getProp("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
