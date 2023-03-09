package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Retry;

public class LoginTest extends BaseTest {

    @Description("Verify that user can login on the site")
    @Test(groups = {"smoke"}, retryAnalyzer = Retry.class)
    public void positiveLoginTest() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(dashboardPage.isUserIconPresent());
    }

    @Description("Verify that login page work correct with bad data")
    @Test(dataProvider = "negativeLoginTestData", retryAnalyzer = Retry.class, groups = {"negative","regression"})
    public void negativeLoginTest(String email, String password){
        loginPage.setEmailInput(email);
        loginPage.setPasswordInput(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginButtonPresent());
    }

    @Description("Verify that user can make logout")
    @Test(groups = {"smoke"}, retryAnalyzer = Retry.class)
    public void logoutTest(){
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(dashboardPage.isUserIconPresent());
        dashboardPage.clickLogoutButton();
        Assert.assertTrue(loginPage.logoutMessagePresent());

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
}
