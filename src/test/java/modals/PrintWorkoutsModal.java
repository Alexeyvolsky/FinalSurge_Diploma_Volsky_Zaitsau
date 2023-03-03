package modals;

import elements.Input;
import models.PrintWorkout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrintWorkoutsModal extends BaseModal{

    protected final static By LOCATOR_IFRAME_PRINT_WORKOUT = By.id("PrintWorkoutsiFrame");
    protected final static By SAVE_BUTTON_PRINT = By.id("saveButtonPrint");

    public void fillForm(PrintWorkout printWorkout) {
        new Input(driver).setValue("PrintStartDate", printWorkout.getStartingData());
        new Input(driver).setValue("PrintEndDate", printWorkout.getEndingData());
    }

    public void openIframePrintWorkout()    {
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_PRINT_WORKOUT);
        driver.switchTo().frame(iframe);
    }

    public void clickSaveButtonPrint()  {
        driver.findElement(SAVE_BUTTON_PRINT).click();
    }

    public PrintWorkoutsModal(WebDriver driver) {
        super(driver);
    }
}
