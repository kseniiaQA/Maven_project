package lib.ui.factories;

import lib.ui.SearchPageObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject {
    public IOSSearchPageObject(RemoteWebDriver driver) {
        super((ChromeDriver) driver);
    }
}
