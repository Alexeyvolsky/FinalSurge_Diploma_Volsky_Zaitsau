package modals.WorkoutCalculators;

import elements.Input;
import modals.BaseModal;
import models.WorcoutCalculators.PalladinoCalculator;
import org.openqa.selenium.WebDriver;

public class PalladinoModal extends BaseModal {

    public void fillFormCalculateIntervalPowerTarget(PalladinoCalculator palladino) {
        new Input(driver).setValue("CP", palladino.getCriticalPower());
        new Input(driver).setValue("RWC", palladino.getReserveWorkCapacity());
    }

    public void fillFormCpAndRwcFromACpTest(PalladinoCalculator palladino)   {
        new Input(driver).setValue("TimeMM", palladino.getMinutes());
        new Input(driver).setValue("TimeSS", palladino.getSeconds());
        new Input(driver).setValue("AVPWS", palladino.getShortTest());
        new Input(driver).setValue("TimeMML", palladino.getMinutes());
        new Input(driver).setValue("TimeSSL", palladino.getSeconds());
        new Input(driver).setValue("AVPWL", palladino.getLongTest());
    }

    public void fillFormCpFromRaceOrTtMoreThenForty(PalladinoCalculator palladino)    {
        new Input(driver).setValue("TimeHHR", palladino.getHours());
        new Input(driver).setValue("TimeMMR", palladino.getMinutes());
        new Input(driver).setValue("TimeSSR", palladino.getSeconds());
        new Input(driver).setValue("RAP", palladino.getRaceAvgPower());
    }

    public void fillFormCpFromRaceOrTtLessThenForty(PalladinoCalculator palladino)   {
        new Input(driver).setValue("TimeMMRR", palladino.getMinutes());
        new Input(driver).setValue("TimeSSRR", palladino.getSeconds());
        new Input(driver).setValue("RAPR", palladino.getRaceAvgPower());
    }

    public PalladinoModal(WebDriver driver) {
        super(driver);
    }
}
