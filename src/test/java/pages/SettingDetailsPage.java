package pages;

import elements.Input;
import io.qameta.allure.Step;
import models.Setting;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SettingDetailsPage extends BasePage   {

    private final static By EDIT_PROFILE_BUTTON = By.cssSelector("#ProfileEditLink");
    private final static By SAVE_CHANGES_BUTTON = By.id("saveButtonProfile");
    private final static By USER_AVATAR =  By.cssSelector(".img-avatar");
    private final static By USER_THUMBNAIL = By.id("UserThumbnail");
    private final static String LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS = "//small[text()='%s']//ancestor::p";

    @Step("Filling form to setting")
    public void fillForm(Setting setting)  {
        new Input(driver).jsSetValet("BDay", setting.getBirthday());
        new Input(driver).jsSetValet("Weight", setting.getWeight());
        new Input(driver).jsSetValet("City", setting.getCity());
        new Input(driver).jsSetValet("Zip", setting.getPostalCode());
    }

    @Step("Get settings details data")
    public Setting getSettingsDetails()  {
        Setting settingsDetails = new Setting();
        settingsDetails.setBirthday(getBirthdaySettings("Birthday:"));
        settingsDetails.setWeight(getWeightSettings("Weight:"));
        settingsDetails.setCity(getCitySettings("City:"));
        settingsDetails.setPostalCode(getPostalCodeSettings("Zip/Postal Code:"));
        return settingsDetails;
    }

    @Step("Wait user thumbnail is displayed")
    public boolean waitUserThumbnailPresent()   {
        try {
            waitForElementDisplayed(USER_THUMBNAIL);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Wait user avatar is displayed")
    public boolean waitUserAvatarPresent() {
        try {
            waitForElementDisplayed(USER_AVATAR);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("JavaScript click edit profile button")
    public void jsClickEditProfileButton()  {
        jsClick(driver.findElement(EDIT_PROFILE_BUTTON));
    }

    @Step("Get and split birthday in setting")
    public String getBirthdaySettings(String name)  {
        return driver.findElement(By.xpath(String.format(LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS, name))).getText()
                .split(":")[1].trim();
    }

    @Step("Get and split weight in setting")
    public String getWeightSettings(String name)  {
        return driver.findElement(By.xpath(String.format(LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS, name))).getText()
                .split(":")[1].replace(".00 kg", "").trim();
    }

    @Step("Get and split city in setting")
    public String getCitySettings(String name)  {
        return driver.findElement(By.xpath(String.format(LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS, name))).getText()
                .split(":")[1].trim();
    }

    @Step("Get and split postal code in setting")
    public String getPostalCodeSettings(String name)  {
        return driver.findElement(By.xpath(String.format(LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS, name))).getText()
                .split(":")[1].trim();
    }

    @Step("JavaScript click save changes button")
    public void clickSaveChangesButton()    {
        jsClick(driver.findElement(SAVE_CHANGES_BUTTON));
    }

    public SettingDetailsPage(WebDriver driver) {
        super(driver);
    }
}
