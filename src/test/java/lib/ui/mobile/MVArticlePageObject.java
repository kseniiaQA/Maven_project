package lib.ui.mobile;

import io.qameta.allure.Step;
import lib.ui.ArticlePageObject;
import lib.ui.MainPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.openqa.selenium.By.id;

public class MVArticlePageObject extends ArticlePageObject {
    private static final


     String  MORE_OPTION_BUTTON = "//android.widget.ImageView[@content-desc=\"More options\"]",
               ADD_TO_LIST = "a.mw-ui-button.mw-ui-quiet.mw-ui-icon.mw-ui-icon-element.mw-ui-icon-star.mw-ui-icon-wikimedia-star.mw-ui-icon-small",
               ONBOARDING_BUTTON = "org.wikipedia:id/onboarding_button",
               FOLDER_NAME = "org.wikipedia:id/text_input",
               OK_BUTTON = "android:id/button1",
               NAVIGATE_UP = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]",
               MY_FOLDER = "//*[@text='My folder']",
               MENU_BUTTON = "//android.widget.FrameLayout[@content-desc=\"My lists\"]/android.widget.ImageView",
               SECOND_ARTICLE = "//*[@text='Appius Claudius Caecus']",
               FIRST_ARTICLE = "//*[@text='Appium']";


    public MVArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }


    @Step("clickMoreOptionsButton")
    public static void clickMoreOptionsButton() {
        waitForElementAndClick(
                By.xpath(MORE_OPTION_BUTTON), "cannot find element", 5);

    }
    @Step("add article to List")
    public static void addToList() {
        waitForElementAndClick(
                By.xpath(ADD_TO_LIST), "cannot find element to add article to a list", 5);
//screenshot(this.takeScreenshot("article title"));
    }
    @Step("click onboarding button")
    public static void clickOnboardingButton() {
        waitForElementAndClick(
                id(ONBOARDING_BUTTON), "cannot find element overlay", 5);

    }


    @Step("cleans input for folder name ")
    public static void clearFolderInput() {
        MainPageObject.waitForElementAndClear(
                id(FOLDER_NAME), "cannot find element to clear the input", 5);

    }


    @Step("inits new fodler name ")
    public static void newFolderName(String name) {
        MainPageObject.waitForElementAndSendKeys(
                id(FOLDER_NAME), name, "cannot find the input", 5);

    }


    @Step("saves article to a folder ")
    public static void saveToFolder() {

        waitForElementAndClick(
                id(OK_BUTTON), "cannot find element to go to main page", 5);


        waitForElementAndClick(
                By.xpath(NAVIGATE_UP), "cannot find element to navigate to my list", 5);

    }



    @Step("goes inside a folder ")
    public static void goToFolder() {
        waitForElementAndClick(
                By.xpath(MY_FOLDER), "cannot find element overlay", 5);


        waitForElementAndClick(
                By.xpath(NAVIGATE_UP), "cannot find element to go to main page", 5);

        waitForElementAndClick(
                By.xpath(MENU_BUTTON), "cannot find element navigate to my list", 5);

        waitForElementAndClick(
                By.xpath(MY_FOLDER), "cannot find my article in My list", 5);

    }


    @Step("aselects another article ")
    public static void selectAnotherArticle() {
        waitForElementAndClick(
                By.xpath(SECOND_ARTICLE), "cannot find element overlay", 5);
    }


    @Step("deletes article form the list ")
    public static void deleteArticleFromList() {
//        MainPageObject.swipeUpElementToLeft(
//                By.xpath(FIRST_ARTICLE), "cannot delete my article in My list");
//сделать другой метод удаления статьи
    }


    @Step("checks article is present in the folder")
    public static void checkArticlePresense() {
        MainPageObject.webElementPresent(
                By.xpath(SECOND_ARTICLE), "cannot find the element", 5);
    }
}


