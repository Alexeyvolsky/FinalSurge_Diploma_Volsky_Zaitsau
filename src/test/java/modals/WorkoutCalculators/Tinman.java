package modals.WorkoutCalculators;

import elements.Dropdown;
import elements.Input;
import elements.RadioButton;
import modals.BaseModal;
import org.openqa.selenium.WebDriver;

public class Tinman extends BaseModal {

    public void fillForm(models.WorcoutCalculators.Tinman tinman)  {
        new Dropdown(driver).selectOption("distance", tinman.getDistanceTinman().getName());
        new Input(driver).setValue("TimeHH", tinman.getHours());
        new Input(driver).setValue("TimeMM", tinman.getMinutes());
        new Input(driver).setValue("TimeSS", tinman.getSeconds());
        new RadioButton(driver).clickRadiobutton(tinman.getGender().getName());
    }

    public Tinman(WebDriver driver) {
        super(driver);
    }
}
