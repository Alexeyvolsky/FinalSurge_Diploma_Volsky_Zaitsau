package tests;

import enums.*;
import io.qameta.allure.Description;
import models.PrintWorkout;
import models.QuickAdd;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Retry;

public class PrintWorkoutsTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void makeTestData() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickCalendarButton();
        calendarPage.clickPlusButton(Day.FIRST_DAY);
        calendarPage.clickQuickAddButton();
        calendarPage.waitAddWorkoutButton();
        QuickAdd quickAddFirstDay = QuickAdd.builder().setDate("03/1/2023").setTimeOfDay("03:21").setActivityType(ActivityType.RUN)
                .setWorkoutName("Alexey").setWorkoutDescription("Description").setDistanceInput("33.00")
                .setDistTypeHills(DistTypeHills.METERS).setDuration("4:56").setPaceType(PaceType.MIN_MI).setPace("12:08")
                .setHowIfelt(HowIfelt.GREAT).setPerceivedEffort(PerceivedEffort.MAX_EFFORT).setPostWorkoutsNotes("Notes")
                .build();
        quickAddModal.fillformQuickAdd(quickAddFirstDay);
        calendarPage.clickAddWorkoutButton();
        headerNavigate.clickCalendarButton();
        calendarPage.clickPlusButton(Day.SECOND_DAY);
        calendarPage.clickQuickAddButton();
        calendarPage.waitAddWorkoutButton();
        QuickAdd quickAddSecondDay = QuickAdd.builder().setDate("03/2/2023").setTimeOfDay("03:21").setActivityType(ActivityType.RUN)
                .setWorkoutName("Alexey").setWorkoutDescription("Description").setDistanceInput("33.00")
                .setDistTypeHills(DistTypeHills.METERS).setDuration("4:56").setPaceType(PaceType.MIN_MI).setPace("12:08")
                .setHowIfelt(HowIfelt.GREAT).setPerceivedEffort(PerceivedEffort.MAX_EFFORT).setPostWorkoutsNotes("Notes")
                .build();
        quickAddModal.fillformQuickAdd(quickAddSecondDay);
        calendarPage.clickAddWorkoutButton();
    }
    @Description("Verify that user can choose data and get list with his activities during that time")
    @Test(groups = {"regression"}, retryAnalyzer = Retry.class)
    public void positivePrintWorkoutTest()  {
        headerNavigate.clickPrintWorkoutButton();
        printWorkoutsModal.openIframePrintWorkout();
        PrintWorkout printWorkoutValue = PrintWorkout.builder().setStartingData("3/1/2023").setEndingData("3/2/2023").build();
        printWorkoutsModal.fillForm(printWorkoutValue);
        printWorkoutsModal.clickSaveButtonPrint();
        printDetailsPage.switchBetweenTabs(1);
        printDetailsPage.isPrintDetailsPageIsPresent();
        Assert.assertEquals(printDetailsPage.getPrintWorkoutData(), printWorkoutValue);
        printDetailsPage.switchBetweenTabs(0);
        dashboardPage.waitUserIcon();
        Assert.assertTrue(dashboardPage.isUserIconPresent());
    }
}
