package modals.WorkoutCalculators;

import elements.Dropdown;
import elements.Input;
import elements.RadioButton;
import modals.BaseModal;
import models.WorcoutCalculators.TinmanCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TinmanModal extends BaseModal {

    protected final static By LOCATOR_IFRAME_WORKOUT_CALCULATOR = By.id("IntensityCalciFrame");
    protected final static By TINMAN_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='Tinman']");
    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected String GREEN_BOX = "//h4[text()='Race Information']";

    public void fillForm(TinmanCalculator tinman)  {
        new Dropdown(driver).selectOption("distance", tinman.getDistanceTinman().getName());
        new Input(driver).setValue("TimeHH", tinman.getHours());
        new Input(driver).setValue("TimeMM", tinman.getMinutes());
        new Input(driver).setValue("TimeSS", tinman.getSeconds());
        new RadioButton(driver).clickRadiobutton("Gender", tinman.getGender().getAnotherValue());
    }

    public void openIframeWorkoutCalculator()   {
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_WORKOUT_CALCULATOR);
        driver.switchTo().frame(iframe);
    }

    public void clickTinmanCalculatorButton() {
        driver.findElement(TINMAN_CALCULATOR_BUTTON_LOCATOR).click();
    }

    public void clickFirstSaveButtonSettings()   {
        driver.findElement(FIRST_SAVE_BUTTON_SETTINGS).click();
    }

    public boolean isGreenBoxDisplay()  {
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
