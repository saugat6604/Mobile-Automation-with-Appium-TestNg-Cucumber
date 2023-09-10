package step_definition;

import Graphql_api.GraphQLMutationTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;
import util.Utility;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static util.Utility.waitForVisible;

public class Session<MobileElement> {
    Map<String, WebElement> elementCache = new HashMap<>();

    HashMap<String, String> secondTrack = new HashMap<>();
    HashMap<String, String> firstTrack = new HashMap<>();


    public static AndroidDriver driver;
    public Session() {
        // Default constructor
    }

    public Session(AndroidDriver driver) {
        this.driver =driver;
    }

    @And("^user search for (.*) Name")
    public void userSearchForSessionName(String sessionName) {
        waitForVisible(ExplorePage.clickSearchBar(),60).click();
        waitForVisible(ExplorePage.getSearchBar(),60).sendKeys(sessionName);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @And("^user click on (.*)")
    public void userClickOnSession(String sessionName) {
        try{
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        waitForVisible(ExplorePage.getSession(sessionName),120).click();
    }

    @And("user verifies session page")
    public void userVerifiesSessionPage() {
        waitForVisible(ExplorePage.getMusicButton(),60).isDisplayed();
        waitForVisible(ExplorePage.getFavoriteButton(),60).isDisplayed();
        waitForVisible(ExplorePage.getBackButton(),60).isDisplayed();
        waitForVisible(ExplorePage.getSessionImage(),60).isDisplayed();
    }

    @And("^user verifies (.*) title")
    public void userVerifiesSessionTitle(String sessionName) {
        waitForVisible(ExplorePage.getSession(sessionName),60).isDisplayed();
    }

    @And("^user verifies (.*) of session")
    public void userVerifiesSessionDescription(String sessionDescription) {
        waitForVisible(ExplorePage.getDescription(sessionDescription),60).isDisplayed();
    }

    @And("user clicks on back button")
    public void userClicksOnBackButton() {
        ExplorePage.getBackButton().click();

    }

    @Then("user is redirected to search page")
    public void userIsRedirectedToSearchPage() {
        ExplorePage.getSearchText().isDisplayed();
    }

    @And("^user gets background-music names from backend (.*)")
    public void userGetsBackgroundmusicNames(int number) {
        String aceessToken=GraphQLMutationTest.getAcessToken();
        String subcategory_id=GraphQLMutationTest.getSubcategoriesID(aceessToken);
        String[] backgroundmusic_title=GraphQLMutationTest.getBackgroundMusicName(aceessToken,subcategory_id);
        System.out.println();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<number;i++)
        {
            WebElement element=ExplorePage.getDescription(backgroundmusic_title[i]);
            Utility.selectBackgroundMusicUsingCordinate(element);
        }
    }

    @And("user clicks on music button")
    public void userClicksOnMusicButton() {
        ExplorePage.getMusicButton().click();
    }

    @Then("user verifies Background music Page")
    public void userVerifiesBackgroundMusicPage() {
        ExplorePage.getDescription("Background Music").isDisplayed();
    }

    @And("user clicks on skip button")
    public void userClicksOnSkipButton() {
        waitForVisible(ExplorePage.getSkipButton(),60).click();

    }
    @Then("^user verifies active menu is not visible (.*)")
    public void userVerifiesActiveMenuIsNotVisible(String index) {

        String accessibilityId = "Active Music (1)(" + index +")";
        WebElement element = null;
        boolean isElementDisplayed = false;

        try {
            element = getElement(driver, accessibilityId);
            isElementDisplayed = element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            // Handle the exception, log an error message, or perform any necessary actions
            System.out.println("Element not found: " + e.getMessage());
        } catch (Exception e) {
            // Handle other exceptions
            System.out.println("An error occurred: " + e.getMessage());
        }

        Assert.assertFalse(isElementDisplayed, "Element should not be displayed.");

    }
    private WebElement getElement(AppiumDriver driver, String accessibilityId) {
        String locator = "new UiSelector().description(\"" + accessibilityId + "\")";
        if (!elementCache.containsKey(locator)) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(locator)));
                elementCache.put(locator, element);
            } catch (TimeoutException e) {
                // Handle the exception, log an error message, or perform any necessary actions
                System.out.println("Element not found within the specified timeout: " + e.getMessage());
            } catch (Exception e) {
                // Handle other exceptions
                System.out.println("An error occurred while locating the element: " + e.getMessage());
            }
        }
        return elementCache.get(locator);
    }

    @And("user clicks mini player close button")
    public void userClicksMiniPlayerCloseButton() {
        TrackPage.getCloseButtonInMiniplayer().click();
    }

    @Then("user verifies resume session button")
    public void userVerifiesResumeSessionButton() {
        ExplorePage.getResumeSessionButton().isDisplayed();
    }

    @And("user clicks resume session button")
    public void userClicksResumeSessionButton() {
        ExplorePage.getResumeSessionButton().click();
    }

    @And("user clicks ads close button")
    public void userClicksAdsCloseButton() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Utility.waitForVisible(ExplorePage.getAdsCloseButton(),true,30).click();
    }

    @Then("user verifies title of track in mini player")
    public void userVerifiesTitleOfTrackInMiniPlayer() {
        String title=firstTrack.get("title");
        ExplorePage.getDescription(title).isDisplayed();

    }

    @And("user clicks on favorite  session button")
    public void userClicksOnFavoriteSessionButton() {
        ExplorePage.getFavoriteButton().click();
    }

    @Then("user verifies favorite sucess message")
    public void userVerifiesFavoriteSucessMessage() {
        String favMessage="This session has been added to your favorites";
        ExplorePage.getDescription(favMessage).isDisplayed();
    }

    @And("user clicks on Yes")
    public void userClicksOnYes() {
        String yes="Yes";
        ExplorePage.getDescription(yes).click();
    }

    @Then("user verifies unfavorite sucess message")
    public void userVerifiesUnfavoriteSucessMessage() {
        String message="This session has been removed from your favorites";
        ExplorePage.getDescription(message).isDisplayed();

    }

    @And("user clicks on No")
    public void userClicksOnNo() {
        String yes="No";
        ExplorePage.getDescription(yes).click();
    }

    @And("^user opens (.*) track")
    public void userOpensFirstTrack(String number) {
        String aceessToken=GraphQLMutationTest.getAcessToken();
        String[] titles=GraphQLMutationTest.getTracksFromSession(aceessToken);
        int number1 = Integer.parseInt(number);
        ExplorePage.getDescription((titles[number1-1])).click();
        secondTrack.put("title",titles[1]);
        firstTrack.put("title",titles[0]);
    }

    @Then("user verifies validation message shown")
    public void userVerifiesValidationMessageShown() {
        ExplorePage.getDescription("Please complete previous track first").isDisplayed();
    }

    @And("user selects background music")
    public void userSelectsBackgroundMusic() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ExplorePage.getBackgroundMusic().click();
    }

    @And("user clicks navigate back button")
    public void userClickssBackButton() {
        driver.navigate().back();
    }
    @And("user clicks on pause button")
    public void userClicksOnPauseButton() {
        TrackPage.getTrackPauseButton().click();

    }
    @And("user clicks on try button")
    public void userClicksOnTryButton() {
        ExplorePage.getTryButton().click();
    }

    @Then("user clicks on restart chapter button")
    public void userClicksOnRestartChapterButton() {
        ExplorePage.getRestartChapter().click();
    }

    @Then("user verifies title of first track in session")
    public void userVerifiesTitleOfFirstTrackInSession() {
        String searchText=firstTrack.get("title")+" "+"Completed!";
        ExplorePage.getDescription(searchText);
    }

    @And("user clicks back button")
    public void userClicksBackButton() throws InterruptedException {
        TrackPage.getBackButton().click();
    }

    @Then("user views track completion popup")
    public void userWaitsForPopup() {
        ExplorePage.getSessionTrackCompletionMessage().isDisplayed();
    }

    @And("user clicks on next chapter button")
    public void userClicksOnNextChapterButton() {
        ExplorePage.getNextChapterButton().click();
    }

    @Then("^user verifies title of second track in session (.*)")
    public void userVerifiesTitleOfSecondTrackInSession(String number) {
        System.out.println(number);
        String searchText=secondTrack.get("title")+" "+"Completed!";
        ExplorePage.getDescription(searchText);
    }

    @Then("user verifies session completion popup")
    public void userVerifiesSessionCompletionPopup() {
        ExplorePage.getSessionCompletionMessage().isDisplayed();
    }

    @And("^user selects background music from second subcategory (.*) and verifies total counts")
    public void userSelectsBackgroundMusicFromSecondSubcategoryNumber(int number) {
        String aceessToken=GraphQLMutationTest.getAcessToken();
        String[] results=GraphQLMutationTest.getSubcategoriesID1(aceessToken);
        ExplorePage.getDescription(results[1]).click();

        String[] backgroundmusic_title=GraphQLMutationTest.getBackgroundMusicName(aceessToken,results[0]);
        System.out.println();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i< 1;i++)
        {
            WebElement element=ExplorePage.getDescription(backgroundmusic_title[i]);
            System.out.println("-------------------------------");
            System.out.println(backgroundmusic_title[i]);
            Utility.selectBackgroundMusicUsingCordinate1(element);
        }
        int total=number+ 1;
        ExplorePage.getActiveMusic(Integer.toString(total)).isDisplayed();
    }

    @And("user gets subcategory id from backend")
    public void userGetsSubcategoryId() {
        String aceessToken=GraphQLMutationTest.getAcessToken();
        String response=GraphQLMutationTest.getSubcategoriesID(aceessToken);
        System.out.println(response);
    }

    @And("user clicks on active menu dropdown")
    public void userClicksOnActiveMenuDropdown() {
        ExplorePage.getActiveMusicDropdown().click();
    }

    @And("user clicks on clear all button")
    public void userClicksOnClearAllButton() {
        ExplorePage.getClearAllButton().click();
    }

    @Then("^user verifies active menu is visible (.*)")
    public void userVerifiesActiveMenuIsVisible(String number) {
        ExplorePage.getActiveMusic(number).isDisplayed();
    }

    @Then("user sees Yes Button to remove from favorites")
    public void userSeesYesButtonToRemoveFromFavorites() {
        String yes="Yes";
        ExplorePage.getDescription(yes).isDisplayed();
    }

}

