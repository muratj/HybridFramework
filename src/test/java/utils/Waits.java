package utils;

import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    WebDriver driver = WebDriverFactory.getDriver();
    public void waitUntilClickable(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilUrlContains(String urlContains) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.urlContains(urlContains));
    }
}
