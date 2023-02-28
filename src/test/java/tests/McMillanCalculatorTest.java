package tests;

import enums.DistanceMcMillan;
import io.qameta.allure.Description;
import models.WorcoutCalculators.McMillanCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class McMillanCalculatorTest extends BaseTest  {

    @BeforeMethod
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickWorkoutCalculateButton();
        baseModal.openIframeWorkoutCalculator();
    }

    @Description("Verify that McMillan calculator counts data")
    @Test
    public void positiveMcMillanTest()  {
        baseModal.clickMcMilanCalculatorButton();
        McMillanCalculator mcMillanValue = McMillanCalculator.builder().setDistanceMcMillan(DistanceMcMillan.MILE)
                .setHours(String.valueOf(faker.number().numberBetween(0, 24)))
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59)))
                .setDistanceMcMillan(DistanceMcMillan.MARATHON)
                .setHours(String.valueOf(faker.number().numberBetween(0, 24)))
                .setMinutes(String.valueOf(faker.number().numberBetween(0, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(0, 59))).build();
        mcMillan.fillForm(mcMillanValue);
        baseModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(baseModal.isGreenBoxDisplay("Goal Race Times"));
    }
}