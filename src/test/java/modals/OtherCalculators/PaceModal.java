package modals.OtherCalculators;

import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import modals.BaseModal;
import models.OtherCalculators.PaceCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaceModal extends BaseModal {

    protected final static By LOCATOR_IFRAME_OTHER_CALCULATOR = By.id("OtherCalciFrame");
    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected final static By PACE_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='Pace Calculator']");
    protected String GREEN_BOX = "//h4[text()='Pace Chart']";
    protected final static By ALERT_ERROR_MESSAGE = By.cssSelector(".alert");

    @Step("Filling form to pace calculator")
    public void fillForm(PaceCalculator paceCalculator) {
        new Input(driver).clearAndSetValue("RunDist", paceCalculator.getRunDistance());
        new Dropdown(driver).selectOption("DistType", paceCalculator.getDistTypePaceCalculator().getName());
        new Input(driver).clearAndSetValue("TimeHH", paceCalculator.getHours());
        new Input(driver).clearAndSetValue("TimeMM", paceCalculator.getMinutes());
        new Input(driver).clearAndSetValue("TimeSS", paceCalculator.getSeconds());
    }

    @Step("Open iframe for modal other calculator")
    public void openIframeOtherCalculator()    {
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_OTHER_CALCULATOR);
        driver.switchTo().frame(iframe);
    }

    @Step("Click save button")
    public void clickFirstSaveButtonSettings()   {
        driver.findElement(FIRST_SAVE_BUTTON_SETTINGS).click();
    }

    @Step("Click pace calculator button")
    public void clickPaceCalculatorButton() {
        try {
            driver.findElement(PACE_CALCULATOR_BUTTON_LOCATOR).click();
        } catch (NoSuchElementException ex) {
        }
    }

    @Step("Verify that green box is display")
    public boolean isGreenBoxDisplay()  {
        try {
            driver.findElement(By.xpath(GREEN_BOX)).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Verify that alert error message is display")
    public boolean alertErrorMessageIsPresent()    {
        try {
            driver.findElement(ALERT_ERROR_MESSAGE).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public PaceModal(WebDriver driver) {
        super(driver);
    }
}
