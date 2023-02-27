package tests;

import models.DailyVitals;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DailyVitalsTest extends BaseTest{
    @Test
    public void dailyVitalsTest(){
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        dashboardPage.moveToDailyVitalsMenu();
        dashboardPage.clickViewAndAddVitalsButton();
        Assert.assertTrue(dailyVitalsPage.isAddVitalsDisplayed());
        dailyVitalsPage.clickCustomViewButton();
        DailyVitals dailyVitals = DailyVitals.builder()
                .setStartDate("2/21/2023")
                .setEndDate("2/27/2023")
                .build();
        dailyVitalsPage.fillformDailyVitals(dailyVitals);
        dailyVitalsPage.clickViewButton();
        Assert.assertEquals(dailyVitalsPage.getLastDate(), dailyVitals.getEndDate());
        Assert.assertEquals(dailyVitalsPage.getFirstDate(),dailyVitals.getStartDate());
    }
}
