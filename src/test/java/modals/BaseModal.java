package modals;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class BaseModal extends BasePage {
    protected final static By FIRST_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings");
    protected final static By SECOND_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings2");
    protected final static By THIRD_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings3");
    protected final static By FOURTH_SAVE_BUTTON_SETTINGS = By.id("saveButtonSettings4");
    protected final static By SAVE_BUTTON_PRINT = By.id("saveButtonPrint");
    protected String GREEN_BOX = "//h4[text()=\"%s\"]";
    protected final static By PACE_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='Pace Calculator']");
    protected final static By HANSONS_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='Hansons']");
    protected final static By MCMILLAN_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='McMillan']");
    protected final static By TINMAN_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='Tinman']");
    protected final static By PALLADINO_CALCULATOR_BUTTON_LOCATOR = By.xpath("//a[text()='Palladino']");
    protected final static By ALERT_ERROR_MESSAGE = By.cssSelector(".alert");
    protected final static By LOCATOR_IFRAME_OTHER_CALCULATOR = By.id("OtherCalciFrame");
    protected final static By LOCATOR_IFRAME_WORKOUT_CALCULATOR = By.id("IntensityCalciFrame");
    protected final static By LOCATOR_IFRAME_PRINT_WORKOUT = By.id("PrintWorkoutsiFrame");
    protected final static By LOCATOR_IFRAME_COPY_WEEKSI = By.id("CopyWeeksiFrame");
    protected final static By CONTINUE_BUTTON = By.id("contButton");

    public boolean isGreenBoxDisplay(String text)  {
        try {
            driver.findElement(By.xpath(String.format(GREEN_BOX, text))).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public void clickPaceCalculatorButton() {
        try {
            driver.findElement(PACE_CALCULATOR_BUTTON_LOCATOR).click();
        } catch (NoSuchElementException ex) {
        }
    }

    public void clickHansonsCalculatorButton()  {
        driver.findElement(HANSONS_CALCULATOR_BUTTON_LOCATOR).click();
    }

    public void clickMcMilanCalculatorButton()    {
        driver.findElement(MCMILLAN_CALCULATOR_BUTTON_LOCATOR).click();
    }

    public void clickTinmanCalculatorButton() {
        driver.findElement(TINMAN_CALCULATOR_BUTTON_LOCATOR).click();
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

    public void clickSaveButtonPrint()  {
        driver.findElement(SAVE_BUTTON_PRINT).click();
    }

    public void openIframeOtherCalculator()    {
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_OTHER_CALCULATOR);
        driver.switchTo().frame(iframe);
    }

    public void openIframeWorkoutCalculator()   {
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_WORKOUT_CALCULATOR);
        driver.switchTo().frame(iframe);
    }

    public void openIframePrintWorkout()    {
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_PRINT_WORKOUT);
        driver.switchTo().frame(iframe);
    }

    public void openIframeCopyWeeksi()  {
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_COPY_WEEKSI);
        driver.switchTo().frame(iframe);
    }

    public void closeIframe()   {
        driver.switchTo().defaultContent();
    }

    public void clickContinueButton()   {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public boolean alertErrorMessageIsPresent()    {
        try {
            driver.findElement(ALERT_ERROR_MESSAGE).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public BaseModal(WebDriver driver) {
        super(driver);
    }
}