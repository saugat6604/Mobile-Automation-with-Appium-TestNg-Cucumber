package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static pages.LoginPage.driver;



public class ExplorePage {

    static String adsCloseButton="//android.widget.Button";

     static String restartChapter="//android.widget.Button[@content-desc=\"Restart Chapter\"]";
    static String nextChapterButton="//android.widget.Button[@content-desc=\"Next Chapter\"]";
    static String skipButton="//android.view.View[@content-desc=\"Skip\"]";

    static String tryButton="//android.view.View[@content-desc=\"Try\"]";
    static String sessionTrackCompleteMessage="//android.view.View[@content-desc=\"Well Done! Moving onto the next session.\"]";

    static String backgroundMusic="//android.widget.ImageView[@index='0']";

    static String searchText="//android.view.View[@content-desc=\"Search\"]";
    static String sessionCompletionMessage="//android.view.View[@content-desc=\"Congrats on completing the session. Your dedication to your well-being is inspiring. Keep up the great work!\"]";
    static String resumeSessionButton="//android.view.View[@content-desc=\"Resume Session\"]";

    static String activeMusicDropdown="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]";

    static  String chooseSession="//*[contains(@content-desc,'med session')]";

    static String readMoreButton="//*[contains(@content-desc,'READ MORE')]";

    static String clearAllButton="//android.view.View[@content-desc=\"Clear All\"]";

    static String closeButton="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ScrollView/android.view.View[2]";
    static String sessionImage="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ImageView";

    static String backButton="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]";



    static String favoriteButton="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[3]";

    static  String  musicButton="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]";

    static  String searchBar="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText";
    public static WebElement clickSearchBar()  {
        return driver.findElement(By.xpath("//*[contains(@text,'What problem are you facing?')]"));}

    public static WebElement getSearchBar(){
        return driver.findElement(By.xpath(searchBar));
    }
    public static WebElement getRestartChapter(){
        return driver.findElement(By.xpath(restartChapter));
    }

    public static WebElement getSkipButton(){
        return driver.findElement(By.xpath(skipButton));
    }
    public static WebElement getTryButton(){
        return driver.findElement(By.xpath(tryButton));
    }

    public static WebElement getSessionCompletionMessage(){
        return driver.findElement(By.xpath(sessionCompletionMessage));
    }

    public static WebElement getResumeSessionButton(){
        return driver.findElement(By.xpath(resumeSessionButton));
    }

    public static WebElement getBackgroundMusic(){
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(By.xpath(backgroundMusic));
    }

    public static WebElement getSearchText(){
        return driver.findElement(By.xpath(searchText));
    }
    public static WebElement getNextChapterButton(){
        return driver.findElement(By.xpath(nextChapterButton));
    }

    public static WebElement getClearAllButton(){
        return driver.findElement(By.xpath(clearAllButton));
    }

    public static WebElement getActiveMusicDropdown(){
        return driver.findElement(By.xpath(activeMusicDropdown));
    }
    public static WebElement getSessionTrackCompletionMessage(){
        return driver.findElement(By.xpath(sessionTrackCompleteMessage));
    }

    public static WebElement getCloseButton(){
        return driver.findElement(By.xpath(closeButton));
    }
    public static WebElement getAdsCloseButton(){
        return driver.findElement(By.xpath(adsCloseButton));
    }

    public static WebElement getMusicButton(){
        return driver.findElement(By.xpath(musicButton));
    }
    public static WebElement getFavoriteButton(){
        return driver.findElement(By.xpath(favoriteButton));
    }
    public static WebElement getBackButton(){
        return driver.findElement(By.xpath(backButton));
    }
    public static WebElement getSessionImage(){
        return driver.findElement(By.xpath(sessionImage));
    }
    public static WebElement getReadMoreButton(){
        return driver.findElement(By.xpath(readMoreButton));
    }

    public static WebElement getSession(String value){
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(By.xpath("//*[contains(@content-desc,'${value}')]".replace("${value}", value)));
    }


    public static WebElement getDescription(String value) {
        return driver.findElement(By.xpath("//*[contains(@content-desc,'${value}')]".replace("${value}", value)));
    }

    public static WebElement getActiveMusic(String index){
        String xpathExpression = "//android.view.View[@content-desc='Active Music (" + index + ")']";
        return driver.findElement(By.xpath(xpathExpression));
    }
}
