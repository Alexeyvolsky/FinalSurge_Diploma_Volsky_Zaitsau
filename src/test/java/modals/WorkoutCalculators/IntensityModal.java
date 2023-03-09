package modals.WorkoutCalculators;

import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.BaseModal;
import models.WorcoutCalculators.IntensityCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
@Log4j2
public class IntensityModal extends BaseModal {

    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected final static String GREEN_BOX = "//h4[text()='Your Workout Paces']";

    @Step("Filling form to intensity calculator")
    public void fillForm(IntensityCalculator intensity)  {
        new RadioButton(driver).clickRadiobutton("EventType", intensity.getSelectEvent().getName());
        new Input(driver).setValue("TimeHH", intensity.getHours());
        new Input(driver).setValue("TimeMM", intensity.getMinutes());
        new Input(driver).setValue("TimeSS", intensity.getSeconds());
    }

    @Step("Click save button")
    public void clickFirstSaveButtonSettings()   {
        log.info("clicking save button");
        driver.findElement(FIRST_SAVE_BUTTON_SETTINGS).click();
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

    public IntensityModal(WebDriver driver) {
        super(driver);
    }
}