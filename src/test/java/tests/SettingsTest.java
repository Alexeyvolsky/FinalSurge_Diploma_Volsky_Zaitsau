package tests;

import enums.Country;
import enums.Gender;
import enums.Region;
import enums.WeightType;
import models.Setting;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest  {

    @BeforeMethod
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.waitSettingButtonPresent();
    }

    @Test
    public void settingsTest()  {
        headerNavigate.clickSettingsButton();
        settingDetailsPage.waitUserIconPresent();
        settingDetailsPage.jsClickEditProfileButton();
        settingDetailsPage.waitUSerAvatarPresent();
        settingDetailsPage.uploadFile("/src/img/monkey-selfie_custom-7117031c832fc3607ee5b26b9d5b03d10a1deaca-s1100-c50.jpg");
        Setting setting = Setting.builder().setGender(Gender.MALE).setBirthday("02/14/2010").setWeight("80")
                .setWeightType(WeightType.KG).setCountry(Country.UNITED_STATE_OF_AMERICAN).setRegion(Region.CALIFORNIA)
                .setCity("Minsk").setPostalCode("123532").build();
        settingModal.fillForm(setting);
        settingDetailsPage.clickSaveChangesButton();
        settingDetailsPage.waitUSerAvatarPresent();
        Assert.assertEquals(settingDetailsPage.getSettingsDetails(), setting);
    }
}