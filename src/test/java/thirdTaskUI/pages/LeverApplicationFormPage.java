package thirdTaskUI.pages;

import io.qameta.allure.Step;
import thirdTaskUI.base.BasePage;
import org.openqa.selenium.WebDriver;

public class LeverApplicationFormPage extends BasePage {
    public LeverApplicationFormPage(WebDriver driver) {
        super(driver);
    }

    @Step("go to 'Lever Application Form' tab")
    public LeverApplicationFormPage goToLeverApplicationFormTab() {
        switchToTab(driver, 1);
        return this;
    }

    @Step("check if we are on Lever Application Form page")
    public boolean isWeAreOnTheLeverApplicationFormPage() {
        return isCurrentUrlDisplayed(driver, "lever");
    }
}
