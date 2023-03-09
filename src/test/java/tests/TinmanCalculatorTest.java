package tests;

import enums.DistanceTinman;
import enums.Gender;
import io.qameta.allure.Description;
import models.WorcoutCalculators.TinmanCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Retry;

public class TinmanCalculatorTest extends BaseTest  {

    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickWorkoutCalculateButton();
        tinmanModal.openIframe();
    }

    @Description("Verify that Tinman calculator counts data")
    @Test(groups = {"regression"}, retryAnalyzer = Retry.class)
    public void positiveTinmanTest()    {
        tinmanModal.waitSaveButton();
        tinmanModal.clickTinmanCalculatorButton();
        TinmanCalculator tinmanValue = TinmanCalculator.builder().setDistanceTinman(DistanceTinman.MARATHON)
                .setHours(String.valueOf(faker.number().numberBetween(1, 24)))
                .setMinutes(String.valueOf(faker.number().numberBetween(1, 59)))
                .setSeconds(String.valueOf(faker.number().numberBetween(1, 59))).setGender(Gender.FEMALE).build();
        tinmanModal.fillForm(tinmanValue);
        tinmanModal.clickFirstSaveButtonSettings();
        Assert.assertTrue(tinmanModal.isGreenBoxDisplay());
    }
}
