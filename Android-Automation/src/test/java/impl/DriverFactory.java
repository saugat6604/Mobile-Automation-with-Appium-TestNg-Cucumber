package impl;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import util.Utility;


public class DriverFactory {
    AndroidDriver driver;
    public  static final String UserName = "saugatpaudel_MQbNWZ";
    public static final String AutomateKey = "cMzsnaaoT2EbMj4UBLTF";
    //public static final String URL = "https://"+UserName+":"+AutomateKey+"@hub-cloud.browserstack.com/wd/hub";
    public AndroidDriver createDriver() throws MalformedURLException {
        if ("Android".isBlank()) {





            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName", Utility.getDeviceName());
            cap.setCapability("uuid", Utility.getUuid());
            cap.setCapability("platformName", Utility.getPlatformName());
            cap.setCapability("platformVersion", Utility.getPlatformVersion());
            cap.setCapability("appPackage", Utility.getAppPackage());
            cap.setCapability("appActivity", Utility.getAppActivity());
            cap.setCapability("app",Utility.getApp());


//            caps.setCapability("deviceName","Google Pixel 3");
//
//            caps.setCapability("os version","9.0");
//
//            caps.setCapability("Project","CloudAutomation");
//
//            caps.setCapability("build","4.3.0");
//
//            caps.setCapability("name","BrowserStack Sample Test");
//
//            caps.setCapability("app","bs://abc6e660ca13eef2c18dfb945215143f4990b254");


            //adb shell dumpsys window windows | findstr ActivityRecord
            URL url = null;
            try {
                url = new URL("http://127.0.0.1:4723/wd/hub");
            } catch (
                    MalformedURLException e) {
                e.printStackTrace();
            }

            // driver= new AndroidDriver(new URL(URL),caps);

            driver = new AndroidDriver(url, cap);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        } else {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName", Utility.getDeviceName());
            cap.setCapability("uuid", Utility.getUuid());
            cap.setCapability("platformName", Utility.getPlatformName());
            cap.setCapability("platformVersion", Utility.getPlatformVersion());
            cap.setCapability("appPackage", Utility.getAppPackage());
            cap.setCapability("appActivity", Utility.getAppActivity());
            cap.setCapability("app",Utility.getApp());

//
//            caps.setCapability("deviceName","Google Pixel 3");
//
//            caps.setCapability("os version","9.0");
//
//            caps.setCapability("Project","CloudAutomation");
//
//            caps.setCapability("build","4.3.0");
//
//            caps.setCapability("name","BrowserStack Sample Test");
//
//            caps.setCapability("app","bs://abc6e660ca13eef2c18dfb945215143f4990b254");









           // adb shell dumpsys window windows | findstr ActivityRecord
            URL url = null;
            try {
                url = new URL("http://127.0.0.1:4723/wd/hub");
            } catch (
                    MalformedURLException e) {
                e.printStackTrace();
            }
             //driver= new AndroidDriver(new URL(URL),caps);
            driver = new AndroidDriver(url, cap);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        return driver;
    }

}
