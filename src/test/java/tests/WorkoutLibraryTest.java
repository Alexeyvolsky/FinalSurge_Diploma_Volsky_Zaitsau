package tests;

import enums.ActivityType;
import enums.DistTypeHills;
import models.WorkoutLibrary;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkoutLibraryTest extends BaseTest{
    @Test
    public void workoutLibraryTest() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        dashboardPage.moveToWorkoutsMenu();
        dashboardPage.clickWorkoutsButton("Workout Library");
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
