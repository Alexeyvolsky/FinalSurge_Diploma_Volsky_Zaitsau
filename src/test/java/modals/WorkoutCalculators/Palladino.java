package modals.WorkoutCalculators;

import elements.Input;
import modals.BaseModal;
import org.openqa.selenium.WebDriver;

public class Palladino extends BaseModal {

    public void fillFormCalculateIntervalPowerTarget(models.WorcoutCalculators.Palladino palladino) {
        new Input(driver).setValue("CP", palladino.getCriticalPower());
        new Input(driver).setValue("RWC", palladino.getReserveWorkCapacity());
    }

    public void fillFormCpAndRwcFromACpTest(models.WorcoutCalculators.Palladino palladino)   {
        new Input(driver).setValue("TimeMM", palladino.getMinutes());
        new Input(driver).setValue("TimeSS", palladino.getSeconds());
        new Input(driver).setValue("AVPWS", palladino.getShortTest());
        new Input(driver).setValue("TimeMML", palladino.getMinutes());
        new Input(driver).setValue("TimeSSL", palladino.getSeconds());
        new Input(driver).setValue("AVPWL", palladino.getLongTest());
    }

    public void fillFormCpFromRaceOrTtMoreThenForty(models.WorcoutCalculators.Palladino palladino)    {
        new Input(driver).setValue("TimeHHR", palladino.getHours());
        new Input(driver).setValue("TimeMMR", palladino.getMinutes());
        new Input(driver).setValue("TimeSSR", palladino.getSeconds());
        new Input(driver).setValue("RAP", palladino.getRaceAvgPower());
    }

    public void fillFormCpFromRaceOrTtLessThenForty(models.WorcoutCalculators.Palladino palladino)   {
        new Input(driver).setValue("TimeMMRR", palladino.getMinutes());
        new Input(driver).setValue("TimeSSRR", palladino.getSeconds());
        new Input(driver).setValue("RAPR", palladino.getRaceAvgPower());
    }

    public Palladino(WebDriver driver) {
        super(driver);
    }
}
