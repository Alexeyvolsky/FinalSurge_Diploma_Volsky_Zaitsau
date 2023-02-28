package tests;

import enums.DistTypePaceCalculator;
import io.qameta.allure.Description;
import models.OtherCalculators.PaceCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PaceCalculatorTest extends BaseTest  {

    @BeforeClass()
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickOtherCalculatorsButton();
        baseModal.openIframeOtherCalculator();
    }

    @Description("Verify that Pace calculator counts data")
    @Test
    public void positivePaceCalculatorTest()    {
        baseModal.clickPaceCalculatorButton();
        PaceCalculator paceCalculatorValue = PaceCalculator.builder()
                .setRunDistance(String.valueOf(faker.number().numberBetween(1, 9999)))
                .setDistTypePaceCalculator(DistTypePaceCalculator.KILOMETERS)
                .setHours(String.valueOf(faker.number().numberBetween(0, 24)))
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59))).build();
        paceCalculator.fillForm(paceCalculatorValue);
        baseModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Pace Chart"));
    }

    @Description("Verify that Pace calculator work correct with bad data")
    @Test(dataProvider = "negativePaceCalculatorList")
    public void negativePaceCalculatorTest(PaceCalculator paceCalculatorValue)    {
        baseModal.clickPaceCalculatorButton();
        paceCalculator.fillForm(paceCalculatorValue);
        baseModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(baseModal.alertErrorMessageIsPresent());
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