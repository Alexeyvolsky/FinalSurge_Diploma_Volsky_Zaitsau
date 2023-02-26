package modals.OtherCalculators;

import elements.Input;
import elements.RadioButton;
import modals.BaseModal;
import models.OtherCalculators.CaloricNeedsCalculator;
import org.openqa.selenium.WebDriver;

public class CaloricNeedsModal extends BaseModal {

    public void fillForm(CaloricNeedsCalculator caloricNeeds)  {
        new Input(driver).clearAndSetValue("Weight", caloricNeeds.getWeight());
        new RadioButton(driver).clickRadiobutton(caloricNeeds.getWeightType().getName());
        new Input(driver).clearAndSetValue("HeightInchCent", caloricNeeds.getHeight());
        new RadioButton(driver).clickRadiobutton(caloricNeeds.getHeightType().getName());
        new Input(driver).clearAndSetValue("Age", caloricNeeds.getAge());
        new RadioButton(driver).clickRadiobutton(caloricNeeds.getGender().getNameForCaloricNeeds());
        new Input(driver).clearAndSetValue("RunDist", caloricNeeds.getRunDistance());
        new RadioButton(driver).clickRadiobutton(caloricNeeds.getDistTypeCaloricNeeds().getName());
    }

    public CaloricNeedsModal(WebDriver driver) {
        super(driver);
        this.GREEN_BOX = "//*[contains(text(), \"%s\")]";
    }
}