package lib;
import junit.framework.TestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CoreCaseTest extends TestCase {
    protected RemoteWebDriver driver;
    private static String url = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "8");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/kalekseenko/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL(url), capabilities);
    }

    @Override
    protected  void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }
    @Test
    public void testSaveArticlesToMyListDeleteAndCheckTitles() {
        SearchPageObject searchPageObject = new SearchPageObject((AppiumDriver) driver);
        ArticlePageObject articlePageObject = new ArticlePageObject((AppiumDriver) driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.searchInput("Appium");
        SearchPageObject.seeResultAndClick();
        ArticlePageObject.clickMoreOptionsButton();
        ArticlePageObject.addToList();
        ArticlePageObject.clickOnboardingButton();
        ArticlePageObject.clearFolderInput();
        ArticlePageObject.newFolderName("My folder");
        ArticlePageObject.saveToFolder();
        SearchPageObject.initSearchInput();
        SearchPageObject.searchInput("Appium");
        ArticlePageObject.selectAnotherArticle();
        ArticlePageObject.clickMoreOptionsButton();
        ArticlePageObject.addToList();
        ArticlePageObject.goToFolder();
//        ArticlePageObject.deleteArticleFromList();
        String title1 = "//*[@text='Appius Claudius Caecus']";
        ArticlePageObject.checkArticlePresense();
        String title2 = "//*[@text='Appius Claudius Caecus']";
//        driver.rotate(ScreenOrientation.LANDSCAPE);
        ArticlePageObject.selectAnotherArticle();
        Assert.assertEquals("titles are not the same", title1, title2);

    }


}
