package pages;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Utility;


public class LoginPage {


    public static AndroidDriver driver;


    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    static String signIn="Sign in";
    static String incorrectPasswordMessage="//android.view.View[@content-desc=\"Exception: Invalid password!\"]";

    static String unregisteredUserMessage="//android.view.View[@content-desc=\"Exception: User does not exist\"]";

    static String emptyEmailMessage="//android.view.View[@content-desc=\"Email cannot be empty\"]";
    static String login="Login";

    static String googleAccount="//android.widget.TextView[@resource-id='com.google.android.gms:id/account_name']";

    static String googleLoginButton="//android.widget.ImageView[@content-desc=\"Google\"]";

    static String facebookLoginButtom="//android.widget.ImageView[@content-desc=\"Facebook\"]";

    static String allowNotification="com.android.permissioncontroller:id/permission_allow_button";




    public static WebElement getSignInButton(){
        return  driver.findElement(MobileBy.AccessibilityId(signIn));
    }

    public static WebElement getAllowNotification() throws InterruptedException {
        return  driver.findElement(By.id(allowNotification));
    }


    public static WebElement getLoginButton() throws InterruptedException {
        return  driver.findElement(MobileBy.AccessibilityId(login));
    }

    public static WebElement getIncorrectMessage() throws InterruptedException {
        return  driver.findElement(By.xpath(incorrectPasswordMessage));
    }

    public static WebElement getUnregisteredUserMessage() throws InterruptedException {
        return  driver.findElement(By.xpath(unregisteredUserMessage));
    }

    public static WebElement getEmptyEmailMessage() throws InterruptedException {
        return  driver.findElement(By.xpath(emptyEmailMessage));
    }


    public static WebElement getEmailField() throws InterruptedException {
        return  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[8]/android.widget.EditText[1]"));
    }
    public static WebElement getEmailFieldAfterClick() throws InterruptedException {
        return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[8]/android.widget.EditText[1]"));

    }
    public static WebElement getPasswordField()  {
        return  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[8]/android.widget.EditText[2]"));
    }

    public static WebElement getLetsExploreButton(AndroidDriver driver)   {
        return  driver.findElement((By.xpath("//android.widget.Button[@content-desc=\"Let's Explore\"]")));
    }

    public static void clickSun(){
        Utility.tapCordinate((AndroidDriver) driver,966,283);

        // tap on home to enter home screen
        Utility.tapCordinate((AndroidDriver) driver,581,730);
    }
    public static WebElement getSignUpButton()  {
        return  driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Sign Up\"]"));
    }

    public static WebElement getOnboardingImageText()  {
        return driver.findElement(By.xpath("//*[contains(@content-desc,'Access 1000+ Sessions of sound therapy\n" +
                "Sound therapy can help heal the body and mind, bring balance to the mind-body connection, and relieve stress or insomnia.A session may last from 15 minutes to an hour depending on how long you need to achieve your goal.')]"));}

    public static WebElement getGoogleLoginButton() {
        return driver.findElement(By.xpath(googleLoginButton));
    }

    public static WebElement getGoogleAccountButton() {
        return driver.findElement(By.id("com.google.android.gms:id/account_name"));
    }

    public static WebElement getFacebookLoginButton() {
        return driver.findElement(By.xpath(facebookLoginButtom));
    }

    public static WebElement getPasswordFieldAfterClick() {
        return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[7]/android.widget.EditText[2]"));
    }


}
