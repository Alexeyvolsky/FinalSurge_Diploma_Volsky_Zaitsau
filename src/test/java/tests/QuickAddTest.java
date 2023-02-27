package tests;

import enums.*;
import modals.QuickAddModal;
import models.QuickAdd;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class QuickAddTest extends BaseTest{

    @Test
    public void workoutLibraryTest() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickCalendarButton();
        calendarPage.clickPlusButton();
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
