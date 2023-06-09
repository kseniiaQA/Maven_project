package lib.ui;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;


public class MainPageObject {
public static ChromeDriver driver;

public MainPageObject(ChromeDriver driver) {
    MainPageObject.driver = driver;
}

    public static WebElement waitForElement(By by, String error_message, int i) {
        WebDriverWait wait = new WebDriverWait(driver, i);
        wait.withMessage(error_message + "\n");

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement[] getListOfElements(By by, String error_message, int i) {
        WebElement element = waitForElement(by, error_message, (int) i);

        return new WebElement[]{element};
    }

    public static WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElement(by, error_message, (int) timeoutInSeconds);
        element.click();
        return element;
    }

    public static WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElement(by, error_message, (int) timeoutInSeconds);
        element.sendKeys(value);
        return element;


    }

    public static boolean webElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static WebElement webElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public static WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElement(by, error_message, (int) timeoutInSeconds);
        element.clear();
        return element;
    }

    public WebElement assertElementHasText(By by, String expectedText, String error_message) {
        WebElement element = waitForElement(by, error_message, 15);
        element.getText();
        return element;

    }

    public WebElement assertElementContainsText(By by, String expectedText, String error_message) {
        WebElement element = waitForElement(by, error_message, 15);
        element.getText();
        return element;

    }

    private WebElement getListOfElements(By by, String expectedText, String error_message) {
        WebElement element = waitForElement(by, error_message, 15);
        element.getText();
        return element;
    }


    public static void swipeUp(int timeOfSwipe) {
//        if (driver instanceof AppiumDriver) {

            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int start_y = (int) (size.height * 0.8);
            int end_y = (int) (size.height * 0.2);
          action.tap(PointOption.point(x, start_y)).waitAction().moveTo(PointOption.point(x, end_y)).release().perform();

        }


    public static void swipeUpQuick() {
//        if (driver instanceof AppiumDriver) {

            swipeUp(200);
        }


    protected static void swipeUpElement(By by, String error_message, int max_swipes) {
//        if (driver instanceof AppiumDriver) {

            swipeUp(200);
            driver.findElements(by);
            driver.findElements(by).size();
            int already_swiped = 0;
            while (driver.findElements(by).size() == 0) {

                if (already_swiped > max_swipes) {
                    waitForElement(by, "cannot find the element", Integer.parseInt(0 + error_message));
                    return;
                }
                swipeUpQuick();
                ++already_swiped;
            }

        }


    public static void swipeUpElementToLeft(By by, String error_message) {
//        if (driver instanceof AppiumDriver) {

            WebElement element = webElementPresent(by, error_message, 300);
            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();
            int upper_y = element.getLocation().getY();
            int lower_y = left_x + element.getSize().getHeight();
            int middle_y = upper_y + lower_y / 2;
            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            action
                    .tap(PointOption.point(right_x, middle_y))
                    .waitAction()
                    .moveTo(PointOption.point(left_x, middle_y))
                    .release()
                    .perform();


        }

    public static int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();

    }

    public static void assertElementNotPresent(By by, String error_message) {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements > 0) {
            String message = "an element " + by.toString() + "supposed to be not present";
            throw new AssertionError(message + "" + error_message);
        }
    }

    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, int timeoutInSeconds) {

        WebElement element = waitForElement(by, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }


    public static void assertElementPresent(By by, String error_message) {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements < 0) {
            String message = "an element " + by.toString() + "supposed to be present";
            throw new AssertionError(message + "" + error_message);
        }

    }
}
