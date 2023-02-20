package modals;

import elements.Input;
import models.PrintWorkout;
import org.openqa.selenium.WebDriver;

public class PrintWorkouts extends BaseModal{

    public void fillForm(PrintWorkout printWorkout) {
        new Input(driver).setValue("PrintStartDate", printWorkout.getStartingData());
        new Input(driver).setValue("PrintEndDate", printWorkout.getEndingData());
    }

    public PrintWorkouts(WebDriver driver) {
        super(driver);
    }
}
