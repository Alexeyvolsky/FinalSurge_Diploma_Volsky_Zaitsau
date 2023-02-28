package modals;

import elements.Input;
import models.PrintWorkout;
import org.openqa.selenium.WebDriver;

public class CopyMoveDeleteModal extends BaseModal  {

    public void fillForm(PrintWorkout date)    {
        new Input(driver).clearAndSetValue("WorkoutDateStart", date.getStartingData());
        new Input(driver).clearAndSetValue("WorkoutDateEnd", date.getEndingData());
    }

    public CopyMoveDeleteModal(WebDriver driver) {
        super(driver);
    }
}
