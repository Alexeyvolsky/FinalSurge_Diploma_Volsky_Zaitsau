package modals.WorkoutCalculators;

import elements.Input;
import elements.RadioButton;
import modals.BaseModal;
import org.openqa.selenium.WebDriver;

public class Intensity extends BaseModal {

    public void fillForm(models.WorcoutCalculators.Intensity intensity)  {
        new RadioButton(driver).clickRadiobutton(intensity.getSelectEvent().getName());
        new Input(driver).setValue("TimeHH", intensity.getHours());
        new Input(driver).setValue("TimeMM", intensity.getMinutes());
        new Input(driver).setValue("TimeSS", intensity.getSeconds());
    }

    public Intensity(WebDriver driver) {
        super(driver);
    }
}