package tests;
import io.appium.java_client.AppiumDriver;
import lib.ui.mobile_web.MVArticlePageObject;
import lib.ui.mobile_web.MvSearchPageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import lib.CoreCaseTest;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import static lib.ui.MainPageObject.driver;

public class ArticleTests {


    @Before
    public void setUp() {

        {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\kalekseenko\\chromedriver_win32\\chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://en.m.wikipedia.org");

        }
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testSaveArticlesToMyListDeleteAndCheckTitles() {

        MvSearchPageObject.initSearchInput();
        MvSearchPageObject.searchInput("Appium");
        MvSearchPageObject.seeResultAndClick();
        MVArticlePageObject.clickMoreOptionsButton();
        MVArticlePageObject.addToList();
        MVArticlePageObject.clickOnboardingButton();
        MVArticlePageObject.clearFolderInput();
        MVArticlePageObject.newFolderName("My folder");
        MVArticlePageObject.saveToFolder();
        MvSearchPageObject.initSearchInput();
        MvSearchPageObject.searchInput("Appium");
        MVArticlePageObject.selectAnotherArticle();
        MVArticlePageObject.clickMoreOptionsButton();
        MVArticlePageObject.addToList();
        MVArticlePageObject.goToFolder();
        MVArticlePageObject.deleteArticleFromList();
        String title1 = "//*[@text='Appius Claudius Caecus']";
        MVArticlePageObject.checkArticlePresense();
        String title2 = "//*[@text='Appius Claudius Caecus']";

        MVArticlePageObject.selectAnotherArticle();

        Assert.assertEquals("titles are not the same", title1, title2);

    }


//    @Test
//    public void testAssertTitleIsPresent() {
//        SearchPageObject searchPageObject = new SearchPageObject(driver);
//        SearchPageObject.initSearchInput();
//        SearchPageObject.searchInput("Appium");
//        SearchPageObject.seeResultAndClick();
//        SearchPageObject.checkTitlePresence();
//
//    }

}
