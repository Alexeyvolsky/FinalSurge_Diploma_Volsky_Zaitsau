package tests;

import enums.ActivityType;
import enums.ReportView;
import io.qameta.allure.Description;
import models.Report;
import models.Rest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Retry;

public class WorkoutReportTest extends BaseTest{

    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        dashboardPage.moveToWorkoutsMenu();
        dashboardPage.clickWorkoutsButton();
        workoutsPage.clickActiveTypeButtonRest();
        Rest workoutValue = Rest.builder().setWorkoutDescription("Workout description")
                .setWorkoutName("Workouts name")
                .setDate("02/23/2023")
                .build();
        addNewWorkoutModal.fillformRest(workoutValue);
        addNewWorkoutModal.clickAddWorkoutButton();
    }
    @Description("Verify thet user can get report on workouts of the selected type for the selected period")
    @Test(groups = {"regression"}, retryAnalyzer = Retry.class)
    public void workoutReportTest(){
        dashboardPage.moveToWorkoutsMenu();
        dashboardPage.clickWorkoutsReportButton();
        Assert.assertTrue(workoutReportPage.reportButtonPresent());
        Report reportView = Report.builder()
                .setStartDate("2/23/2023")
                .setEndDate("2/23/2023")
                .setReportView(ReportView.LIST_VIEW)
                .setActivityType(ActivityType.REST_DAY)
                .build();
        workoutReportPage.fillformReportView(reportView);
        workoutReportPage.clickReportButton();
        Assert.assertEquals(workoutReportPage.getActivityFromTable(),reportView.getActivityType().getName());
    }
}
