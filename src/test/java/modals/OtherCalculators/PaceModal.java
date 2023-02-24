package modals.OtherCalculators;

import elements.Dropdown;
import elements.Input;
import modals.BaseModal;
import models.OtherCalculators.PaceCalculator;
import org.openqa.selenium.WebDriver;

public class PaceModal extends BaseModal {

    public void fillForm(PaceCalculator paceCalculator) {
        new Input(driver).setValue("RunDist", paceCalculator.getRunDistance());
        new Dropdown(driver).selectOption("DistType", paceCalculator.getDistTypePaceCalculator().getName());
        new Input(driver).setValue("TimeHH", paceCalculator.getHours());
        new Input(driver).setValue("TimeMM", paceCalculator.getMinutes());
        new Input(driver).setValue("TimeSS", paceCalculator.getSeconds());
    }

    public PaceModal(WebDriver driver) {
        super(driver);
    }
}
