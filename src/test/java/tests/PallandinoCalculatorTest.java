package tests;

import io.qameta.allure.Description;
import models.WorcoutCalculators.PalladinoCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Retry;

public class PallandinoCalculatorTest extends BaseTest  {

    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickWorkoutCalculateButton();
        palladinoModal.openIframeWorkoutCalculator();
    }

    @Description("Verify that PallandinoIntervalPower calculator counts data")
    @Test(groups = {"regression"}, retryAnalyzer = Retry.class)
    public void positivePallandinoIntervalPowerTest() {
        palladinoModal.clickPalladinoCalculatorButton();
        PalladinoCalculator palladinoIntervalPower = PalladinoCalculator.builder()
                .setCriticalPower(String.valueOf(faker.number().numberBetween(100, 500)))
                .setReserveWorkCapacity(String.valueOf(faker.number().numberBetween(1, 30))).build();
        palladinoModal.fillFormCalculateIntervalPowerTarget(palladinoIntervalPower);
        palladinoModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(palladinoModal.isGreenBoxIntervalPowerDisplay());
    }

    @Description("Verify that PallandinoMoreThenForty calculator counts data")
    @Test(groups = {"regression"}, retryAnalyzer = Retry.class)
    public void positivePallandinoMoreThenFortyCalculatorTest() {
        palladinoModal.clickPalladinoCalculatorButton();
        PalladinoCalculator palladinoMoreThenForty = PalladinoCalculator.builder()
                .setHours(String.valueOf(faker.number().numberBetween(0, 24)))
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59)))
                .setRaceAvgPower(String.valueOf(faker.number().numberBetween(20, 800))).build();
        palladinoModal.fillFormCpFromRaceOrTtMoreThenForty(palladinoMoreThenForty);
        palladinoModal.clickThirdSaveButtonSettings();
        Assert.assertTrue(palladinoModal.isGreenBoxMoreThenFortyDisplay());
    }

    @Description("Verify that PallandinoLessThenForty calculator counts data")
    @Test(groups = {"regression"}, retryAnalyzer = Retry.class)
    public void positivePallandinoLessThenFortyCalculatorTest() {
        palladinoModal.clickPalladinoCalculatorButton();
        PalladinoCalculator palladinoLessThenForty = PalladinoCalculator.builder()
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59)))
                .setRaceAvgPower(String.valueOf(faker.number().numberBetween(20, 800))).build();
        palladinoModal.fillFormCpFromRaceOrTtLessThenForty(palladinoLessThenForty);
        palladinoModal.clickFourthSaveButtonSettings();
        Assert.assertTrue(palladinoModal.isGreenBoxLessThenFortyDisplay());
    }

    @Description("Verify that PallandinoCpAndRwc calculator counts data")
    @Test(groups = {"regression"}, retryAnalyzer = Retry.class)
    public void positivePallandinoCpAndRwcCalculatorTest()  {
        palladinoModal.clickPalladinoCalculatorButton();
        PalladinoCalculator palladinoCpAndRwc = PalladinoCalculator.builder()
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59)))
                .setShortTest(String.valueOf(faker.number().numberBetween(20, 800)))
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59)))
                .setLongTest(String.valueOf(faker.number().numberBetween(20, 800))).build();
        palladinoModal.fillFormCpAndRwcFromACpTest(palladinoCpAndRwc);
        palladinoModal.clickSecondSaveButtonSettings();
        Assert.assertTrue(palladinoModal.isGreenBoxCpAndRwcDisplay());
    }
}
