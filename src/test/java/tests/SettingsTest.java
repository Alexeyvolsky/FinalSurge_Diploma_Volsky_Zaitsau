package tests;

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
//        TODO: action setvalue JS закрыть <a>
        headerNavigate.clickSettingsButton();
//        settingDetailsPage.waitUserIconPresent();
        settingDetailsPage.jsClickEditProfileButton();
        settingDetailsPage.sendWeight();
//        settingDetailsPage.waitUserAvatarPresent();
//        settingDetailsPage.uploadFile();
//        Setting setting = Setting.builder().setGender(Gender.MALE).setBirthday("02/14/2010").setWeight("80")
//                .setWeightType(WeightType.KG).setCountry(Country.UNITED_STATE_OF_AMERICAN).setRegion(Region.CALIFORNIA)
//                .setCity("Minsk").setPostalCode("123532").build();
//        settingModal.fillForm(setting);
//        settingDetailsPage.clickSaveChangesButton();
//        settingDetailsPage.waitUserAvatarPresent();
//        Assert.assertEquals(settingDetailsPage.getSettingsDetails(), setting);
    }
}