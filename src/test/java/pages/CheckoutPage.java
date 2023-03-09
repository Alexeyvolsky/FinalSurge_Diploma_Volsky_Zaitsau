package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PaymentData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutPage extends BasePage{
    private final static By CHECKOUT_ERROR_MESSAGE = By.xpath("//div[contains(@class, 'alert__text')]");
    private final static By CARD_NUMBER_IFRAME = By.xpath("//div[@stripetype='cardNumber']//descendant::iframe");
    private final static By CARD_NUMBER_INPUT = By.xpath("//span[@class]/input[@name='cardnumber']");
    private final static By EXP_DATE_IFRAME = By.xpath("//div[@stripetype='cardExpiry']//descendant::iframe");
    private final static By EXPIRY_DATE = By.xpath("//span[@class]/input[@name='exp-date']");
    private final static By CVC_IFRAME = By.xpath("//div//iframe[contains(@title,'CVC')]");
    private final static By CVC_CODE = By.xpath("//span[@class]/input[@name='cvc']");
    private final static By PAY_BUTTON = By.xpath("//div[contains(@class,'action-button')]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void waitForElementDisplayed() {
        log.debug("waiting for error message to appear on the screen");
        waitForElementDisplayed(CHECKOUT_ERROR_MESSAGE);
    }
    @Step ("Clicking button 'Pay'")
    public void clickPayButton(){
        log.info("clicking button 'Pay'");
        driver.findElement(PAY_BUTTON).click();
    }

    public void waitForPayButtonIsClickable() {
        log.debug("waiting until pay button is clickable");
        waitForElementDisplayed(PAY_BUTTON);
    }

    @Step("Filling form to hills workout modal")
    public void fillformCheckout(PaymentData paymentData){
        driver.switchTo().frame(driver.findElement(CARD_NUMBER_IFRAME));
        driver.findElement(CARD_NUMBER_INPUT).sendKeys(paymentData.getCardNumber());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(EXP_DATE_IFRAME));
        driver.findElement(EXPIRY_DATE).sendKeys(paymentData.getExpiryDate());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(CVC_IFRAME));
        driver.findElement(CVC_CODE).sendKeys(paymentData.getCvcCode());
        driver.switchTo().defaultContent();
    }

    public boolean isCardNumberInvalid (){
        log.debug("checking if card number is valid");
        return driver.findElement(CHECKOUT_ERROR_MESSAGE).isDisplayed();
    }

    public void waitForErrorMessageVisible(){
        log.debug("waiting until error message is visible");
        waitForElementDisplayed(CHECKOUT_ERROR_MESSAGE);
    }
}
