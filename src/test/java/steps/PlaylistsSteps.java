package steps;

import com.github.javafaker.Faker;
import factory.WebDriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.PropReader;
import utils.Waits;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlaylistsSteps {
    private final WebDriver driver = WebDriverFactory.getDriver();
    private final String url = PropReader.getProp("url");
    private HomePage homePage;

    @Given("user already logged in")
    public void userAlreadyLoggedIn(DataTable data) {
        List<Map<String, String>> credentials = data.asMaps(String.class, String.class);
        String email = credentials.get(0).get("email");
        String password = credentials.get(0).get("password");
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        homePage = loginPage.login(email, password);
        Assert.assertTrue(homePage.isHomePage());
    }

    @When("user clicks on plus button on playlists section")
    public void userClicksOnPlusButtonOnPlaylistsSection() {
        homePage.getAddPlaylistButton().click();
    }

    @When("input field for new playlist name is appears")
    public void inputFieldForNewPlaylistNameIsAppears() {
        Assert.assertTrue(homePage.getPlaylistInputField().isDisplayed());
    }

    @When("user enters random playlist name on the input field")
    public void userEntersRandomPlaylistNameOnTheInputField() {
        Faker faker = new Faker();
        homePage.getPlaylistInputField().sendKeys(faker.music().genre());
    }

    @When("user press enter button")
    public void userPressEnterButton() {
        homePage.getPlaylistInputField().sendKeys(Keys.RETURN);
    }

    @Then("the playlist will appear on playlists list")
    public void playlistWillAppearOnPlaylistsList() {
        int countBeforeNewPlaylist = homePage.countPlaylists();
        new Waits().waitUntilUrlContains("playlist");
        int countAfterNewPlaylist = homePage.countPlaylists();

        Assert.assertEquals(countAfterNewPlaylist, countBeforeNewPlaylist+1);
    }
}
