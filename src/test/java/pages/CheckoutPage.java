package pages;

import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Checkout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private final static  By LOCATOR = By.xpath("//input[@placeholder= 'Select a Country']");
    private final static String ELEMENT = "//div[@class= 'select-option__label') and contains(text(), '%s')]";
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @Step ("Wait for error message to appear on the screen '")
    public void waitForElementDisplayed() {
        log.info("waiting for error message to appear on the screen");
        waitForElementDisplayed(CHECKOUT_ERROR_MESSAGE);
    }
    @Step ("Clicking button 'Pay'")
    public void clickPayButton(){
        log.info("clicking button 'Pay'");
        driver.findElement(PAY_BUTTON).click();
    }
    @Step ("Waiting until pay button is clickable")
    public void waitForPayButtonIsClickable() {
        log.info("waiting until pay button is clickable");
        waitForElementDisplayed(PAY_BUTTON);
    }

    @Step("Filling form to hills workout modal")
    public void fillformCheckout(Checkout checkout){
        driver.switchTo().frame(driver.findElement(CARD_NUMBER_IFRAME));
        new Input(driver).setValueCountry(CARD_NUMBER_INPUT, checkout.getCardNumber());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(EXP_DATE_IFRAME));
        new Input(driver).setValueCountry(EXPIRY_DATE, checkout.getExpiryDate());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(CVC_IFRAME));
        new Input(driver).setValueCountry(CVC_CODE, checkout.getCvcCode());
        driver.switchTo().defaultContent();
    }
    @Step ("Checking if card number is valid")
    public boolean isCardNumberInvalid (){
        log.info("checking if card number is valid");
        return driver.findElement(CHECKOUT_ERROR_MESSAGE).isDisplayed();
    }

    @Step ("Waiting until error message is visible")
    public void waitForErrorMessageVisible(){
        log.info("waiting until error message is visible");
        waitForElementDisplayed(CHECKOUT_ERROR_MESSAGE);
    }
}
