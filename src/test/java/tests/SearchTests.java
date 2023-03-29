package tests;
import lib.ui.mobile_web.MvSearchPageObject;
import org.junit.Test;
import lib.CoreCaseTest;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SearchTests extends CoreCaseTest {



    @Test
    public void testCancelSearchAndCheck() {
        MvSearchPageObject searchPageObject = new  MvSearchPageObject(driver);
        MvSearchPageObject.initSearchInput();
        MvSearchPageObject.searchInput("Java");
        MvSearchPageObject.seeDescription();
        MvSearchPageObject.clickCloseButton();
        MvSearchPageObject.checkAbsence();
    }
    @Test
    public void testSwipeUp() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.searchInput("Appium");
        SearchPageObject.seeResultAndClick();
        SearchPageObject.swipeElement();
    }

    @Test
    public void testAmountOfEmptySearchResults() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.searchInput("grhhtht");
        SearchPageObject.seeResultAndClick();
        SearchPageObject.checkPresence();
        SearchPageObject.checkItemContainerPresence();
    }
}
