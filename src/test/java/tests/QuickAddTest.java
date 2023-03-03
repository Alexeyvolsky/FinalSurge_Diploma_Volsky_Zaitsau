package tests;

import enums.*;
import io.qameta.allure.Description;
import models.QuickAdd;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QuickAddTest extends BaseTest{

    @Description("Verify that user can make quick add activity")
    @Test
    public void workoutLibraryTest() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickCalendarButton();
        calendarPage.clickPlusButton(Day.TEN_DAY);
        calendarPage.clickQuickAddButton();
        Assert.assertFalse(calendarPage.isActivityPresent());
        QuickAdd quickAdd = QuickAdd.builder()
                .setDate("02/10/2023")
                .setTimeOfDay("03:21")
                .setActivityType(ActivityType.RUN)
                .setWorkoutName("Alexey")
                .setWorkoutDescription("Description")
                .setDistanceInput("33.00")
                .setDistTypeHills(DistTypeHills.METERS)
                .setDuration("4:56")
                .setPaceType(PaceType.MIN_MI)
                .setPace("12:08")
                .setHowIfelt(HowIfelt.GREAT)
                .setPerceivedEffort(PerceivedEffort.MAX_EFFORT)
                .setPostWorkoutsNotes("Notes")
                .build();
        quickAddModal.fillformQuickAdd(quickAdd);
        calendarPage.clickAddWorkoutButton();
        Assert.assertTrue(calendarPage.isActivityPresent());
    }
}
