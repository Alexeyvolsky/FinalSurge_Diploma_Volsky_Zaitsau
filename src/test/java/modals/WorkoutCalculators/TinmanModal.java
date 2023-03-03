package modals.WorkoutCalculators;

import elements.Dropdown;
import elements.Input;
import elements.RadioButton;
import modals.BaseModal;
import models.WorcoutCalculators.TinmanCalculator;
import org.openqa.selenium.WebDriver;

public class TinmanModal extends BaseModal {

    public void fillForm(TinmanCalculator tinman)  {
        new Dropdown(driver).selectOption("distance", tinman.getDistanceTinman().getName());
        new Input(driver).setValue("TimeHH", tinman.getHours());
        new Input(driver).setValue("TimeMM", tinman.getMinutes());
        new Input(driver).setValue("TimeSS", tinman.getSeconds());
        new RadioButton(driver).clickRadiobutton("Gender", tinman.getGender().getAnotherValue());
    }

    public TinmanModal(WebDriver driver) {
        super(driver);
    }
}
