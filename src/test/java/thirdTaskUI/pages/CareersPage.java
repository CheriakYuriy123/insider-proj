package thirdTaskUI.pages;

import io.qameta.allure.Step;
import thirdTaskUI.base.BasePage;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {
    private static final String SEE_ALL_TEEMS_BTN = "//div[@class='row']/a";
    private static final String OUR_LOCATION_BLOCK = "//section[@id='career-our-location']";
    private static final String FIND_YOUR_CALLING_BLOCK = "//section[@id='career-find-our-calling']";
    private static final String LIFE_AT_INSIDER_BLOCK = "//section[contains(@class,'element-a8e7b90 elementor-section-full')]";
    private static final String QUALITY_ASSURANCE_LINK = "//a[@href='https://useinsider.com/careers/quality-assurance/']/h3";

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    @Step("click on 'see all Teems' btn")
    public CareersPage clickOnSeeAllTeemsBtn() {
        scrollForElement(getClickableElementByXpath(SEE_ALL_TEEMS_BTN), driver);
        clickJS(getClickableElementByXpath(SEE_ALL_TEEMS_BTN));
        return this;
    }

    @Step("check that we are on Careers page")
    public boolean isWeAreOnTheCareersPage() {
        return driver.getCurrentUrl().contains("careers/");
    }

    @Step("check that 'Our location' block is displayed")
    public boolean isOurLocationBlockDisplayed() {
        return getVisibilityElementByXpath(OUR_LOCATION_BLOCK).isDisplayed();
    }

    @Step("check that 'Find your calling' block is displayed")
    public boolean isFindYourCallingBlockDisplayed() {
        return getVisibilityElementByXpath(FIND_YOUR_CALLING_BLOCK).isDisplayed();
    }

    @Step("check that 'Life At Insider' block is displayed")
    public boolean isLifeAtInsiderBlockDisplayed() {
        return getVisibilityElementByXpath(LIFE_AT_INSIDER_BLOCK).isDisplayed();
    }

    @Step("click on Quality Assurance part")
    public CareersPage clickOnQualityAssurancePart() {
        clickJS(getClickableElementByXpath(QUALITY_ASSURANCE_LINK));
        return this;
    }

    @Step("go to 'Quality Assurance Careers' page")
    public QualityAssuranceCareersPage goToQualityAssuranceCareersPage(WebDriver driver) {
        return new QualityAssuranceCareersPage(driver);
    }
}
