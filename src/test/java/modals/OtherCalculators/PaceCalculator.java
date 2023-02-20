package modals.OtherCalculators;

import elements.Dropdown;
import elements.Input;
import modals.BaseModal;
import org.openqa.selenium.WebDriver;

public class PaceCalculator extends BaseModal {

    public void fillForm(models.OtherCalculators.PaceCalculator paceCalculator) {
        new Input(driver).setValue("RunDist", paceCalculator.getRunDistance());
        new Dropdown(driver).selectOption("DistType", paceCalculator.getDistTypePaceCalculator().getName());
        new Input(driver).setValue("TimeHH", paceCalculator.getHours());
        new Input(driver).setValue("TimeMM", paceCalculator.getMinutes());
        new Input(driver).setValue("TimeSS", paceCalculator.getSeconds());
    }

    public PaceCalculator(WebDriver driver) {
        super(driver);
    }
}
