package pages;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class AndroidHomepage {
    public static AppiumDriver driver;

    static String firstTrackFromNewRelease="//android.view.View[@content-desc=\"New Release\"]//android.widget.ImageView[@index='0']";



    static String profileButton= "//android.widget.ImageView[@content-desc=\"Tab 4 of 4\"]";

    public AndroidHomepage(AppiumDriver driver) {
        this.driver = driver;
    }

    public static WebElement getHomeButton() throws InterruptedException {
        return driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Tab 1 of 4\"]"));

    }
    public static WebElement getFirstTrackFromNewRelease() throws InterruptedException {
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(By.xpath(firstTrackFromNewRelease));

    }

    public static WebElement getExploreButton() throws InterruptedException {
        return driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Tab 2 of 4\"]"));
    }

    public static WebElement getMyLibraryButton() throws InterruptedException {
       return driver.findElement(By.xpath("//android.view.View[@content-desc=\"Library\"]"));
    }

    public static WebElement getProfileButton() throws InterruptedException {
        return driver.findElement(By.xpath(profileButton));
        }

    public static WebElement letsExplore() throws InterruptedException {

        return driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Let's Explore\"]"));
    }

    public static void doClick(WebElement element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static WebElement getDayNightModeButton()
    {
        return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]"));}

    public static WebElement getHomescreenImage() {
        try {
            return driver.findElement(By.xpath("//*[contains(@content-desc,'Welcome')]"));
        } catch (Exception e){
            return null;
        }
    }

    public static WebElement getRecheckStatusButton()
    {
        return driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Recheck Status\"]"));

   }

}

