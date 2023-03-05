package tests;

import enums.*;
import io.qameta.allure.Description;
import models.Checkout;
import models.QuickAdd;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Retry;

public class BuyAPlanTest extends BaseTest{
    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
    }
    @Description("Choosing a training plan and trying to pay for it")
    @Test(groups = {"regression"}, retryAnalyzer = Retry.class)
    public void negativeBuyAPlanTest(){
        dashboardPage.moveToTrainingPlansMenu();
        dashboardPage.clickFindAPlanButton();
        Assert.assertTrue(trainingPlansPage.isTrainingTypesImagePresent());
        trainingPlansPage.clickTrainingPlan();
        coachPage.waitForContinueButtonVisible();
        Assert.assertTrue(coachPage.isContinueCheckoutButtonPresent());
        coachPage.clickContinueCheckoutButton();
        coachPage.clickLoginButton();
        coachPage.login(USERNAME, PASSWORD);
        checkoutPage.waitForElementDisplayed();
        Checkout checkout = Checkout.builder()
                .setCardNumber(CARD_NUMBER)
                .setExpiryDate(EXPIRY_DATE)
                .setCvcCode(CVC).build();
        checkoutPage.fillformCheckout(checkout);
        checkoutPage.clickPayButton();
        checkoutPage.waitForPayButtonIsClickable();
        checkoutPage.clickPayButton();
        checkoutPage.waitForErrorMessageVisible();
        Assert.assertTrue(checkoutPage.isCardNumberInvalid());
    }
}
