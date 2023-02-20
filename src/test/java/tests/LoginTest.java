package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void positiveLoginTest() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(dashboardPage.isUserIconPresent());
    }
    @Test(dataProvider = "negativeLoginTestData")
    public void negativeLoginTest(String email, String password){
        loginPage.setEmailInput(email);
        loginPage.setPasswordInput(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginButtonPresent());
    }
    @DataProvider
    public Object[][] negativeLoginTestData(){
        return new Object[][]{
                {" ", " "},
                {" ", PASSWORD},
                {USERNAME," "},
                {"qwe@google.com", PASSWORD},
                {USERNAME,"1234567890"},
                {"qwe@google.com", "1234567890"}
        };
    }
    @Test
    public void logoutTest(){
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(dashboardPage.isUserIconPresent());
        dashboardPage.clickLogoutButton();
        Assert.assertTrue(loginPage.logoutMessagePresent());

    }
}
