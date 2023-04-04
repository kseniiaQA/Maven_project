package tests;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.ui.ArticlePageObject;
import org.junit.Test;
import org.openqa.selenium.ScreenOrientation;
import lib.CoreCaseTest;
import lib.ui.SearchPageObject;



@Epic("Tests for articles")
public class ArticleTests extends CoreCaseTest {

    @Test
    @Features(value = {@Feature(value = "search"), @Feature(value = "Article")})
    @DisplayName("Compare article title with expected one")
    @Description("description")
    @Step("Starting testSaveArticlesToMyListDeleteAndCheckTitles")
    @Severity(value = SeverityLevel.BLOCKER)
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
        ArticlePageObject.deleteArticleFromList();
        String title1 = "//*[@text='Appius Claudius Caecus']";
        ArticlePageObject.checkArticlePresense();
        String title2 = "//*[@text='Appius Claudius Caecus']";
//        driver.rotate(ScreenOrientation.LANDSCAPE);
        ArticlePageObject.selectAnotherArticle();
//
//        ArticlePageObject.takeScreenshot("ArticlePage");


        assertEquals("titles are not the same", title1, title2);

    }


    @Test
    @Features(value = {@Feature(value = "search"), @Feature(value = "Article")})
    @DisplayName("Swipe article to the footer")
    @Description("description")
    @Step("Starting testAssertTitleIsPresen")
    @Severity(value = SeverityLevel.MINOR)
    public void testAssertTitleIsPresent() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.searchInput("Appium");
        SearchPageObject.seeResultAndClick();
        SearchPageObject.checkTitlePresence();

    }

}
