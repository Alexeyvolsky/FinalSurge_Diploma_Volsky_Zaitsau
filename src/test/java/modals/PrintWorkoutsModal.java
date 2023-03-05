package modals;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PrintWorkout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@Log4j2
public class PrintWorkoutsModal extends BaseModal{

    protected final static By LOCATOR_IFRAME_PRINT_WORKOUT = By.id("PrintWorkoutsiFrame");
    protected final static By SAVE_BUTTON_PRINT = By.id("saveButtonPrint");

    @Step("Filling form to print workout modal")
    public void fillForm(PrintWorkout printWorkout) {
        new Input(driver).setValueCountry("PrintStartDate", printWorkout.getStartingData());
        new Input(driver).setValueCountry("PrintEndDate", printWorkout.getEndingData());
    }

    @Step("Open iframe for modal print workout")
    public void openIframePrintWorkout()    {
        log.info("opening iframe for modal workout calculator");
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_PRINT_WORKOUT);
        driver.switchTo().frame(iframe);
    }

    @Step("Click print save button")
    public void clickSaveButtonPrint()  {
        log.info("clicking print save button");
        driver.findElement(SAVE_BUTTON_PRINT).click();
    }

    public PrintWorkoutsModal(WebDriver driver) {
        super(driver);
    }
}
