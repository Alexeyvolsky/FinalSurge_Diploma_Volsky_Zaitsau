package tests;

import io.qameta.allure.Description;
import models.Setting;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest  {

    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.setEmailInput(USERNAME);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        headerNavigate.waitSettingButtonPresent();
    }

    @Description("Verify that user can change you personal information")
    @Test(groups = {"regression"})
    public void settingsTest()  {
        headerNavigate.clickSettingsButton();
        settingDetailsPage.waitUserAvatarPresent();
        settingDetailsPage.jsClickEditProfileButton();
        settingDetailsPage.waitUserThumbnailPresent();
        Setting setting = Setting.builder().setBirthday("2/14/2010")
                .setWeight(String.valueOf(faker.number().numberBetween(1, 800))).setCity(faker.address().city())
                .setPostalCode(String.valueOf(faker.number().numberBetween(1000, 1000000))).build();
        settingDetailsPage.fillForm(setting);
        settingDetailsPage.clickSaveChangesButton();
        settingDetailsPage.waitUserAvatarPresent();
        Assert.assertEquals(settingDetailsPage.getSettingsDetails(), setting);
    }
}
