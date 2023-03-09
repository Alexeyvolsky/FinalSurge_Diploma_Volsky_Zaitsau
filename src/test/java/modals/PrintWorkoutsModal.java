package modals;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PrintWorkout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class PrintWorkoutsModal extends BaseModal{

    protected final static By SAVE_BUTTON_PRINT = By.id("saveButtonPrint");

    @Step("Filling form to print workout modal")
    public void fillForm(PrintWorkout printWorkout) {
        new Input(driver).setValue("PrintStartDate", printWorkout.getStartingData());
        new Input(driver).setValue("PrintEndDate", printWorkout.getEndingData());
    }

    @Step("Click print save button")
    public void clickSaveButtonPrint()  {
        log.info("clicking print save button");
        driver.findElement(SAVE_BUTTON_PRINT).click();
    }

    public PrintWorkoutsModal(WebDriver driver) {
        super(driver);
        this.LOCATOR_IFRAME = By.id("PrintWorkoutsiFrame");
    }
}
