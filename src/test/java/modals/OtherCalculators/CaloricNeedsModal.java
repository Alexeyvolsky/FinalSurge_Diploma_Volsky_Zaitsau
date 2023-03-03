package modals.OtherCalculators;

import elements.Input;
import elements.RadioButton;
import modals.BaseModal;
import models.OtherCalculators.CaloricNeedsCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaloricNeedsModal extends BaseModal {

    protected final static By LOCATOR_IFRAME_OTHER_CALCULATOR = By.id("OtherCalciFrame");
    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected String GREEN_BOX = "//h4[text()=\"Today's Caloric Needs\"]";
    protected final static By ALERT_ERROR_MESSAGE = By.cssSelector(".alert");

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
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_OTHER_CALCULATOR);
        driver.switchTo().frame(iframe);
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

    public boolean alertErrorMessageIsPresent()    {
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