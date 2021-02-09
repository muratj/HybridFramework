package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // By locators
    private final By logoutButton = By.cssSelector(".logout");

    // page actions
    public WebElement getLogoutButton() {
        return driver.findElement(logoutButton);
    }
}
