package tests;

import io.qameta.allure.Description;
import models.WorcoutCalculators.PalladinoCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Retry;

public class PallandinoCalculatorTest extends BaseTest  {

    @BeforeMethod
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickWorkoutCalculateButton();
        baseModal.openIframeWorkoutCalculator();
    }

    @Description("Verify that PallandinoIntervalPower calculator counts data")
    @Test
    public void positivePallandinoIntervalPowerTest() {
        baseModal.clickPalladinoCalculatorButton();
        PalladinoCalculator palladinoIntervalPower = PalladinoCalculator.builder()
                .setCriticalPower(String.valueOf(faker.number().numberBetween(100, 500)))
                .setReserveWorkCapacity(String.valueOf(faker.number().numberBetween(1, 30))).build();
        palladino.fillFormCalculateIntervalPowerTarget(palladinoIntervalPower);
        baseModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Interval Power Targets"));
    }

    @Description("Verify that PallandinoMoreThenForty calculator counts data")
    @Test
    public void positivePallandinoMoreThenFortyCalculatorTest() {
        baseModal.clickPalladinoCalculatorButton();
        PalladinoCalculator palladinoMoreThenForty = PalladinoCalculator.builder()
                .setHours(String.valueOf(faker.number().numberBetween(0, 24)))
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59)))
                .setRaceAvgPower(String.valueOf(faker.number().numberBetween(20, 800))).build();
        palladino.fillFormCpFromRaceOrTtMoreThenForty(palladinoMoreThenForty);
        baseModal.clickThirdSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Estimate Results"));
    }

    @Description("Verify that PallandinoLessThenForty calculator counts data")
    @Test
    public void positivePallandinoLessThenFortyCalculatorTest() {
        baseModal.clickPalladinoCalculatorButton();
        PalladinoCalculator palladinoLessThenForty = PalladinoCalculator.builder()
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59)))
                .setRaceAvgPower(String.valueOf(faker.number().numberBetween(20, 800))).build();
        palladino.fillFormCpFromRaceOrTtLessThenForty(palladinoLessThenForty);
        baseModal.clickFourthSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Estimate Results"));
    }

    @Description("Verify that PallandinoCpAndRwc calculator counts data")
    @Test(retryAnalyzer = Retry.class)
    public void positivePallandinoCpAndRwcCalculatorTest()  {
        baseModal.clickPalladinoCalculatorButton();
        PalladinoCalculator palladinoCpAndRwc = PalladinoCalculator.builder()
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59)))
                .setShortTest(String.valueOf(faker.number().numberBetween(20, 800)))
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59)))
                .setLongTest(String.valueOf(faker.number().numberBetween(20, 800))).build();
        palladino.fillFormCpAndRwcFromACpTest(palladinoCpAndRwc);
        baseModal.clickSecondSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Estimate Results"));
    }
}