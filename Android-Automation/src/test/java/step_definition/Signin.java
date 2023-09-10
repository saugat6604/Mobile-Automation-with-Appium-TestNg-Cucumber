package step_definition;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.testng.Assert;
import pages.*;
import util.Utility;

import java.net.MalformedURLException;

import java.util.HashMap;
import java.util.Map;

import static util.Utility.waitForVisible;

public class Signin<MobileElement> {

    static Map<String, String> data;
    public static AndroidDriver driver;
    static Utility util;

    static LoginPage login;
    public void Stgnin() {
        data = new HashMap<>();
    }

    public Signin() {
        // Default constructor
    }

    public Signin(AndroidDriver driver) {
        this.driver =driver;
    }


    @Given("user is in onboarding page")
    public static void openGVApp() throws MalformedURLException {
        StepDefinitions.setDriver();
    }

    @And("user verifies onboarding page")
    public void userVerifiesOnboardingPage() {
        Assert.assertTrue(waitForVisible(login.getSignUpButton(),60).isDisplayed());
        waitForVisible(login.getSignInButton(),60).isDisplayed();
        waitForVisible(login.getOnboardingImageText(),60).isDisplayed();
    }

    @And("user clicks on signin button")
    public void userClicksOnSigninButton() {
        waitForVisible(login.getSignInButton(),60).click();

    }


    @And("user clicks on login button")
    public void clickLogin() throws InterruptedException {
        waitForVisible(LoginPage.getLoginButton(),60).click();
    }

    @And("user select lets explore button and enter homepage")
    public void userSelectLetsExploreButtonAndEnterHomepage() throws InterruptedException {
        StepDefinitions.clickLetsExplore();
    }

    @And("user enters correct email")
    public static void enterEmail() throws InterruptedException {
        waitForVisible(LoginPage.getEmailField()).click();
        waitForVisible(LoginPage.getEmailField()).sendKeys(util.getUsername());
    }

    @And("user checks if login button is unclickable")
    public void testLoginButtonNotClickable() throws InterruptedException {
        Assert.assertFalse(util.waitForVisible(login.getLoginButton(),60).isEnabled());
    }

    @Then("^user verifies (.*) validation messages")
    public void userVerfiesValidationMessage(String message) throws InterruptedException {
        switch (message) {
            case "incorrect password":
                LoginPage.getIncorrectMessage().isDisplayed();
                break;
            case "empty email":
                LoginPage.getEmptyEmailMessage().isDisplayed();
                break;
            case "unregistered user":
                LoginPage.getUnregisteredUserMessage().isDisplayed();
                break;
            case "invalid signup email":
                Signup.getEmailInvalidSignup().isDisplayed();
                break;
            case "weak password":
                Signup.getWeakPasswordValidationMessage().isDisplayed();
                break;
            case "unmatching password":
                Signup.getUnmatchingPasswordValidationMessage().isDisplayed();
                break;
            case "already registered":
                Signup.getAlreadyRegisteredValidationMessage().isDisplayed();
            default:
                System.out.println("no any message");
        }
    }

    @And("user enters correct password")
    public void userEntersCorrectPassword() {
        waitForVisible(LoginPage.getPasswordField()).click();
        waitForVisible(LoginPage.getPasswordField()).sendKeys("Hedamba@321");
    }
}

