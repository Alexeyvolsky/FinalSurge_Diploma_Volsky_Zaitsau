package tests;

import enums.DistTypeHansons;
import enums.RaceDist;
import enums.SpeedType;
import enums.TempType;
import io.qameta.allure.Description;
import models.WorcoutCalculators.HansonsCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HansonsCalculatorTest extends BaseTest   {

    @BeforeMethod
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickWorkoutCalculateButton();
        hansonsModal.openIframeWorkoutCalculator();
    }

    @Description("Verify that Hensons calculator counts data")
    @Test
    public void positiveHansonsTest()   {
        hansonsModal.clickHansonsCalculatorButton();
        HansonsCalculator hansonsValue = HansonsCalculator.builder().setRaceDist(RaceDist.HALF_MARATHON)
                .setDistTypeHansons(DistTypeHansons.MILES).setHours(String.valueOf(faker.number().numberBetween(0, 24)))
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59)))
                .setTemperature(String.valueOf(faker.number().numberBetween(-40, 150)))
                .setWindSpeed(String.valueOf(faker.number().numberBetween(0, 99)))
                .setTempType(TempType.CELSIUS).setSpeedType(SpeedType.KILOMETERS_PER_HOUR)
                .setHumidity(String.valueOf(faker.number().numberBetween(0, 100))).build();
        hansonsModal.fillForm(hansonsValue);
        hansonsModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(hansonsModal.isGreenBoxDisplay());
    }
}