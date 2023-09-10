package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Signup {
    public static AppiumDriver driver;
    public Signup(AppiumDriver driver) {
        this.driver = driver;
    }

    static String signupPageText="//android.view.View[@content-desc=\"Create your account\"]";

    static String googleAccountLoginButton="//android.widget.ImageView[@content-desc=\"Continue with Google\"]";

    static String facebookAccountButton="//android.widget.ImageView[@content-desc=\"Continue with Facebook\"]";

    static String appleAccountLogin="//android.widget.ImageView[@content-desc=\"Continue with Apple\"]";

    static String emailField="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[8]/android.widget.EditText[1]";

    static String firstPasswordField="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[7]/android.widget.EditText[2]";

    static String secondPasswordField="//android.view.View[@content-desc=\"Create account\n" +
            "Sign up and get started!\"]/android.widget.EditText[3]";

    static  String signupButton="//android.widget.Button[@content-desc=\"Sign Up\"]";
    public static WebElement getSignupPageText(){
        return  driver.findElement(By.xpath(signupPageText));
    }

    public static WebElement getEmailField(){
        return  driver.findElement(By.xpath(emailField));
    }

    public static WebElement getFirstPasswordField(){
        return  driver.findElement(By.xpath(firstPasswordField));
    }

    public static WebElement getSecondPasswordField(){
        return  driver.findElement(By.xpath(secondPasswordField));
    }

    public static WebElement getSignupButton(){
        return  driver.findElement(By.xpath(signupButton));
    }

    public static WebElement getUserNotActiveMessage(){
        return  driver.findElement(By.xpath("//android.view.View[@content-desc=\"User is not active\"]"));
    }

    public static WebElement getEmailInvalidSignup(){
        return  driver.findElement(By.xpath("//android.view.View[@content-desc=\"Email is invalid\"]"));
    }

    public static WebElement getGoogleAccountLoginButton(){
        return  driver.findElement(By.xpath(googleAccountLoginButton));
    }
    public static WebElement getFacebookAccountLoginButton(){
        return  driver.findElement(By.xpath(facebookAccountButton));
    }

    public static WebElement getAppleAccountLoginButton(){
        return  driver.findElement(By.xpath(appleAccountLogin));
    }


    public static WebElement getWeakPasswordValidationMessage(){
        return  driver.findElement(By.xpath("//android.view.View[@content-desc=\"Include small, capital, number & special character\"]"));
    }

    public static WebElement getUnmatchingPasswordValidationMessage(){
        return  driver.findElement(By.xpath("//android.view.View[@content-desc=\"Password must match\"]"));
    }

    public static WebElement getAlreadyRegisteredValidationMessage(){
        return  driver.findElement(By.xpath("//android.view.View[@content-desc=\"Exception: User with email id haude@gmail.com already exist\"]"));
    }

    public static WebElement getSignInButton(){
        return  driver.findElement(By.xpath("//android.widget.Button[@content-desc=\" Sign In\"]"));
    }

    public static WebElement getTagSelectionPageText(){
        return  driver.findElement(By.xpath("//android.view.View[@content-desc=\"Choose up to 3 goals of interest for personalized suggestions.\"]"));
    }
    public static WebElement getTags(int index){
        String path="//android.widget.ImageView[${value}]".replace("${value}", ""+index);
        return driver.findElement(By.xpath(path));

    }



    public static WebElement getNextButton(){
        return  driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Continue \"]"));
    }

    public static WebElement getOthersTag(){
        return  driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Other\"]"));
    }

    public static WebElement getOthersTagEditBox(){
        return  driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Other\"]/android.widget.EditText"));
    }



    public static WebElement getCommitmentPageText(){
        return  driver.findElement(By.xpath("//android.view.View[@content-desc=\"Would you like to make a commitment?\"]"));
    }

    public static WebElement getCommitmentTime( String time){
        return  driver.findElement(By.xpath("//*[contains(@content-desc,'${time}')]".replace("${time}",(time))));
    }


    //*[contains(@content-desc,'Welcome')]
    public static WebElement getFinishButton(){
        return  driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Finish\"]"));
    }

    public static WebElement getSkipButton(){
        return  driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Skip\"]"));
    }





    //android.view.View[@content-desc="We will best understand your music medicine needs if you express what's bothering you. Feel free to select the options or comment specifically."]










}
