package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waits;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // By locators
    private final By logoutButton = By.cssSelector(".logout");
    private final By addPlaylistButton = By.cssSelector("#playlists .create");
    private final By playlistInputField = By.cssSelector("form.create input");
    private final By playlists = By.xpath("//a[contains(@href, 'playlist')]");

    // page actions
    public WebElement getLogoutButton() {
        return driver.findElement(logoutButton);
    }
    public boolean isHomePage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getLogoutButton().isDisplayed();
    }

    // playlist actions
    public WebElement getAddPlaylistButton() {
        new Waits().waitUntilClickable(driver.findElement(addPlaylistButton), 10);
        return driver.findElement(addPlaylistButton);
    }
    public WebElement getPlaylistInputField() {
        return driver.findElement(playlistInputField);
    }
    public List<WebElement> getPlaylists() {
        return driver.findElements(playlists);
    }
    public int countPlaylists() {
        List<String> ids = new ArrayList<>();
        getPlaylists().forEach(element -> {
            String[] href = element.getAttribute("href").split("/");
            ids.add(href[2]);
        });
        return ids.size();
    }
}
