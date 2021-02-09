package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/LoginPage.feature"},
        glue = {"steps", "hooks"},
        plugin = {"pretty"},
        publish = true
)

public class LoginPageTestRunner {
}
