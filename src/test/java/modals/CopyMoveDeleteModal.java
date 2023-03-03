package modals;

import elements.Input;
import models.PrintWorkout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CopyMoveDeleteModal extends BaseModal  {

    protected final static By LOCATOR_IFRAME_COPY_WEEKSI = By.id("CopyWeeksiFrame");
    protected final static By CONTINUE_BUTTON = By.id("contButton");

    public void fillForm(PrintWorkout date)    {
        new Input(driver).clearAndSetValue("WorkoutDateStart", date.getStartingData());
        new Input(driver).clearAndSetValue("WorkoutDateEnd", date.getEndingData());
    }

    public void openIframeCopyWeeksi()  {
        WebElement iframe = driver.findElement(LOCATOR_IFRAME_COPY_WEEKSI);
        driver.switchTo().frame(iframe);
    }

    public void clickContinueButton()   {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public CopyMoveDeleteModal(WebDriver driver) {
        super(driver);
    }
}
