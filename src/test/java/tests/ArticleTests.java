package tests;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;
import lib.CoreCaseTest;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.openqa.selenium.ScreenOrientation;

public class ArticleTests extends CoreCaseTest{

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
        ArticlePageObject.deleteArticleFromList();
        String title1 = "//*[@text='Appius Claudius Caecus']";
        ArticlePageObject.checkArticlePresense();
        String title2 = "//*[@text='Appius Claudius Caecus']";
        ((AppiumDriver<?>) driver).rotate(ScreenOrientation.LANDSCAPE);
        ArticlePageObject.selectAnotherArticle();
        Assert.assertEquals("titles are not the same", title1, title2);

    }


    @Test
    public void testAssertTitleIsPresent() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.searchInput("Appium");
        SearchPageObject.seeResultAndClick();
        SearchPageObject.checkTitlePresence();

    }

}
