package tests;
import org.junit.Test;
import lib.CoreCaseTest;
import lib.ui.SearchPageObject;


public class SearchTests extends CoreCaseTest {

    @Test
    public void testCancelSearchAndCheck() {
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.searchInput("Java");
        SearchPageObject.seeDescription();
        SearchPageObject.clickCloseButton();
        SearchPageObject.checkAbsence();
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
