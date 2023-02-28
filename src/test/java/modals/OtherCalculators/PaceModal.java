package modals.OtherCalculators;

import elements.Dropdown;
import elements.Input;
import modals.BaseModal;
import models.OtherCalculators.PaceCalculator;
import org.openqa.selenium.WebDriver;

public class PaceModal extends BaseModal {

    public void fillForm(PaceCalculator paceCalculator) {
        new Input(driver).clearAndSetValue("RunDist", paceCalculator.getRunDistance());
        new Dropdown(driver).selectOption("DistType", paceCalculator.getDistTypePaceCalculator().getName());
        new Input(driver).clearAndSetValue("TimeHH", paceCalculator.getHours());
        new Input(driver).clearAndSetValue("TimeMM", paceCalculator.getMinutes());
        new Input(driver).clearAndSetValue("TimeSS", paceCalculator.getSeconds());
    }

    public PaceModal(WebDriver driver) {
        super(driver);
    }
}
