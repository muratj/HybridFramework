package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // By locators
    private final By emailField = By.xpath("//*[@type='email']");
    private final By passwordField = By.cssSelector("[type=password]");
    private final By loginButton = By.cssSelector("button");
    private final By errorFrame = By.xpath("//form[@class='error']");

    // page actions
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    public WebElement redFrame() {
        return driver.findElement(errorFrame);
    }
}
