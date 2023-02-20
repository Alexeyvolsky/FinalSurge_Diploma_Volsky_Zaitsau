package modals.WorkoutCalculators;

import elements.Dropdown;
import elements.Input;
import modals.BaseModal;
import org.openqa.selenium.WebDriver;

public class Hansons extends BaseModal {

    public void fillForm(models.WorcoutCalculators.Hansons hansons) {
        new Dropdown(driver).selectOption("RaceDist", hansons.getRaceDist().getName());
        new Dropdown(driver).selectOption("DistType", hansons.getDistTypeHansons().getName());
        new Input(driver).setValue("TimeHH", hansons.getHours());
        new Input(driver).setValue("TimeMM", hansons.getMinutes());
        new Input(driver).setValue("TimeSS", hansons.getSeconds());
        new Input(driver).setValue("Temp", hansons.getTemperature());
        new Input(driver).setValue("Wind", hansons.getWindSpeed());
        new Dropdown(driver).selectOption("TempType", hansons.getTempType().getName());
        new Dropdown(driver).selectOption("SpeedType", hansons.getSpeedType().getName());
        new Input(driver).setValue("Humid", hansons.getHumidity());
    }

    public Hansons(WebDriver driver) {
        super(driver);
    }
}
