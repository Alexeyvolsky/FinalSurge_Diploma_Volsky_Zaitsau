package modals;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

@Log4j2
public abstract class BaseModal extends BasePage {

    protected By LOCATOR_IFRAME = By.id("IntensityCalciFrame");
    protected By SAVE_BUTTON = By.id("saveButtonSettings");

    public void switchToIframeCalculator()    {
        log.debug(String.format("opening iframe %s", LOCATOR_IFRAME));
        WebElement iframe = driver.findElement(LOCATOR_IFRAME);
        driver.switchTo().frame(iframe);
    }

    public void waitForSaveButtonDisplayed()    {
        log.debug(String.format("waiting for save button is loaded %s", SAVE_BUTTON));
        waitForElementDisplayed(SAVE_BUTTON);
    }

    public BaseModal(WebDriver driver) {
        super(driver);
    }
}