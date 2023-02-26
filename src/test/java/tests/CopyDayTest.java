package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CopyDayTest extends BaseTest   {
// TODO: pre-condition Quick Add
    @BeforeMethod
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
    }

    @Test
    public void copyDayTest()   {
        headerNavigate.clickCalendarButton();
        calendarPage.clickPlusButton();
        calendarPage.clickCopyDayButton();
        calendarPage.clickNeedData();
        headerNavigate.waitSettingButtonPresent();
        Assert.assertEquals(calendarPage.getActivityName(), calendarPage.getExpectedActivityName());
    }
}