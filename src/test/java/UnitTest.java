import factory.WebDriverFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utils.PropReader;

public class UnitTest {
    @Test
    public void getBrowser() {
        String browser = PropReader.getProp("browser");
        System.out.println(browser);
    }

    @Test
    public void driverTest() {
        try {
            WebDriverFactory.init_driver("chrome");
            WebDriver driver = WebDriverFactory.getDriver();
            Thread.sleep(2000);
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
