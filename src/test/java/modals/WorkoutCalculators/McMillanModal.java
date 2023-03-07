package modals.WorkoutCalculators;

import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.BaseModal;
import models.WorcoutCalculators.McMillanCalculator;
import org.openqa.selenium.*;

@Log4j2
public class McMillanModal extends BaseModal {

    protected final static By LOCATOR_IFRAME_WORKOUT_CALCULATOR = By.id("IntensityCalciFrame");
    protected final static By MCMILLAN_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='McMillan']");
    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected final static String GREEN_BOX = "//h4[text()='Goal Race Times']";

    @Step("Filling form to McMillan calculator")
    public void fillForm(McMillanCalculator mcMillan)   {
        new Dropdown(driver).selectOptionByValue("distance", mcMillan.getDistanceMcMillan().getName());
        new Input(driver).setValue("TimeHH", mcMillan.getHours());
        new Input(driver).setValue("TimeMM", mcMillan.getMinutes());
        new Input(driver).setValue("TimeSS", mcMillan.getSeconds());
        new Dropdown(driver).selectOptionByValue("goaldistance", mcMillan.getDistanceMcMillan().getName());
        new Input(driver).setValue("GTimeHH", mcMillan.getHours());
        new Input(driver).setValue("GTimeMM", mcMillan.getMinutes());
        new Input(driver).setValue("GTimeSS", mcMillan.getSeconds());
    }

    @Step("Open iframe for modal workout calculator")
    public void openIframeWorkoutCalculator()   {
        log.debug("opening iframe for modal workout calculator");
        openIframe(LOCATOR_IFRAME_WORKOUT_CALCULATOR);
    }

    @Step("Click McMilan calculator button")
    public void clickMcMilanCalculatorButton()    {
        log.info("clicking mcmilan calculator button");
        driver.findElement(MCMILLAN_CALCULATOR_BUTTON_LOCATOR).click();
    }

    @Step("Click save button")
    public void clickFirstSaveButtonSettings()   {
        log.info("clicking save button");
        scrollIntoView(driver.findElement(FIRST_SAVE_BUTTON_SETTINGS));
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

    public void waitSaveButton()    {
        log.debug("waiting for save button is loaded");
        waitForElementDisplayed(FIRST_SAVE_BUTTON_SETTINGS);
    }

    public McMillanModal(WebDriver driver) {
        super(driver);
    }
}
