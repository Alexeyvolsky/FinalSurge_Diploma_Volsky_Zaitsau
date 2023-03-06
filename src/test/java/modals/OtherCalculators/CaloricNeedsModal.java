package modals.OtherCalculators;

import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals.BaseModal;
import models.OtherCalculators.CaloricNeedsCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Log4j2
public class CaloricNeedsModal extends BaseModal {

    protected final static By LOCATOR_IFRAME_OTHER_CALCULATOR = By.id("OtherCalciFrame");
    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected final static String GREEN_BOX = "//h4[text()=\"Today's Caloric Needs\"]";
    protected final static By ALERT_ERROR_MESSAGE = By.cssSelector(".alert");

    @Step("Filling form to calculate caloric needs")
    public void fillForm(CaloricNeedsCalculator caloricNeeds)  {
        new Input(driver).clearAndSetValue("Weight", caloricNeeds.getWeight());
        new RadioButton(driver).clickRadiobutton("WeightType", caloricNeeds.getWeightType().getValue());
        new Input(driver).clearAndSetValue("HeightInchCent", caloricNeeds.getHeight());
        new RadioButton(driver).clickRadiobutton("HeightType", caloricNeeds.getHeightType().getValue());
        new Input(driver).clearAndSetValue("Age", caloricNeeds.getAge());
        new RadioButton(driver).clickRadiobutton("Gender", caloricNeeds.getGender().getValue());
        new Input(driver).clearAndSetValue("RunDist", caloricNeeds.getRunDistance());
        new RadioButton(driver).clickRadiobutton("DistType", caloricNeeds.getDistTypeCaloricNeeds().getValue());
    }

    public void openIframeOtherCalculator()    {
        log.debug("opening iframe for modal other calculator");
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_OTHER_CALCULATOR);
        driver.switchTo().frame(iframe);
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

    public boolean alertErrorMessageIsPresent()    {
        log.debug("verifying that alert error message is display");
        try {
            driver.findElement(ALERT_ERROR_MESSAGE).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public CaloricNeedsModal(WebDriver driver) {
        super(driver);
    }
}