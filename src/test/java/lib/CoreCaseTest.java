package lib;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CoreCaseTest extends TestCase {
    protected RemoteWebDriver driver;
    public static String url = "http://127.0.0.1:4723/wd/hub";

    @Before
    @Step("Run driver and session")
    protected void setUp() throws Exception {

        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/kalekseenko/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL(url), capabilities);
        this.createAllurePropertyFile();
        this.openWikiWeb();

    }

    @After
    @Step("Stop driver and session")
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }



    protected void openWikiWeb(){
      if(Platform.getInstance().isMV){
    driver.get("https://en.m.wikipedia.org/");
        } else{
          System.err.println("Android problem when writing allure properties file");
      }
    }





    private void createAllurePropertyFile(){
      String path = System.getProperty("allure.results.directory");
      try {
          Properties props = new Properties();
                  FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
//                  props.setProperty("Environment", Platform.getInstance.getPlatformVar();
                  props.store(fos, "comment");
                  fos.close();
      } catch (Exception e ) {
          System.err.println("Android problem when writing allure properties file");
          e.printStackTrace();
      }
    }
}
