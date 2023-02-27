package tests;

import io.qameta.allure.Description;
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

    @Description("Verify that user can change you personal information")
    @Test
    public void settingsTest()  {
        headerNavigate.clickSettingsButton();
        settingDetailsPage.waitUserAvatarPresent();
        settingDetailsPage.jsClickEditProfileButton();
        settingDetailsPage.waitUserThumbnailPresent();
        settingDetailsPage.sendKeysInSettings();
        settingDetailsPage.clickSaveChangesButton();
        settingDetailsPage.waitUserAvatarPresent();
        Assert.assertEquals(settingDetailsPage.getDetailsSetting(), "City: Minsk");
    }
}