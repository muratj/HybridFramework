package steps;

import factory.WebDriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.PropReader;

public class LoginPageSteps {

    private final WebDriver driver = WebDriverFactory.getDriver();
    private final String url = PropReader.getProp("url");
    private LoginPage loginPage;
    private HomePage homePage;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get(url);
        loginPage = new LoginPage(driver);
    }

    @When("user enters {string} on the email field")
    public void user_enters_on_the_email_field(String email) {
        loginPage.enterEmail(email);
    }

    @When("user enters {string} on the password field")
    public void user_enters_on_the_password_field(String password) {
        loginPage.enterPassword(password);
    }
    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("red frame is displayed")
    public void redFrameIsDisplayed() {
        Assert.assertTrue(loginPage.redFrame().isDisplayed());
    }

    @Then("user successfully logged in")
    public void user_successfully_logged_in() {
        homePage = new HomePage(driver);
    }

    @Then("sign-out button is displayed")
    public void sign_out_button_is_displayed() {
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
    }
}
