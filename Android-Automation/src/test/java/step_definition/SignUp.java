package step_definition;

import Graphql_api.GraphQLMutationTest;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;

import pages.*;
import util.Utility;


import java.util.HashMap;
import java.util.Map;

import static util.Utility.waitForVisible;

public class SignUp<MobileElement>  {
    public static AndroidDriver driver;

    public SignUp() {
        // Default constructor
    }

    public SignUp(AndroidDriver driver) {
        this.driver =driver;
    }


    static Map<String, Object> data = new HashMap<>();


    @And("^user enters  (.*) and  (.*)")
    public static void enterCredentials(String username, String password) throws InterruptedException {
        String uname = null;
        switch (username) {
            case "correct username":
                uname = Utility.getUsername();
                break;
            case "incorrect username":
                uname = "hawa@gmail.com";
                break;
            case "newly registered email":
                uname = (String) data.get("email");
                break;
            case "invalid email":
                uname = "saugat@clickandpress";
                break;
            default:
                System.out.println("username not found");
                break;
        }
        String pass = null;
        switch (password) {
            case "correct password":
                pass = Utility.getPassword();
                break;
            case "incorrect password":
                pass = "Kathmandu@12345";
                break;
            case "strong password":
                pass = "Kathmandu@123";
                break;
            default:
                System.out.println("password not found");
                break;
        }
        waitForVisible(LoginPage.getEmailField(),60).click();
        waitForVisible(LoginPage.getEmailFieldAfterClick(),60).sendKeys(uname);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        waitForVisible(LoginPage.getPasswordFieldAfterClick(),60).sendKeys(pass);
        driver.navigate().back();
    }


    @And("user clicks on signup button")
    public void userClicksOnSignupButton() {
        waitForVisible(LoginPage.getSignUpButton()).click();
    }

    @And("user verifies signup page")
    public void userVerifiesSignupPage() {
        waitForVisible(Signup.getSignupPageText()).isDisplayed();
        Signup.getGoogleAccountLoginButton().isDisplayed();
        Signup.getFacebookAccountLoginButton().isDisplayed();
        //Signup.getAppleAccountLoginButton().isDisplayed();
    }

    @And("^user enter (.*) email")
    public void enterEmailSignup(String email_type) {
        String email = null;
        switch (email_type) {
            case "invalid":
                email = "saugat.pppppppp";
                break;
            case "valid":
                email = Utility.generateRandom();
                break;
            case "already existing":
                email = "haude@gmail.com";
                break;
        }
        waitForVisible(Signup.getEmailField()).click();
        waitForVisible(Signup.getEmailField()).sendKeys(email);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @And("^user enter (.*) password")
    public void enterPasswordSignup(String password) {
        String password1 = null;
        switch (password) {
            case "weak":
                password1 = password = "saugat111111";
                break;
            case "strong":
                password1 = password = "Kathmandu@123";
                break;
            case "unmatching":
                password1 = "Kathmandu@123";
                password = "Lamjung@123";
                break;
        }
        waitForVisible(Signup.getFirstPasswordField()).sendKeys(password);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @And("user clicks Signup button")
    public void clickSignup() {
        waitForVisible(Signup.getSignupButton()).click();
    }

    @And("user clicks on recheck status button")
    public void userClicksOnRecheckStatusButton() {
        waitForVisible(AndroidHomepage.getRecheckStatusButton()).click();

    }

    @And("user sees user not active message")
    public void userSeesUserNotActiveMessage() {
        waitForVisible(Signup.getUserNotActiveMessage()).isDisplayed();
    }

    @And("user enters email and password for signup and verify it using API")
    public void userEntersEmailAndPasswordForSignup() {
        String email = Utility.generateRandom();
        GraphQLMutationTest.verifyUser(email);
        if (!(data.get("email") == null)) {
            data.remove("email");
        }
        data.put("email", email);
    }

    @And("user clicks on signin button in Signup page")
    public void userClicksOnSignupPageSigninButton() {
        waitForVisible(Signup.getSignInButton()).click();
    }

    @Then("user verifies tag selection page")
    public void userVerifiesTagSelectionPage() throws InterruptedException {
        waitForVisible(Signup.getTagSelectionPageText()).isDisplayed();
        Thread.sleep(5000);
    }

    @And("^user verifies and select (.*) tags")
    public void userVerifiesAndSelectTags(int number) {
        for (int i = 1; i <= number; i++) {
            waitForVisible(Signup.getTags(i),true,60).click();
        }
    }

    @Then("user clicks on next button")
    public void userClicksOnNextButton() {
        waitForVisible(Signup.getNextButton()).click();
    }

    @Then("^user verifies commitment page and select (.*)")
    public void userVerifiesCommitmentPage(String time) {
        waitForVisible(Signup.getCommitmentPageText()).isDisplayed();
        waitForVisible(Signup.getCommitmentTime(time)).click();
    }

    @And("user clicks on finish button")
    public void userClicksOnFinishButton() {
        waitForVisible(Signup.getFinishButton()).click();
    }


}

