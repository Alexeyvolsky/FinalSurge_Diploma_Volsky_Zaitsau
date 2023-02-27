package tests;

import enums.DistanceTinman;
import enums.Gender;
import io.qameta.allure.Description;
import models.WorcoutCalculators.TinmanCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TinmanCalculatorTest extends BaseTest  {

    @BeforeMethod
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickWorkoutCalculateButton();
        baseModal.openIframeWorkoutCalculator();
    }

    @Description("Verify that Tinman calculator counts data")
    @Test
    public void positiveTinmanTest()    {
        baseModal.clickTinmanCalculatorButton();
        TinmanCalculator tinmanValue = TinmanCalculator.builder().setDistanceTinman(DistanceTinman.MARATHON)
                .setHours(String.valueOf(faker.number().numberBetween(0, 24)))
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59))).setGender(Gender.FEMALE).build();
        tinman.fillForm(tinmanValue);
        baseModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Race Information"));
    }
}