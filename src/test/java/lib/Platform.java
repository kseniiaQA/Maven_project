package lib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {

    private static final String PLATFORM_MOBILE_WEB = "mobile_web";
    private static final Object APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    private static final String PLATFORM_ANDROID = "android";
    private static final String PLATFORM_IOS = "ios" ;
    private static Platform instance;
    public boolean isMV;

    private Platform () {}


        public static Platform getInstance()
        {
            if (instance == null) {
                instance = new Platform();
            }
            return instance;
        }


     public RemoteWebDriver getDriver() throws Exception
     {
         URL URL = new URL((String) APPIUM_URL);
         if (this.isAndroid()) {
             return new AndroidDriver<>(URL, this.getAndroidDesiredCapabilities());
         } else if (this.isIOS()) {
             return new IOSDriver<>(URL, this.getIOSDesiredCapabilities());
         } else if (this.isMV()) {
             return new ChromeDriver(this.getMvChromeOptions());
         } else{
     throw new Exception("Cannot detect type of the driver");
     }
 }

        public boolean isMV() {
            return isPlatform(PLATFORM_MOBILE_WEB);
        }

        private boolean isPlatform(String platformMobileWeb) {
            return false;
        }
        public boolean isIOS() {
            return isPlatform(PLATFORM_IOS);
        }


        public boolean isAndroid() {
            return isPlatform(PLATFORM_ANDROID);
        }




    private Capabilities getIOSDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "8");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/kalekseenko/JavaAppiumAutomation/apks/org.wikipedia.apk");

        return capabilities;
    }



    private Capabilities getAndroidDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "8");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/kalekseenko/JavaAppiumAutomation/apks/org.wikipedia.apk");

        return capabilities;
    }

        private ChromeOptions getMvChromeOptions() {
        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
        deviceMetrics.put("deviceMetrics", deviceMetrics);
        deviceMetrics.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) ");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=340,640");
        return chromeOptions;
    }

}

