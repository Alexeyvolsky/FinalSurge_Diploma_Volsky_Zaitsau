package modals.WorkoutCalculators;

import elements.Input;
import modals.BaseModal;
import models.WorcoutCalculators.PalladinoCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PalladinoModal extends BaseModal {

    protected final static By LOCATOR_IFRAME_WORKOUT_CALCULATOR = By.id("IntensityCalciFrame");
    protected final static By PALLADINO_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='Palladino']");
    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected final static By SECOND_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings2");
    protected final static By THIRD_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings3");
    protected final static By FOURTH_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings4");
    protected String GREEN_BOX = "//h4[text()='%s']";

    public void fillFormCalculateIntervalPowerTarget(PalladinoCalculator palladino) {
        new Input(driver).setValue("CP", palladino.getCriticalPower());
        new Input(driver).setValue("RWC", palladino.getReserveWorkCapacity());
    }

    public void fillFormCpAndRwcFromACpTest(PalladinoCalculator palladino)   {
        new Input(driver).setValue("TimeMM", palladino.getMinutes());
        new Input(driver).setValue("TimeSS", palladino.getSeconds());
        new Input(driver).setValue("AVPWS", palladino.getShortTest());
        new Input(driver).setValue("TimeMML", palladino.getMinutes());
        new Input(driver).setValue("TimeSSL", palladino.getSeconds());
        new Input(driver).setValue("AVPWL", palladino.getLongTest());
    }

    public void fillFormCpFromRaceOrTtMoreThenForty(PalladinoCalculator palladino)    {
        new Input(driver).setValue("TimeHHR", palladino.getHours());
        new Input(driver).setValue("TimeMMR", palladino.getMinutes());
        new Input(driver).setValue("TimeSSR", palladino.getSeconds());
        new Input(driver).setValue("RAP", palladino.getRaceAvgPower());
    }

    public void fillFormCpFromRaceOrTtLessThenForty(PalladinoCalculator palladino)   {
        new Input(driver).setValue("TimeMMRR", palladino.getMinutes());
        new Input(driver).setValue("TimeSSRR", palladino.getSeconds());
        new Input(driver).setValue("RAPR", palladino.getRaceAvgPower());
    }

    public void openIframeWorkoutCalculator()   {
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_WORKOUT_CALCULATOR);
        driver.switchTo().frame(iframe);
    }

    public void clickPalladinoCalculatorButton()  {
        driver.findElement(PALLADINO_CALCULATOR_BUTTON_LOCATOR).click();
    }

    public void clickFirstSaveButtonSettings()   {
        driver.findElement(FIRST_SAVE_BUTTON_SETTINGS).click();
    }

    public void clickSecondSaveButtonSettings()  {
        driver.findElement(SECOND_SAVE_BUTTON_SETTINGS).click();
    }

    public void clickThirdSaveButtonSettings()  {
        driver.findElement(THIRD_SAVE_BUTTON_SETTINGS).click();
    }

    public void clickFourthSaveButtonSettings()  {
        driver.findElement(FOURTH_SAVE_BUTTON_SETTINGS).click();
    }

    public boolean isGreenBoxIntervalPowerDisplay()  {
        try {
            driver.findElement(By.xpath(String.format(GREEN_BOX, "Interval Power Targets"))).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public boolean isGreenBoxMoreThenFortyDisplay()  {
        try {
            driver.findElement(By.xpath(String.format(GREEN_BOX, "Estimate Results"))).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public boolean isGreenBoxLessThenFortyDisplay()  {
        try {
            driver.findElement(By.xpath(String.format(GREEN_BOX, "Estimate Results"))).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public boolean isGreenBoxCpAndRwcDisplay()  {
        try {
            driver.findElement(By.xpath(String.format(GREEN_BOX, "Estimate Results"))).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public PalladinoModal(WebDriver driver) {
        super(driver);
    }
}
