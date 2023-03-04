package modals.WorkoutCalculators;

import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import modals.BaseModal;
import models.WorcoutCalculators.McMillanCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class McMillanModal extends BaseModal {

    protected final static By LOCATOR_IFRAME_WORKOUT_CALCULATOR = By.id("IntensityCalciFrame");
    protected final static By MCMILLAN_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='McMillan']");
    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected String GREEN_BOX = "//h4[text()='Goal Race Times']";

    @Step("Filling form to McMillan calculator")
    public void fillForm(McMillanCalculator mcMillan)   {
        new Dropdown(driver).selectOption("distance", mcMillan.getDistanceMcMillan().getName());
        new Input(driver).setValue("TimeHH", mcMillan.getHours());
        new Input(driver).setValue("TimeMM", mcMillan.getMinutes());
        new Input(driver).setValue("TimeSS", mcMillan.getSeconds());
        new Dropdown(driver).selectOption("goaldistance", mcMillan.getDistanceMcMillan().getName());
        new Input(driver).setValue("GTimeHH", mcMillan.getHours());
        new Input(driver).setValue("GTimeMM", mcMillan.getMinutes());
        new Input(driver).setValue("GTimeSS", mcMillan.getSeconds());
    }

    @Step("Open iframe for modal workout calculator")
    public void openIframeWorkoutCalculator()   {
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_WORKOUT_CALCULATOR);
        driver.switchTo().frame(iframe);
    }

    @Step("Click McMilan calculator button")
    public void clickMcMilanCalculatorButton()    {
        driver.findElement(MCMILLAN_CALCULATOR_BUTTON_LOCATOR).click();
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

    public McMillanModal(WebDriver driver) {
        super(driver);
    }
}
