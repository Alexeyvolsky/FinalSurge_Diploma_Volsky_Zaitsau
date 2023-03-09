package modals.OtherCalculators;

import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.BaseModal;
import models.OtherCalculators.PaceCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
@Log4j2
public class PaceModal extends BaseModal {

    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected final static By PACE_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='Pace Calculator']");
    protected final static String GREEN_BOX = "//h4[text()='Pace Chart']";
    protected final static By ALERT_ERROR_MESSAGE = By.cssSelector(".alert");

    @Step("Filling form to pace calculator")
    public void fillForm(PaceCalculator paceCalculator) {
        new Input(driver).clearAndSetValue("RunDist", paceCalculator.getRunDistance());
        new Dropdown(driver).selectOptionByValue("DistType", paceCalculator.getDistTypePaceCalculator().getName());
        new Input(driver).clearAndSetValue("TimeHH", paceCalculator.getHours());
        new Input(driver).clearAndSetValue("TimeMM", paceCalculator.getMinutes());
        new Input(driver).clearAndSetValue("TimeSS", paceCalculator.getSeconds());
    }

    @Step("Click save button")
    public void clickFirstSaveButtonSettings()   {
        log.info("clicking save button");
        driver.findElement(FIRST_SAVE_BUTTON_SETTINGS).click();
    }

    @Step("Click pace calculator button")
    public void clickPaceCalculatorButton() {
        log.info("clicking pace calculator button");
        try {
            driver.findElement(PACE_CALCULATOR_BUTTON_LOCATOR).click();
        } catch (NoSuchElementException ex) {
        }
    }

    public boolean isGreenBoxDisplay()  {
        log.debug("verifying that green box is display");
        try {
            driver.findElement(By.xpath(GREEN_BOX)).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public boolean alertErrorMessageIsPresent()    {
        log.debug("verifying that alert error message is display");
        try {
            driver.findElement(ALERT_ERROR_MESSAGE).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public PaceModal(WebDriver driver) {
        super(driver);
        this.LOCATOR_IFRAME = By.id("OtherCalciFrame");
    }
}
