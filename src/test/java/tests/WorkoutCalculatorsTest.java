package tests;

import enums.*;
import models.WorcoutCalculators.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WorkoutCalculatorsTest extends BaseTest {

    @BeforeMethod
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickWorkoutCalculateButton();
        baseModal.openIframeWorkoutCalculator();
    }

    @Test
    public void positiveIntensityTest() {
        Intensity intensityValue = Intensity.builder().setHours("0").setMinutes("12").setSeconds("12")
                .setSelectEvent(SelectEvent.MILE).build();
        intensity.fillForm(intensityValue);
        baseModal.clickSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Your Workout Paces"));
    }

    @Test
    public void positiveHansonsTest()   {
        baseModal.clickHansonsCalculatorButton();
        Hansons hansonsValue = Hansons.builder().setRaceDist(RaceDist.HALF_MARATHON).setDistTypeHansons(DistTypeHansons.MILES)
                .setHours("2").setMinutes("43").setSeconds("12").setTemperature("20").setWindSpeed("12")
                .setTempType(TempType.CELSIUS).setSpeedType(SpeedType.KILOMETERS_PER_HOUR).setHumidity("10").build();
        hansons.fillForm(hansonsValue);
        baseModal.clickSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Recent Race Information"));
    }

    @Test
    public void positiveMcMillanTest()  {
        baseModal.clickMcMilanCalculatorButton();
        McMillan mcMillanValue = McMillan.builder().setDistanceMcMillan(DistanceMcMillan.MILE).setHours("0").setMinutes("15")
                .setSeconds("30").setDistanceMcMillan(DistanceMcMillan.MARATHON).setHours("1").setMinutes("20")
                .setSeconds("24").build();
        mcMillan.fillForm(mcMillanValue);
        baseModal.clickSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Goal Race Times"));
    }

    @Test
    public void positiveTinmanTest()    {
        baseModal.clickTinmanCalculatorButton();
        Tinman tinmanValue = Tinman.builder().setDistanceTinman(DistanceTinman.MARATHON).setHours("1").setMinutes("10")
                .setSeconds("10").setGender(Gender.FEMALE).build();
        tinman.fillForm(tinmanValue);
        baseModal.clickSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Race Information"));
    }

    @Test
    public void positivePallandinoTest() {

        baseModal.clickPalladinoCalculatorButton();
        Palladino palladinoIntervalPower = Palladino.builder().setCriticalPower("101").setReserveWorkCapacity("12").build();
        palladino.fillFormCalculateIntervalPowerTarget(palladinoIntervalPower);
        baseModal.clickSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Interval Power Targets"));
        // TODO:
        Palladino palladinoCpAndRwc = Palladino.builder().setMinutes("12").setSeconds("12").setShortTest("60")
                .setMinutes("15").setSeconds("15").setLongTest("80").build();
        palladino.fillFormCpAndRwcFromACpTest(palladinoCpAndRwc);
        baseModal.clickSaveButtonSettings2();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Estimate Results"));

        Palladino palladinoMoreThenForty = Palladino.builder().setHours("1").setMinutes("12").setSeconds("12")
                .setRaceAvgPower("30").build();
        palladino.fillFormCpFromRaceOrTtMoreThenForty(palladinoMoreThenForty);
        baseModal.clickSaveButtonSettings3();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Estimate Results"));

        Palladino palladinoLessThenForty = Palladino.builder().setMinutes("12").setSeconds("12").setRaceAvgPower("30").build();
        palladino.fillFormCpFromRaceOrTtLessThenForty(palladinoLessThenForty);
        baseModal.clickSaveButtonSettings4();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Estimate Results"));
    }
}