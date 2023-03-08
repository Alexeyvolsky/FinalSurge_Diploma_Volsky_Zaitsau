package tests;

import io.qameta.allure.Description;
import models.PaymentData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
    @Test(groups = {"negative","regression"}, retryAnalyzer = Retry.class)
    public void negativeBuyAPlanTest(){
        dashboardPage.moveToTrainingPlansMenu();
        dashboardPage.clickFindAPlanButton();
        trainingPlansPage.waitTrainingTypesImage();
        Assert.assertTrue(trainingPlansPage.isTrainingTypesImagePresent());
        trainingPlansPage.clickTrainingPlan();
        coachPage.waitForContinueButtonVisible();
        Assert.assertTrue(coachPage.isContinueCheckoutButtonPresent());
        coachPage.clickContinueCheckoutButton();
        coachPage.clickLoginButton();
        coachPage.login(USERNAME, PASSWORD);
        checkoutPage.waitForElementDisplayed();
        PaymentData paymentData = PaymentData.builder()
                .setCardNumber(CARD_NUMBER)
                .setExpiryDate(EXPIRY_DATE)
                .setCvcCode(CVC).build();
        checkoutPage.fillformCheckout(paymentData);
        checkoutPage.clickPayButton();
        checkoutPage.waitForPayButtonIsClickable();
        checkoutPage.clickPayButton();
        checkoutPage.waitForErrorMessageVisible();
        Assert.assertTrue(checkoutPage.isCardNumberInvalid());
    }
}
