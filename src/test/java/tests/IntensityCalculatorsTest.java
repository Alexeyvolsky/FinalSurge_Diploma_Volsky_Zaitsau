package tests;

import enums.SelectEvent;
import io.qameta.allure.Description;
import models.WorcoutCalculators.IntensityCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IntensityCalculatorsTest extends BaseTest {

    @BeforeMethod
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickWorkoutCalculateButton();
        baseModal.openIframeWorkoutCalculator();
    }

    @Description("Verify that Intensity calculator counts data")
    @Test
    public void positiveIntensityTest() {
        IntensityCalculator intensityValue = IntensityCalculator.builder()
                .setSelectEvent(SelectEvent.MILE).setHours("0")
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 15)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 45))).build();
        intensity.fillForm(intensityValue);
        baseModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Your Workout Paces"));
    }
}