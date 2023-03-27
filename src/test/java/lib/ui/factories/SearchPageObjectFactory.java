package lib.ui.factories;

import lib.ui.Platform;
import lib.ui.SearchPageObject;
import lib.ui.mobile_web.MvSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.sun.jna.Platform.isAndroid;

public class SearchPageObjectFactory {
    public static SearchPageObject get(RemoteWebDriver driver)
    {
        if(Platform.getInstance(). isAndroid()) {
    return new AndroidSearchPageObject(driver);
    } else if (Platform.getInstance().isIOS()){
    return new IOSSearchPageObject(driver);
    }else {
    return new MvSearchPageObject(driver);
    }
    }
}
