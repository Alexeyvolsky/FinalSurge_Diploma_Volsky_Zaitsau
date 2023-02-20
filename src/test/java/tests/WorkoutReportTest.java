package tests;

import enums.ActivityType;
import enums.ReportView;
import models.Report;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkoutReportTest extends BaseTest{

    @Test
    public void workoutReportTest(){
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        dashboardPage.moveToWorkoutsMenu();
        dashboardPage.clickWorkoutsButton("Reports & Statistics");
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
