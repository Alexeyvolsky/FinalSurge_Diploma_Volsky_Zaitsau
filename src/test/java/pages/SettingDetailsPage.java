package pages;

import elements.Input;
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

    public void fillForm(Setting setting)  {
        new Input(driver).jsSetValet("BDay", setting.getBirthday());
        new Input(driver).jsSetValet("Weight", setting.getWeight());
        new Input(driver).jsSetValet("City", setting.getCity());
        new Input(driver).jsSetValet("Zip", setting.getPostalCode());
    }

    public Setting getSettingsDetails()  {
        Setting settingsDetails = new Setting();
        settingsDetails.setBirthday(getBirthdaySettings("Birthday:"));
        settingsDetails.setWeight(getWeightSettings("Weight:"));
        settingsDetails.setCity(getCitySettings("City:"));
        settingsDetails.setPostalCode(getPostalCodeSettings("Zip/Postal Code:"));
        return settingsDetails;
    }

    public boolean waitUserThumbnailPresent()   {
        try {
            waitForElementDisplayed(USER_THUMBNAIL);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public boolean waitUserAvatarPresent() {
        try {
            waitForElementDisplayed(USER_AVATAR);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public void jsClickEditProfileButton()  {
        jsClick(driver.findElement(EDIT_PROFILE_BUTTON));
    }

    public String getBirthdaySettings(String name)  {
        return driver.findElement(By.xpath(String.format(LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS, name))).getText()
                .split(":")[1].trim();
    }

    public String getWeightSettings(String name)  {
        return driver.findElement(By.xpath(String.format(LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS, name))).getText()
                .split(":")[1].replace(".00 kg", "").trim();
    }

    public String getCitySettings(String name)  {
        return driver.findElement(By.xpath(String.format(LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS, name))).getText()
                .split(":")[1].trim();
    }

    public String getPostalCodeSettings(String name)  {
        return driver.findElement(By.xpath(String.format(LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS, name))).getText()
                .split(":")[1].trim();
    }

    public void clickSaveChangesButton()    {
        jsClick(driver.findElement(SAVE_CHANGES_BUTTON));
    }

    public SettingDetailsPage(WebDriver driver) {
        super(driver);
    }
}
