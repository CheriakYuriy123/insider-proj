package thirdTaskUI.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import thirdTaskUI.base.TestInit;
import thirdTaskUI.pages.*;

public class InsiderGeneralTest extends TestInit {

    @Test
    public void complexOfDifferentAssertions() {
        HomePage homePage = new HomePage(driver);
        openUrl(BASE_URL);

        Assert.assertTrue(homePage.isWeAreOnTheHomePage());

        homePage
                .clickAcceptAllCookiesBtn()
                .clickMoreBtnOnHeader()
                .clickCareersBtn();

        CareersPage careersPage = homePage.goToCareersPage(driver);

        Assert.assertTrue(careersPage.isWeAreOnTheCareersPage());
        Assert.assertTrue(careersPage.isFindYourCallingBlockDisplayed());
        Assert.assertTrue(careersPage.isOurLocationBlockDisplayed());
        Assert.assertTrue(careersPage.isLifeAtInsiderBlockDisplayed());

        careersPage
                .clickOnSeeAllTeemsBtn()
                .clickOnQualityAssurancePart();

        QualityAssuranceCareersPage qualityAssuranceCareersPage = careersPage.goToQualityAssuranceCareersPage(driver);
        qualityAssuranceCareersPage
                .clickSeeAllQAJobsBtn();

        OpenPositionsCareersPage openPositionsCareersPage = qualityAssuranceCareersPage.goToOpenPositionsCareersPage(driver);
        openPositionsCareersPage
                .chooseLocation("Istanbul, Turkey");

        Assert.assertTrue(openPositionsCareersPage.isJobsListPresent());
        Assert.assertTrue(openPositionsCareersPage.isAllJobsPositionContainsConcreteText("Quality Assurance"));
        Assert.assertTrue(openPositionsCareersPage.isAllJobsDepartmentContainsConcreteText("Quality Assurance"));
        Assert.assertTrue(openPositionsCareersPage.isAllJobsLocationContainsConcreteText("Istanbul, Turkey"));
        Assert.assertTrue(openPositionsCareersPage.isAllJobsContainsApplyBtn());

        openPositionsCareersPage
                .clickOnApplyNowBtn();

        LeverApplicationFormPage leverApplicationFormPage = openPositionsCareersPage.goToLeverApplicationFormPage(driver);
        leverApplicationFormPage
                .goToLeverApplicationFormTab();

        Assert.assertTrue(leverApplicationFormPage.isWeAreOnTheLeverApplicationFormPage());
    }
}
