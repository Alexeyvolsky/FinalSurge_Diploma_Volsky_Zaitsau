package modals.WorkoutCalculators;

import elements.Dropdown;
import elements.Input;
import modals.BaseModal;
import org.openqa.selenium.WebDriver;

public class McMillan extends BaseModal {

    public void fillForm(models.WorcoutCalculators.McMillan mcMillan)   {
        new Dropdown(driver).selectOption("distance", mcMillan.getDistanceMcMillan().getName());
        new Input(driver).setValue("TimeHH", mcMillan.getHours());
        new Input(driver).setValue("TimeMM", mcMillan.getMinutes());
        new Input(driver).setValue("TimeSS", mcMillan.getSeconds());
        new Dropdown(driver).selectOption("goaldistance", mcMillan.getDistanceMcMillan().getName());
        new Input(driver).setValue("GTimeHH", mcMillan.getHours());
        new Input(driver).setValue("GTimeMM", mcMillan.getMinutes());
        new Input(driver).setValue("GTimeSS", mcMillan.getSeconds());
    }

    public McMillan(WebDriver driver) {
        super(driver);
    }
}
