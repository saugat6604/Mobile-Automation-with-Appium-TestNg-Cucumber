package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrackPage {
    public static AppiumDriver driver;


    public TrackPage(AppiumDriver driver) {
        this.driver = driver;
    }

    static String trackTitle="//android.view.View[@content-desc][1]";
    static String favoriteSuccessMessage="//android.view.View[@content-desc=\"This track has been added to your favorites.\"]";

    static String favoritePopUp="//android.view.View[@content-desc=\"Are you sure you want to remove this track from your favourites ?\"]";

    static String yesButtonFavoriteModal="//android.widget.Button[@content-desc=\"Yes\"]";

    static String trackUnfavoriteSucessMessage="//android.view.View[@content-desc=\"This track has been removed from your favorites.\"]";
    public static WebElement getFavoriteButton() throws InterruptedException {
        return driver.findElement(By.xpath("//android.widget.ImageView[@index='3']"));
    }

    public static WebElement getTrackTitle() throws InterruptedException {
        return driver.findElement(By.xpath(trackTitle));
    }

    public static WebElement getUnfavoriteFavoriteSucessMessage() throws InterruptedException {
        return driver.findElement(By.xpath(trackUnfavoriteSucessMessage));
    }

    public static WebElement getYesButtonFavoriteModal() throws InterruptedException {
        return driver.findElement(By.xpath(yesButtonFavoriteModal));
    }

    public static WebElement getFavoriteSucessMessage() throws InterruptedException {
        return driver.findElement(By.xpath(favoriteSuccessMessage));
    }

    public static WebElement getFavoritePopup() throws InterruptedException {
        return driver.findElement(By.xpath(favoritePopUp));
    }

    public static WebElement getBackButton() throws InterruptedException {
        return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
    }

    public static void clickDownload(AndroidDriver driver) throws InterruptedException {
       WebElement clickDownloads= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[4][@index='4']"));
       doClick(clickDownloads,driver);

    }

    public static void PlayTack() throws InterruptedException {
        WebElement playTracks=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]"));
        doClick(playTracks,driver);

    }
    public static void addToPlaylist(AndroidDriver driver) throws InterruptedException {
        WebElement addToPlaylists=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[5]"));
        doClick(addToPlaylists,driver);


    }


    public static void doClick(WebElement element,AppiumDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();


    }



    public static WebElement getFavoriteModal(){
        return driver.findElement(By.xpath("//android.view.View[@content-desc=\"Are you sure you want to remove this track from your favourites ?\"]"));
    }

    public static WebElement getYesButtonFavorites(){
        return driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Yes\"]"));
    }
    public static WebElement getCloseButtonInMiniplayer(){
        return driver.findElement(By.xpath(" //android.widget.ImageView[@content-desc=\"sanaa\"]/android.view.View[2]"));
    }

    public static WebElement getTrackPauseButton(){
        return driver.findElement(By.xpath(" /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]"));
    }

     ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]
}
