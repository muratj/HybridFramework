package hooks;

import factory.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.PropReader;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AppHooks {
    public WebDriver driver;
    @Before(order = 0)
    public void setup() {
        String browser = PropReader.getProp("browser");
        WebDriverFactory.init_driver(browser);
        driver = WebDriverFactory.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // attach to report
            scenario.attach(sourcePath, "image/jpg", screenshotName);
            // to save on the file
            try {
                FileUtils.writeByteArrayToFile(
                        new File("src/test/resources/screenshots/"+screenshotName+".jpg"), sourcePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        driver.quit();
    }
}
