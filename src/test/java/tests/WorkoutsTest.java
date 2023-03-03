package tests;

import enums.DistTypeHills;
import enums.HowIfelt;
import enums.PaceType;
import enums.PerceivedEffort;
import io.qameta.allure.Description;
import models.Hills;
import models.Rest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkoutsTest extends BaseTest  {

    @Description("Verify that user can add rest day")
    @Test(groups = {"smoke"})
    public void addRestdayTest() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(dashboardPage.isUserIconPresent());
        dashboardPage.moveToWorkoutsMenu();
        dashboardPage.clickWorkoutsButton("Add Workout");
        Assert.assertTrue(workoutsPage.isSidebarPresent());
        workoutsPage.clickActiveTypeButton("rest");
        Rest workoutValue = Rest.builder().setWorkoutDescription("Workout description")
                .setWorkoutName("Workouts name")
                .setDate("02/23/2023")
                .build();
        addNewWorkoutModal.fillformRest(workoutValue);
        addNewWorkoutModal.clickAddWorkoutButton();
        Assert.assertTrue(workoutDetailsPage.isViewYourWorkoutPresent());
        Assert.assertEquals(workoutValue,workoutDetailsPage.getWorkoutDetailsRest());
    }

    @Description("Verify that user can add run hills activity")
    @Test(groups = {"smoke"})
    public void addRunHillsTest(){
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(dashboardPage.isUserIconPresent());
        dashboardPage.moveToWorkoutsMenu();
        dashboardPage.clickWorkoutsButton("Add Workout");
        Assert.assertTrue(workoutsPage.isSidebarPresent());
        workoutsPage.clickActiveTypeButton("run");
        workoutsPage.clickAccordingInnerButton("Hills");
        Hills workoutValue = Hills.builder()
                .setDate("02/23/2023")
                .setTimeOfDay("03:15")
                .setWorkoutName("Alexey")
                .setWorkoutDescription("Description")
                .setDistanceInput("33.00")
                .setDistTypeHills(DistTypeHills.MILES)
                .setDuration("4:56")
                .setPace("0:08")
                .setPaceType(PaceType.MIN_MI)
                .setHowIfelt(HowIfelt.GREAT)
                .setPerceivedEffort(PerceivedEffort.MAX_EFFORT)
                .setMinHr("1")
                .setAvgHr("1")
                .setMaxHr("1")
                .setCaloriesBurned("300")
                .build();
        addNewWorkoutModal.fillformHills(workoutValue);
        addNewWorkoutModal.clickAddWorkoutButton();
        Assert.assertTrue(workoutDetailsPage.isViewYourWorkoutPresent());
        Assert.assertEquals(workoutValue,workoutDetailsPage.getWorkoutDetailsHills());

    }
}
