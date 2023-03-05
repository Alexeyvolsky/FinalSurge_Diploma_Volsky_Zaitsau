package modals.WorkoutCalculators;

import elements.Dropdown;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.BaseModal;
import models.WorcoutCalculators.TinmanCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Log4j2
public class TinmanModal extends BaseModal {

    protected final static By LOCATOR_IFRAME_WORKOUT_CALCULATOR = By.id("IntensityCalciFrame");
    protected final static By TINMAN_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='Tinman']");
    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected String GREEN_BOX = "//h4[text()='Race Information']";

    @Step("Filling form to tinman calculator")
    public void fillForm(TinmanCalculator tinman)  {
        new Dropdown(driver).selectOption("distance", tinman.getDistanceTinman().getName());
        new Input(driver).setValue("TimeHH", tinman.getHours());
        new Input(driver).setValue("TimeMM", tinman.getMinutes());
        new Input(driver).setValue("TimeSS", tinman.getSeconds());
        new RadioButton(driver).clickRadiobutton("Gender", tinman.getGender().getAnotherValue());
    }

    @Step("Open iframe for modal workout calculator")
    public void openIframeWorkoutCalculator()   {
        log.info("opening iframe for modal workout calculator");
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_WORKOUT_CALCULATOR);
        driver.switchTo().frame(iframe);
    }

    @Step("Click Tinman calculator button")
    public void clickTinmanCalculatorButton() {
        log.info("clicking tinman calculator button");
        driver.findElement(TINMAN_CALCULATOR_BUTTON_LOCATOR).click();
    }

    @Step("Click save button")
    public void clickFirstSaveButtonSettings()   {
        log.info("clicking save button");
        driver.findElement(FIRST_SAVE_BUTTON_SETTINGS).click();
    }

    @Step("Verify that green box is display")
    public boolean isGreenBoxDisplay()  {
        log.info("verifying that green box is display");
        try {
            driver.findElement(By.xpath(GREEN_BOX)).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public TinmanModal(WebDriver driver) {
        super(driver);
    }
}
