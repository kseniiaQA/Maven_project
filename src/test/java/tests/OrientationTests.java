package tests;
import static lib.ui.MainPageObject.waitForElement;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import lib.CoreCaseTest;
import lib.ui.BackgroundPageObject;
import lib.ui.RotationPageObject;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OrientationTests extends CoreCaseTest {



    @Test
    public void testChangeScreenOrientation() {

        SearchPageObject.initSearchInput();
        SearchPageObject.searchInput("Appium");
        SearchPageObject.seeResultAndClick();
        String title_before_rotation = String.valueOf(waitForElement(
                By.id("org.wikipedia:id/view_page_title_text"), "the element is not found", 10));
        String title_after_rotation = String.valueOf(waitForElement(
                By.id("org.wikipedia:id/view_page_title_text"), "the element is not found", 10));

        Assert.assertEquals("titles are not the same", title_before_rotation, title_after_rotation);
    }


    @Test
    public void testCheckSearchInBackground() {

        SearchPageObject.initSearchInput();
        SearchPageObject.searchInput("Appium");

    }
}
