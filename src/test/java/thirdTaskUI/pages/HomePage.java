package thirdTaskUI.pages;

import io.qameta.allure.Step;
import thirdTaskUI.base.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final String MORE_BTN_IN_HEADER = "//ul[@class=\"navbar-nav overflow-y\"]/li[6]";
    private static final String CAREERS_BTN = "//a[@href='https://useinsider.com/careers/']";
    private static final String ACCEPT_ALL_COOKIES_BTN = "//a[@id='wt-cli-accept-all-btn']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isWeAreOnTheHomePage() {
        return isCurrentUrlDisplayed(driver, "https://useinsider.com/");
    }

    @Step("click 'More' btn on header")
    public HomePage clickMoreBtnOnHeader() {
        getClickableElementByXpath(MORE_BTN_IN_HEADER).click();
        return this;
    }

    @Step("click 'Careers' btn")
    public HomePage clickCareersBtn() {
        getClickableElementByXpath(CAREERS_BTN).click();
        return this;
    }

    @Step("click 'Accept All Cookies' btn")
    public HomePage clickAcceptAllCookiesBtn() {
        getClickableElementByXpath(ACCEPT_ALL_COOKIES_BTN).click();
        return this;
    }

    @Step("go to Careers page")
    public CareersPage goToCareersPage(WebDriver driver) {
        return new CareersPage(driver);
    }
}
