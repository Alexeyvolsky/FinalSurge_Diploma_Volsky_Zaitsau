package tests;

import io.qameta.allure.Description;
import models.PrintWorkout;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintWorkoutsTest extends BaseTest {
// TODO: въебать прекондишн
    @Description("Verify that user can choose data and get list with his activities during that time")
    @Test
    public void positivePrintWorkoutTest()  {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickPrintWorkoutButton();
        baseModal.openIframePrintWorkout();
        PrintWorkout printWorkoutValue = PrintWorkout.builder().setStartingData("2/1/2023").setEndingData("2/20/2023").build();
        printWorkouts.fillForm(printWorkoutValue);
        baseModal.clickSaveButtonPrint();
        printDetailsPage.switchBetweenTabs();
        printDetailsPage.isPrintDetailsPageIsPresent();
        Assert.assertEquals(printDetailsPage.getPrintWorkoutData(), printWorkoutValue);
    }
}