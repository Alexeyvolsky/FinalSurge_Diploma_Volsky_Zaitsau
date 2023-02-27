package modals.WorkoutCalculators;

import elements.Input;
import elements.RadioButton;
import modals.BaseModal;
import models.WorcoutCalculators.IntensityCalculator;
import org.openqa.selenium.WebDriver;

public class IntensityModal extends BaseModal {

    public void fillForm(IntensityCalculator intensity)  {
        new RadioButton(driver).clickRadiobutton("EventType", intensity.getSelectEvent().getName());
        new Input(driver).setValue("TimeHH", intensity.getHours());
        new Input(driver).setValue("TimeMM", intensity.getMinutes());
        new Input(driver).setValue("TimeSS", intensity.getSeconds());
    }

    public IntensityModal(WebDriver driver) {
        super(driver);
    }
}