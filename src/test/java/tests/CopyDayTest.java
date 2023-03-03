package tests;

import enums.*;
import io.qameta.allure.Description;
import models.PrintWorkout;
import models.QuickAdd;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CopyDayTest extends BaseTest   {

    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.clickCalendarButton();
        calendarPage.clickPlusButton(Day.TEN_DAY);
        calendarPage.clickQuickAddButton();
        QuickAdd quickAdd = QuickAdd.builder().setDate("02/10/2023").setTimeOfDay("03:21").setActivityType(ActivityType.RUN)
                .setWorkoutName("Alexey").setWorkoutDescription("Description").setDistanceInput("33.00")
                .setDistTypeHills(DistTypeHills.METERS).setDuration("4:56").setPaceType(PaceType.MIN_MI).setPace("12:08")
                .setHowIfelt(HowIfelt.GREAT).setPerceivedEffort(PerceivedEffort.MAX_EFFORT)
                .setPostWorkoutsNotes("Notes").build();
        quickAddModal.fillformQuickAdd(quickAdd);
        calendarPage.clickAddWorkoutButton();
    }

    @Description("Verify that user can make copy his activity in another day")
    @Test(groups = {"regression"})
    public void copyDayTest()   {
        headerNavigate.clickCalendarButton();
        calendarPage.clickPlusButton(Day.TEN_DAY);
        calendarPage.clickCopyDayButton();
        calendarPage.clickNeedData(Day.ELEVEN_DAY);
        headerNavigate.waitSettingButtonPresent();
        Assert.assertEquals(calendarPage.getActivityForTheTenthDay(), calendarPage.getActivityForTheEleventhDay());
    }
}
