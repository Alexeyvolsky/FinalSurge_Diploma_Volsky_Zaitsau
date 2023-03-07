package tests;

import enums.SelectEvent;
import io.qameta.allure.Description;
import models.WorcoutCalculators.IntensityCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Retry;

public class IntensityCalculatorsTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickWorkoutCalculateButton();
        intensityModal.openIframeWorkoutCalculator();
        intensityModal.waitSaveButton();
    }

    @Description("Verify that Intensity calculator counts data")
    @Test(groups = {"regression"}, retryAnalyzer = Retry.class)
    public void positiveIntensityTest() {
        IntensityCalculator intensityValue = IntensityCalculator.builder()
                .setSelectEvent(SelectEvent.MILE).setHours("0")
                .setMinutes(String.valueOf(faker.number().numberBetween(4, 15)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 45))).build();
        intensityModal.fillForm(intensityValue);
        intensityModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(intensityModal.isGreenBoxDisplay());
    }
}