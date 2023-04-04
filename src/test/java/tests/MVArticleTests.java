package tests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreCaseTest;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.mobile.MVArticlePageObject;
import lib.ui.mobile.MVSearchPageObject;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static lib.ui.MainPageObject.driver;

public class MVArticleTests extends  CoreCaseTest{

    @Test
    @Features(value = {@Feature(value = "search"), @Feature(value = "Article")})
    @DisplayName("Compare article title with expected one")
    @Description("description")
    @Step("Starting testSaveArticlesToMyListDeleteAndCheckTitles")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSaveArticlesToMyListDeleteAndCheckTitles() {
        MVSearchPageObject searchPageObject = new  MVSearchPageObject(driver);
        MVArticlePageObject articlePageObject = new MVArticlePageObject(driver);
        MVSearchPageObject.initSearchInput();
        MVSearchPageObject.searchInput("Appium");
        MVSearchPageObject.seeResultAndClick();
        MVArticlePageObject .clickMoreOptionsButton();
        MVArticlePageObject .addToList();
        MVArticlePageObject .clickOnboardingButton();
        MVArticlePageObject .clearFolderInput();
        MVArticlePageObject .newFolderName("My folder");
        MVArticlePageObject .saveToFolder();
        MVSearchPageObject.initSearchInput();
        MVSearchPageObject.searchInput("Appium");
        MVArticlePageObject .selectAnotherArticle();
        MVArticlePageObject .clickMoreOptionsButton();
        MVArticlePageObject .addToList();
        MVArticlePageObject .goToFolder();
        MVArticlePageObject .deleteArticleFromList();
        String title1 = "//*[@text='Appius Claudius Caecus']";
        MVArticlePageObject .checkArticlePresense();
        String title2 = "//*[@text='Appius Claudius Caecus']";

        MVArticlePageObject .selectAnotherArticle();
//
//        ArticlePageObject.takeScreenshot("ArticlePage");

        Assert.assertEquals("titles are not the same", title1, title2);

    }


    @Test
    @Features(value = {@Feature(value = "search"), @Feature(value = "Article")})
    @DisplayName("Swipe article to the footer")
    @Description("description")
    @Step("Starting testAssertTitleIsPresen")
    @Severity(value = SeverityLevel.MINOR)
    public void testAssertTitleIsPresent() {
        MVSearchPageObject searchPageObject = new MVSearchPageObject (driver);
        MVSearchPageObject .initSearchInput();
        MVSearchPageObject.searchInput("Appium");
        MVSearchPageObject .seeResultAndClick();
        MVSearchPageObject .checkTitlePresence();

    }

}

