package lib;
import lib.ui.ArticlePageObject;
//import lib.ui.Platform;
import lib.ui.SearchPageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CoreCaseTest  {
    public ChromeDriver driver;
    private static String URL = "http://127.0.0.1:4723/wd/hub";



    @Test
    public void testSaveArticlesToMyListDeleteAndCheckTitles() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        ArticlePageObject articlePageObject = new ArticlePageObject(driver);
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

//    protected void openWikiWebPageForMobileWeb(){
//        if (Platform.getInstance().isMV()) {
//            driver.get("https://en.m.wikipedia.org");
//        } else {
//            System.out.println("Method openWikiWebPageForMobileWeb() does nothing for platform " + Platform.getInstance());
//        }
    }

