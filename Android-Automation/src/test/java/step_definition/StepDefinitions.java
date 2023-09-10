package step_definition;

import Graphql_api.GraphQLMutationTest;
import impl.DriverFactory;
import io.appium.java_client.MobileBy;

import io.appium.java_client.AppiumDriver;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.testng.Assert;
import pages.*;
import util.Utility;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static util.Utility.waitForVisible;

public class StepDefinitions<MobileElement> {
    Map<String, WebElement> elementCache = new HashMap<>();

    HashMap<String, String> secondTrack = new HashMap<>();
    HashMap<String, String> firstTrack = new HashMap<>();

    HashMap<String, String> trackName = new HashMap<>();

    static Map<String, String> data;
    public static AndroidDriver driver;
    static Utility util;
    static AndroidHomepage homepage;
    static LoginPage login;

    static SignUp signUp;

    static Library library;

    static Signup signup;

    static Session session;

    static TrackPage trackPage;

    static MyLibrary myLibrary;

    static Signin signin;

    public StepDefinitions() {
        data = new HashMap<>();
    }


    public static void setDriver() throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.createDriver();
        util = new Utility(driver);
        login = new LoginPage(driver);
        homepage = new AndroidHomepage(driver);
        signup = new Signup(driver);
        trackPage = new TrackPage(driver);
        myLibrary= new MyLibrary(driver);
        signUp = new SignUp(driver);
        library = new Library(driver);
        session = new Session(driver);
        signin = new Signin(driver);

    }


    @And("user selects lets explore button")
    public static void clickLetsExplore() throws InterruptedException {
        waitForVisible(AndroidHomepage.letsExplore(),120).click();
    }

    @And("user scroll in the homepage")
    public void uerScrollInTheHomepage() {
        util.scroll();
    }

    @And("user selects explore button")
    public void userSelectsExploreButton() throws InterruptedException {
        waitForVisible(AndroidHomepage.getExploreButton(),60).click();
    }

    @And("user clicks on allow notifications")
    public void userClicksOnAllowNotifications() throws InterruptedException {
        LoginPage.getAllowNotification().click();
    }

    @And("user clicks on play button")
    public void userClicksOnPlayButton() throws InterruptedException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TrackPage.PlayTack();
    }

    @And("user open track from New Release")
    public void userOpenTrackFromNewRelease() throws InterruptedException {
        AndroidHomepage.getFirstTrackFromNewRelease().click();
    }

}

