package tests;

import enums.DistTypePaceCalculator;
import io.qameta.allure.Description;
import models.OtherCalculators.PaceCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Retry;

public class PaceCalculatorTest extends BaseTest  {

    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickOtherCalculatorsButton();
        paceModal.switchToIframeCalculator();
        paceModal.waitForSaveButtonDisplayed();
    }

    @Description("Verify that Pace calculator counts data")
    @Test(groups = {"regression"}, retryAnalyzer = Retry.class)
    public void positivePaceCalculatorTest()    {
        paceModal.clickPaceCalculatorButton();
        PaceCalculator paceCalculatorValue = PaceCalculator.builder()
                .setRunDistance(String.valueOf(faker.number().numberBetween(1, 9999)))
                .setDistTypePaceCalculator(DistTypePaceCalculator.KILOMETERS)
                .setHours(String.valueOf(faker.number().numberBetween(0, 24)))
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59))).build();
        paceModal.fillForm(paceCalculatorValue);
        paceModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(paceModal.isGreenBoxDisplay());
    }

    @Description("Verify that Pace calculator work correct with bad data")
    @Test(dataProvider = "negativePaceCalculatorList", groups = {"negative","regression"}, retryAnalyzer = Retry.class)
    public void negativePaceCalculatorTest(PaceCalculator paceCalculatorValue)    {
        paceModal.clickPaceCalculatorButton();
        paceModal.fillForm(paceCalculatorValue);
        paceModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(paceModal.alertErrorMessageIsPresent());
    }

    @DataProvider(name = "negativePaceCalculatorList")
    public Object [][] negativePaceCalculatorList() {
        return new Object[][]   {
                {PaceCalculator.builder().setRunDistance("%$%$").setDistTypePaceCalculator(DistTypePaceCalculator.KILOMETERS)
                        .setHours("%$%$%").setMinutes("%%$%$").setSeconds("%$$%$%").build()},
                {PaceCalculator.builder().setRunDistance("").setDistTypePaceCalculator(DistTypePaceCalculator.KILOMETERS)
                        .setHours("").setMinutes("").setSeconds("").build()},
                {PaceCalculator.builder().setRunDistance(String.valueOf(faker.number().numberBetween(10000, 100000)))
                        .setDistTypePaceCalculator(DistTypePaceCalculator.MILES)
                        .setHours(String.valueOf(faker.number().numberBetween(0, 24)))
                        .setMinutes(String.valueOf(faker.number().numberBetween(60, 100)))
                        .setSeconds(String.valueOf(faker.number().numberBetween(60, 100))).build()},
        };
    }
}
