package lib.ui;

import static lib.ui.MainPageObject.driver;
import static lib.ui.MainPageObject.waitForElement;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RotationPageObject extends MainPageObject  {

    private static final String
            ELEMENT = "org.wikipedia:id/view_page_title_text";


    public RotationPageObject(RemoteWebDriver driver) {
        super((AppiumDriver) driver);
    }


    public void rotateAndCheckRotation() {
        if (driver instanceof AppiumDriver) {

            driver.rotate(ScreenOrientation.LANDSCAPE);
        }



        String title_after_rotation = String.valueOf(waitForElement(
                By.id( ELEMENT), "the element is not found", 10));
    }
}
