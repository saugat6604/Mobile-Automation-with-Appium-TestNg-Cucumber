package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static org.apache.commons.io.FileUtils.getFile;


public class Utility {
    static Properties props;
    public static AppiumDriver driver;

    public Utility(AppiumDriver driver) {
        this.driver = driver;
    }


    public static Properties property() {
        props = new Properties();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/automationConfigQA.properties"));
            props.load(reader);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }

    public String getUrl() {
        return property().getProperty("baseUrl");
    }

    public static String getUsername() {
        return property().getProperty("userName");
    }

    public String getBrowser() {
        return property().getProperty("browserName");
    }

    public static String getPassword() {
        return property().getProperty("password");
    }

    public String getWrongPassword() {
        return property().getProperty("wrongPassword");
    }

    public String getForgotPasswordUrl() {
        return property().getProperty("forgotPasswordUrl");
    }

    public static String getDeviceName() {
        return property().getProperty("deviceName");
    }

    public static String getUuid() {
        return property().getProperty("uuid");
    }

    public static String getPlatformName() {
        return property().getProperty("platformName");
    }

    public static String getAppPackage() {
        return property().getProperty("appPackage");
    }

    public static String getPlatformVersion() {
        return property().getProperty("platformVersion");
    }

    public static String getAppActivity() {
        return property().getProperty("appActivity");
    }

    public static String getApp() {
        return property().getProperty("app");
    }

    public static void tapCordinate(AppiumDriver driver, int x, int y) {
        new TouchAction((PerformsTouchActions) Utility.driver)
                .tap(point(x, y))
                .waitAction(waitOptions(ofMillis(250))).perform();
    }

    public static WebElement waitForVisible(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time)); // Wait for up to 10 seconds
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitForVisible(WebElement element, boolean isClickable, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        if(isClickable) {
            wait.until(ExpectedConditions.elementToBeClickable(waitForVisible(element,time)));
        }
        return element;
    }

    public static WebElement waitForVisible(WebElement element) {
        return waitForVisible(element,60);
    }

    public static void selectBackgroundMusicUsingCordinate(WebElement element)
    {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        // Perform the tap action on the specific coordinates within the element
        touchAction.tap(ElementOption.point(element.getLocation().getX() + 726, element.getLocation().getY() + 478)).perform();
    }

    public static void selectBackgroundMusicUsingCordinate1(WebElement element)
    {
        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
        // Perform the tap action on the specific coordinates within the element
        touchAction.tap(ElementOption.point(element.getLocation().getX() + 726, element.getLocation().getY() + 63)).perform();
    }

    public static void scroll() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.5);
        int endY = (int) (size.height * 0.2);

        // Scroll down using TouchAction
        TouchAction action = new TouchAction((AndroidDriver) driver);
        action.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static String generateRandom() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000); // Generate a random number between 0 and 99
        String prefix = "saugsttty";
        String postfix = "@clickandpress.com";
        String result = prefix + randomNumber + postfix;
        return result;

    }
}
