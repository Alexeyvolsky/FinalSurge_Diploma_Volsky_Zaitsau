package modals.WorkoutCalculators;

import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.BaseModal;
import models.WorcoutCalculators.HansonsCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
@Log4j2
public class HansonsModal extends BaseModal {

    protected final static By HANSONS_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='Hansons']");
    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected final static String GREEN_BOX = "//h4[text()='Recent Race Information']";

    @Step("Filling form to hansons calculator")
    public void fillForm(HansonsCalculator hansons) {
        new Dropdown(driver).selectOptionByValue("RaceDist", hansons.getRaceDist().getName());
        new Dropdown(driver).selectOptionByValue("DistType", hansons.getDistTypeHansons().getName());
        new Input(driver).setValue("TimeHH", hansons.getHours());
        new Input(driver).setValue("TimeMM", hansons.getMinutes());
        new Input(driver).setValue("TimeSS", hansons.getSeconds());
        new Input(driver).setValue("Temp", hansons.getTemperature());
        new Input(driver).setValue("Wind", hansons.getWindSpeed());
        new Dropdown(driver).selectOptionByValue("TempType", hansons.getTempType().getName());
        new Dropdown(driver).selectOptionByValue("SpeedType", hansons.getSpeedType().getName());
        new Input(driver).setValue("Humid", hansons.getHumidity());
    }

    @Step("Click hansons calculator button")
    public void clickHansonsCalculatorButton()  {
        log.info("clicking hansons calculator button");
        driver.findElement(HANSONS_CALCULATOR_BUTTON_LOCATOR).click();
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

    public HansonsModal(WebDriver driver) {
        super(driver);
    }
}
