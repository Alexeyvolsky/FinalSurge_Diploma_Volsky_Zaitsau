package modals.WorkoutCalculators;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.BaseModal;
import models.WorcoutCalculators.PalladinoCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Log4j2
public class PalladinoModal extends BaseModal {

    protected final static By LOCATOR_IFRAME_WORKOUT_CALCULATOR = By.id("IntensityCalciFrame");
    protected final static By PALLADINO_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='Palladino']");
    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected final static By SECOND_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings2");
    protected final static By THIRD_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings3");
    protected final static By FOURTH_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings4");
    protected String GREEN_BOX = "//h4[text()='%s']";

    @Step("Filling form to IntervalPower calculator")
    public void fillFormCalculateIntervalPowerTarget(PalladinoCalculator palladino) {
        new Input(driver).setValue("CP", palladino.getCriticalPower());
        new Input(driver).setValue("RWC", palladino.getReserveWorkCapacity());
    }

    @Step("Filling form to CpAndRwcFromACp calculator")
    public void fillFormCpAndRwcFromACpTest(PalladinoCalculator palladino)   {
        new Input(driver).setValue("TimeMM", palladino.getMinutes());
        new Input(driver).setValue("TimeSS", palladino.getSeconds());
        new Input(driver).setValue("AVPWS", palladino.getShortTest());
        new Input(driver).setValue("TimeMML", palladino.getMinutes());
        new Input(driver).setValue("TimeSSL", palladino.getSeconds());
        new Input(driver).setValue("AVPWL", palladino.getLongTest());
    }

    @Step("Filling form to CpFromRaceOrTtMoreThenForty calculator")
    public void fillFormCpFromRaceOrTtMoreThenForty(PalladinoCalculator palladino)    {
        new Input(driver).setValue("TimeHHR", palladino.getHours());
        new Input(driver).setValue("TimeMMR", palladino.getMinutes());
        new Input(driver).setValue("TimeSSR", palladino.getSeconds());
        new Input(driver).setValue("RAP", palladino.getRaceAvgPower());
    }

    @Step("Filling form to CpFromRaceOrTtLessThenForty calculator")
    public void fillFormCpFromRaceOrTtLessThenForty(PalladinoCalculator palladino)   {
        new Input(driver).setValue("TimeMMRR", palladino.getMinutes());
        new Input(driver).setValue("TimeSSRR", palladino.getSeconds());
        new Input(driver).setValue("RAPR", palladino.getRaceAvgPower());
    }

    @Step("Open iframe for modal workout calculator")
    public void openIframeWorkoutCalculator()   {
        log.info("opening iframe for modal workout calculator");
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_WORKOUT_CALCULATOR);
        driver.switchTo().frame(iframe);
    }

    @Step("Click Pallandino calculator button")
    public void clickPalladinoCalculatorButton()  {
        log.info("clicking palladino calculator button");
        driver.findElement(PALLADINO_CALCULATOR_BUTTON_LOCATOR).click();
    }

    @Step("Click first save button")
    public void clickFirstSaveButtonSettings()   {
        log.info("clicking first save button");
        driver.findElement(FIRST_SAVE_BUTTON_SETTINGS).click();
    }

    @Step("Click second save button")
    public void clickSecondSaveButtonSettings()  {
        log.info("clicking second save button");
        driver.findElement(SECOND_SAVE_BUTTON_SETTINGS).click();
    }

    @Step("Click third save button")
    public void clickThirdSaveButtonSettings()  {
        log.info("clicking third save button");
        driver.findElement(THIRD_SAVE_BUTTON_SETTINGS).click();
    }

    @Step("Click fourth save button")
    public void clickFourthSaveButtonSettings()  {
        log.info("clicking fourth save button");
        driver.findElement(FOURTH_SAVE_BUTTON_SETTINGS).click();
    }

    @Step("Verify that green box in IntervalPower calculator is display")
    public boolean isGreenBoxIntervalPowerDisplay()  {
        log.info("verifying that green box in IntervalPower is display");
        try {
            driver.findElement(By.xpath(String.format(GREEN_BOX, "Interval Power Targets"))).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Verify that green box in MoreThenForty calculator is display")
    public boolean isGreenBoxMoreThenFortyDisplay()  {
        log.info("verifying that green box in MoreThenForty calculator is display");
        try {
            driver.findElement(By.xpath(String.format(GREEN_BOX, "Estimate Results"))).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Verify that green box in LessThenForty calculator is display")
    public boolean isGreenBoxLessThenFortyDisplay()  {
        log.info("verifying that green box in LessThenForty calculator is display");
        try {
            driver.findElement(By.xpath(String.format(GREEN_BOX, "Estimate Results"))).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Verify that green box in CpAndRwc calculator is display")
    public boolean isGreenBoxCpAndRwcDisplay()  {
        log.info("verifying that green box in CpAndRwc calculator is display");
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
