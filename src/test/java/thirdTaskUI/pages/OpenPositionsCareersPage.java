package thirdTaskUI.pages;

import io.qameta.allure.Step;
import thirdTaskUI.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.IntStream;

import static thirdTaskUI.helpers.CommonActions.moveToElement;
import static thirdTaskUI.helpers.CommonActions.sleep;

public class OpenPositionsCareersPage extends BasePage {
    public OpenPositionsCareersPage(WebDriver driver) {
        super(driver);
    }

    private static final String NAME_OF_JOBS_LOCATION = "//div[@class='position-location text-large']";
    private static final String APPLY_BTN = "//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5']";
    private static final String CAREER_SECTION = "//section[@id='career-position-list']";
    private static final String ALL_BTN = "//span[@title='All']";
    private static final String ISTANBUL_TURKEY_LOCATION = "//li[contains(@id, '%s')]";
    private static final String LIST_OF_JOBS = "//div[@class='position-list-item-wrapper bg-light']";
    private static final String NAME_OF_JOBS_POSITION = "//p[@class='position-title font-weight-bold']";
    private static final String NAME_OF_JOBS_DEPARTMENT = "//span[@class='position-department text-large font-weight-600 text-primary']";

    @Step("choose Location of vacancies")
    public OpenPositionsCareersPage chooseLocation(String location) {
        getClickableElementByXpath(ALL_BTN).click();
        getClickableElementByXpath(String.format(ISTANBUL_TURKEY_LOCATION, location)).click();
        return this;
    }

    @Step("check that jobs list present")
    public boolean isJobsListPresent() {
        List<WebElement> getListOfJobs = getVisibilityOfElementsByXpath(LIST_OF_JOBS);
        return getListOfJobs.size() > 0;
    }

    @Step("check that all jobs position contains concrete text")
    public boolean isAllJobsPositionContainsConcreteText(String text) {
        sleep(500);
        return getVisibilityOfElementsByXpath(NAME_OF_JOBS_POSITION).stream()
                .map(WebElement::getText)
                .allMatch(t -> t.contains(text));
    }

    @Step("check that all jobs department contains concrete text")
    public boolean isAllJobsDepartmentContainsConcreteText(String text) {
        return getVisibilityOfElementsByXpath(NAME_OF_JOBS_DEPARTMENT).stream()
                .map(WebElement::getText)
                .allMatch(t -> t.contains(text));
    }

    @Step("check that all jobs location contains concrete text")
    public boolean isAllJobsLocationContainsConcreteText(String text) {
        return getVisibilityOfElementsByXpath(NAME_OF_JOBS_LOCATION).stream()
                .map(WebElement::getText)
                .allMatch(t -> t.contains(text));
    }

    @Step("check that all jobs contains 'Apply now' btn")
    public boolean isAllJobsContainsApplyBtn() {
        scrollForElement(getVisibilityElementByXpath(CAREER_SECTION), driver);
        sleep(500);

        return IntStream.range(0, getVisibilityOfElementsByXpath(LIST_OF_JOBS).size())
                .allMatch(i -> {
                    moveToElement(driver, getVisibilityOfElementsByXpath(NAME_OF_JOBS_POSITION).get(i));
                    return getElementsByXpath(APPLY_BTN).get(i).isDisplayed();
                });
    }

    @Step("click on 'Apply now' btn")
    public OpenPositionsCareersPage clickOnApplyNowBtn() {
        moveToElement(driver, getVisibilityElementByXpath(NAME_OF_JOBS_POSITION));
        getClickableElementByXpath(APPLY_BTN).click();
        return this;
    }

    @Step("go to 'Lever Application Form' page")
    public LeverApplicationFormPage goToLeverApplicationFormPage(WebDriver driver) {
        return new LeverApplicationFormPage(driver);
    }
}
