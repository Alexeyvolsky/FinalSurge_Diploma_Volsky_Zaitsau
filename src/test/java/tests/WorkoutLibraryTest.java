package tests;

import enums.ActivityType;
import enums.DistTypeHills;
import io.qameta.allure.Description;
import models.WorkoutLibrary;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

public class WorkoutLibraryTest extends BaseTest    {

    @Description("Verify that user can add new workout to library")
    @Test(groups = {"regression"}, retryAnalyzer = Retry.class)
    public void workoutLibraryTest() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        dashboardPage.moveToWorkoutsMenu();
        dashboardPage.clickWorkoutsLibraryButton();
        Assert.assertTrue(workoutLibraryPage.addWorkoutButtonPresent());
        WorkoutLibrary workoutLibrary = WorkoutLibrary.builder()
                .setActivityType(ActivityType.RUN)
                .setWorkoutName("Name")
                .setWorkoutDescription("Description")
                .setPlannedDistanceInput("100")
                .setDistTypeHills(DistTypeHills.METERS)
                .setPlannedDuration("4:57")
                .build();
        workoutLibraryPage.fillformLibrary(workoutLibrary);
        workoutLibraryPage.clickAddWorkoutButton();
        workoutLibraryPage.clickRunButton();
        Assert.assertEquals(workoutLibrary, workoutLibraryPage.getWorkoutLibraryDetails());
    }
}
