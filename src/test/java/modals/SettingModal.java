package modals;

import elements.Dropdown;
import elements.Input;
import elements.RadioButton;
import models.Setting;
import org.openqa.selenium.WebDriver;

public class SettingModal extends BaseModal {

    public void fillForm(Setting setting)  {
        new RadioButton(driver).clickRadiobutton(setting.getGender().getName());
        new Input(driver).setValue("BDay", setting.getBirthday());
        new Input(driver).setValue("Weight", setting.getWeight());
        new RadioButton(driver).clickRadiobutton(setting.getWeightType().getName());
        new Dropdown(driver).selectOption("Country", setting.getCountry().getName());
        new Dropdown(driver).selectOption("Region", setting.getRegion().getName());
        new Input(driver).setValue("City", setting.getCity());
        new Input(driver).setValue("Zip", setting.getPostalCode());
    }

    public SettingModal(WebDriver driver) {
        super(driver);
    }
}
