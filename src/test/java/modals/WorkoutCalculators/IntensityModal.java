package modals.WorkoutCalculators;

import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import modals.BaseModal;
import models.WorcoutCalculators.IntensityCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IntensityModal extends BaseModal {

    protected final static By LOCATOR_IFRAME_WORKOUT_CALCULATOR = By.id("IntensityCalciFrame");
    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected String GREEN_BOX = "//h4[text()='Your Workout Paces']";

    @Step("Filling form to intensity calculator")
    public void fillForm(IntensityCalculator intensity)  {
        new RadioButton(driver).clickRadiobutton("EventType", intensity.getSelectEvent().getName());
        new Input(driver).setValue("TimeHH", intensity.getHours());
        new Input(driver).setValue("TimeMM", intensity.getMinutes());
        new Input(driver).setValue("TimeSS", intensity.getSeconds());
    }

    @Step("Open iframe for modal workout calculator")
    public void openIframeWorkoutCalculator()   {
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_WORKOUT_CALCULATOR);
        driver.switchTo().frame(iframe);
    }

    @Step("Click save button")
    public void clickFirstSaveButtonSettings()   {
        driver.findElement(FIRST_SAVE_BUTTON_SETTINGS).click();
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

    public IntensityModal(WebDriver driver) {
        super(driver);
    }
}