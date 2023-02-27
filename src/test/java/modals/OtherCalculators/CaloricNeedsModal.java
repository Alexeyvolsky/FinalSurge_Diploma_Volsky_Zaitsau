package modals.OtherCalculators;

import elements.Input;
import elements.RadioButton;
import modals.BaseModal;
import models.OtherCalculators.CaloricNeedsCalculator;
import org.openqa.selenium.WebDriver;

public class CaloricNeedsModal extends BaseModal {

    public void fillForm(CaloricNeedsCalculator caloricNeeds)  {
        new Input(driver).clearAndSetValue("Weight", caloricNeeds.getWeight());
        new RadioButton(driver).clickRadiobutton("WeightType", caloricNeeds.getWeightType().getValue());
        new Input(driver).clearAndSetValue("HeightInchCent", caloricNeeds.getHeight());
        new RadioButton(driver).clickRadiobutton("HeightType", caloricNeeds.getHeightType().getValue());
        new Input(driver).clearAndSetValue("Age", caloricNeeds.getAge());
        new RadioButton(driver).clickRadiobutton("Gender", caloricNeeds.getGender().getValue());
        new Input(driver).clearAndSetValue("RunDist", caloricNeeds.getRunDistance());
        new RadioButton(driver).clickRadiobutton("DistType", caloricNeeds.getDistTypeCaloricNeeds().getValue());
    }

    public CaloricNeedsModal(WebDriver driver) {
        super(driver);
        this.GREEN_BOX = "//*[contains(text(), \"%s\")]";
    }
}