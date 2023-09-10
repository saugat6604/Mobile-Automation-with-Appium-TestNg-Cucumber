package step_definition;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.*;

import java.util.HashMap;

public class Library<MobileElement> {

    public static AndroidDriver driver;
    public Library() {
        // Default constructor
    }

    public Library(AndroidDriver driver) {
        this.driver =driver;
    }

    HashMap<String, String> trackName = new HashMap<>();

    @And("user clicks on favorite button")
    public void userClicksOnFavoriteButton() throws InterruptedException {
        Thread.sleep(9000);
        WebElement element = TrackPage.getFavoriteButton();
        element.click();
    }
    @And("user verifies track favorite success message")
    public void userVerifiesTrackFavoriteSucessMessage() throws InterruptedException {
        TrackPage.getFavoriteSucessMessage().isDisplayed();
    }

    @And("user verifies favorite popup modal displayed")
    public void userVerifiesFavoritePopupModalDisplayed() throws InterruptedException {
        TrackPage.getFavoritePopup().isDisplayed();
    }

    @And("user clicks on Yes button of favorite model")
    public void userClicksOnYesButtonOfFavoriteModel() throws InterruptedException {
        TrackPage.getYesButtonFavoriteModal().click();
    }

    @Then("user verifies track unfavorite sucess message")
    public void userVerfiesUnfavoriteSucessMessage() throws InterruptedException {
        TrackPage.getUnfavoriteFavoriteSucessMessage().isDisplayed();
    }

    @And("user saves track name")
    public void userSavesTrackName() throws InterruptedException {
        WebElement element=driver.findElement(By.xpath("//android.view.View[@content-desc]"));
        String contentDesc = element.getAttribute("content-desc");

        // Extract the text from the content-desc attribute
        String text = contentDesc;
        trackName.put("title",text);

        // Print the extracted text
        System.out.println(text);

    }
    @Then("user verifies Track name in favorite list")
    public void userVerifiesTrackNameInFavoriteList() {
        ExplorePage.getDescription(trackName.get("title")).isDisplayed();
    }

    @And("user clicks on library")
    public void userClicksOnLibrary() throws InterruptedException {
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AndroidHomepage.getMyLibraryButton().click();
    }
}

