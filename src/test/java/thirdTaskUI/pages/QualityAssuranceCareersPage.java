package thirdTaskUI.pages;

import io.qameta.allure.Step;
import thirdTaskUI.base.BasePage;
import org.openqa.selenium.WebDriver;

public class QualityAssuranceCareersPage extends BasePage {
    public QualityAssuranceCareersPage(WebDriver driver) {
        super(driver);
    }

    private static final String SEE_ALL_QA_JOBS_BTN = "//a[@href='https://useinsider.com/careers/open-positions/?department=qualityassurance']";

    @Step("click on 'See all QA jobs' btn")
    public QualityAssuranceCareersPage clickSeeAllQAJobsBtn() {
        getClickableElementByXpath(SEE_ALL_QA_JOBS_BTN).click();
        return this;
    }

    @Step("go to 'Open positions careers' page")
    public OpenPositionsCareersPage goToOpenPositionsCareersPage(WebDriver driver) {
        return new OpenPositionsCareersPage(driver);
    }
}
