package modals.WorkoutCalculators;

import elements.Dropdown;
import elements.Input;
import modals.BaseModal;
import models.WorcoutCalculators.HansonsCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HansonsModal extends BaseModal {

    protected final static By LOCATOR_IFRAME_WORKOUT_CALCULATOR = By.id("IntensityCalciFrame");
    protected final static By HANSONS_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='Hansons']");
    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected String GREEN_BOX = "//h4[text()='Recent Race Information']";
    public void fillForm(HansonsCalculator hansons) {
        new Dropdown(driver).selectOption("RaceDist", hansons.getRaceDist().getName());
        new Dropdown(driver).selectOption("DistType", hansons.getDistTypeHansons().getName());
        new Input(driver).setValue("TimeHH", hansons.getHours());
        new Input(driver).setValue("TimeMM", hansons.getMinutes());
        new Input(driver).setValue("TimeSS", hansons.getSeconds());
        new Input(driver).setValue("Temp", hansons.getTemperature());
        new Input(driver).setValue("Wind", hansons.getWindSpeed());
        new Dropdown(driver).selectOption("TempType", hansons.getTempType().getName());
        new Dropdown(driver).selectOption("SpeedType", hansons.getSpeedType().getName());
        new Input(driver).setValue("Humid", hansons.getHumidity());
    }

    public void clickHansonsCalculatorButton()  {
        driver.findElement(HANSONS_CALCULATOR_BUTTON_LOCATOR).click();
    }

    public void clickFirstSaveButtonSettings()   {
        driver.findElement(FIRST_SAVE_BUTTON_SETTINGS).click();
    }

    public void openIframeWorkoutCalculator()   {
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_WORKOUT_CALCULATOR);
        driver.switchTo().frame(iframe);
    }

    public boolean isGreenBoxDisplay()  {
        try {
            driver.findElement(By.xpath(GREEN_BOX)).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public HansonsModal(WebDriver driver) {
        super(driver);
    }
}
