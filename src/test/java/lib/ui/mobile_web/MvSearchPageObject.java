package lib.ui.mobile_web;

import lib.ui.MainPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static lib.ui.MainPageObject.*;
import static org.openqa.selenium.By.id;

public class MvSearchPageObject  {
    private static final String
            SEARCH_INIT_ELEMENT = "input#searchInput",
            SEARCH_INPUT = "input[type='search']",
            RESULT = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.view.View",
            DESCRIPTION = "org.wikipedia:id/page_list_item_description",
            CLOSE_BUTTON = "css:button.cancel",
            SWIPE = "//*[@text='View page in browser']",
            RESULT_ABSENSE = "css:p.without-results",
            ITEM_DESCRIPTION_ABSENSE = "xpath://div[contains{@class,'wikipedia-description'}]",
            TITLE_PRESENCE = "org.wikipedia:id/view_page_title_text",
            ITEM_CONTAINER_PRESENCE = "css:ul.page-list>li.page-summary";

    public MvSearchPageObject(ChromeDriver driver) {
    }


    public static void initSearchInput() {
        waitForElementAndClick(By.id(SEARCH_INIT_ELEMENT), "cannot find the locator", 5);
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
//
//    public static void swipeElement() {
//        if (driver instanceof AppiumDriver) {
//            AppiumDriver driver = (AppiumDriver) MainPageObject.driver;
//            swipeUpElement(
//                    By.xpath(SWIPE), "cannot find the element", 20);
//        }
//    }
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


