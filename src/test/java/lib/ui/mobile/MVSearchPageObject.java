package lib.ui.mobile;

import lib.ui.MainPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.openqa.selenium.By.id;

public class MVSearchPageObject extends MainPageObject {

    private static final String
            SEARCH_INIT_ELEMENT = "//input[@type='search']",
            SEARCH_INPUT = "//input.search.mw-ui-background-icon-search",
            RESULT = "title",
            DESCRIPTION = "div.wikidata-description",
            CLOSE_BUTTON = "org.wikipedia:id/search_close_btn",
            SWIPE = "//*[@text='View page in browser']",
            RESULT_ABSENSE = "//*[@text='No results found']",
            ITEM_DESCRIPTION_ABSENSE = "org.wikipedia:id/page_list_item_description",
            TITLE_PRESENCE = "h3",
            ITEM_CONTAINER_PRESENCE = "org.wikipedia:id/page_list_item_container";


    public MVSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }


    public static void initSearchInput() {
        waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "cannot find the locator", 5);
    }

    public static void searchInput(String input) {
        waitForElementAndSendKeys(
                id(SEARCH_INPUT), input, "cannot find input", 5);

    }

    public static void seeResultAndClick() {
        waitForElementAndClick(By.xpath(RESULT), "cannot find element", 5);

    }

    public static void seeDescription() {
        webElementPresent(
                id(DESCRIPTION), "cannot find element", 5);

    }

    public static void clickCloseButton() {

        waitForElementAndClick(
                id(CLOSE_BUTTON), "cannot find element", 5);

    }

    public static void swipeElement() {
        swipeUpElement(
                By.xpath(SWIPE), "cannot find the element", 20);
    }

    public static void checkPresence() {
        webElementPresent(
                By.xpath(RESULT_ABSENSE), "cannot find empty result label", 15);

    }

    public static void checkAbsence() {
        MainPageObject.webElementNotPresent(
                id(ITEM_DESCRIPTION_ABSENSE), "cannot find element", 5);
    }

    public static void checkTitlePresence() {
        MainPageObject.assertElementPresent(
                By.id(TITLE_PRESENCE), "the element supposed to be here");
    }

    public static void checkItemContainerPresence() {

        MainPageObject.assertElementNotPresent(
                id(ITEM_CONTAINER_PRESENCE), "we found no result");
    }
}
