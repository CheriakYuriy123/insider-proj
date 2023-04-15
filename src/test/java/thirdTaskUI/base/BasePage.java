package thirdTaskUI.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import thirdTaskUI.helpers.CommonActions;
import thirdTaskUI.helpers.Conditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    private static final int BASE_TIME = 15;
    public WebDriverWait wait;
    public WebDriver driver;
    protected JavascriptExecutor jse;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(BASE_TIME));
        jse = (JavascriptExecutor) driver;
    }

    protected void clickJS(WebElement element) {
        jse.executeScript("arguments[0].click()", element);
    }

    public static void scrollForElement(WebElement element, WebDriver drv) {
        ((JavascriptExecutor) drv).executeScript("arguments[0].scrollIntoView(true);", element);
        CommonActions.sleep(200);
    }

    public static void switchToTab(WebDriver drv, Integer num) {
        ArrayList<String> tab = new ArrayList<>
                (drv.getWindowHandles());
        drv.switchTo().window(tab.get(num));
    }

    public boolean isCurrentUrlDisplayed(WebDriver driver, String url) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(BASE_TIME));
            wait.until(ExpectedConditions.urlContains(url));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected WebElement waitElement(String locator, Conditions conditions) {
        switch (conditions) {
            case CLICKABLE:
                try {
                    return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
                } catch (WebDriverException e) {
                    System.out.println("No clickable element:" + locator);
                }
            case VISIBILITY:
                try {
                    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                } catch (WebDriverException e) {
                    System.out.println("No visibility element:" + locator);
                }
            default:
                try {
                    return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
                } catch (WebDriverException e) {
                    System.out.println("No presence element:" + locator);
                }
        }
        return null;
    }

    protected List<WebElement> waitElements(String locator, Conditions conditions) {
        if (conditions == Conditions.VISIBILITY) {
            try {
                return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
            } catch (WebDriverException e) {
                System.out.println("No visibility element:" + locator);
            }
        }
        try {
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
        } catch (WebDriverException e) {
            System.out.println("No presence element:" + locator);
        }
        return null;
    }

    protected WebElement getVisibilityElementByXpath(String locator) {
        return waitElement(locator, Conditions.VISIBILITY);
    }

    protected List<WebElement> getVisibilityOfElementsByXpath(String locator) {
        return waitElements(locator, Conditions.VISIBILITY);
    }

    protected WebElement getClickableElementByXpath(String locator) {
        return waitElement(locator, Conditions.CLICKABLE);
    }

    protected List<WebElement> getElementsByXpath(String locator) {
        return waitElements(locator, Conditions.PRESENT);
    }
}
