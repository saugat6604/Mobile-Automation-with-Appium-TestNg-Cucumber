package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyLibrary {
    public static AppiumDriver driver;


    public MyLibrary(AndroidDriver driver) {
        this.driver=driver;
    }

    static String favoriteList="//android.view.View[@content-desc=\"Favorites\n" + "Tab 1 of 3\"]";
    public static void goToFavorites() throws InterruptedException {
           driver.findElement(By.xpath(favoriteList));

    }

    public static void goToPlaylist(AndroidDriver driver) throws InterruptedException {
        WebElement goPlaylist=driver.findElement(By.xpath("//android.view.View[@content-desc=\"Playlists\n" + "Tab 2 of 3\"]"));
        doClick(goPlaylist,driver);

    }

    public static void goToDownloads(AndroidDriver driver) throws InterruptedException {
        WebElement goDownloads=driver.findElement(By.xpath("//android.view.View[@content-desc=\"Downloads\n" + "Tab 3 of 3\"]"));
        doClick(goDownloads,driver);

    }


    public static void removeFromFavorites(AndroidDriver driver) throws InterruptedException {
        WebElement removeFavorite=driver.findElement(By.xpath("//android.view.View[@content-desc=\"Remove from favorites\"]"));
        doClick(removeFavorite,driver);

    }


    public static void removeFromDownloads(AndroidDriver driver) throws InterruptedException {
        WebElement removeDownloads=driver.findElement(By.xpath("//android.view.View[@content-desc=\"Remove from downloads\"]"));
        doClick(removeDownloads,driver);


    }

    public static void doClick(WebElement element, AndroidDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();


    }






}
