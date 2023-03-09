package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Setting;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
@Log4j2
public class SettingDetailsPage extends BasePage   {

    private final static By EDIT_PROFILE_BUTTON = By.cssSelector("#ProfileEditLink");
    private final static By SAVE_CHANGES_BUTTON = By.id("saveButtonProfile");
    private final static By USER_AVATAR =  By.cssSelector(".img-avatar");
    private final static By USER_THUMBNAIL = By.id("UserThumbnail");
    private final static String LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS = "//small[text()='%s']//ancestor::p";

    @Step("Filling form to setting")
    public void fillForm(Setting setting)  {
        new Input(driver).jsSetValue("BDay", setting.getBirthday());
        new Input(driver).jsSetValue("Weight", setting.getWeight());
        new Input(driver).jsSetValue("City", setting.getCity());
        new Input(driver).jsSetValue("Zip", setting.getPostalCode());
    }

    @Step("Get settings details data")
    public Setting getSettingsDetails()  {
        log.info("getting setting details data");
        Setting settingsDetails = new Setting();
        settingsDetails.setBirthday(getBirthdaySettings("Birthday:"));
        settingsDetails.setWeight(getWeightSettings("Weight:"));
        settingsDetails.setCity(getCitySettings("City:"));
        settingsDetails.setPostalCode(getPostalCodeSettings("Zip/Postal Code:"));
        return settingsDetails;
    }

    public boolean waitUserThumbnailPresent()   {
        log.debug("waiting user thumbnail is displayed");
        try {
            waitForElementDisplayed(USER_THUMBNAIL);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public boolean waitUserAvatarPresent() {
        log.debug("waiting user avatar is displayed");
        try {
            waitForElementDisplayed(USER_AVATAR);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("JavaScript click edit profile button")
    public void jsClickEditProfileButton()  {
        log.info("javascript click edit profile button");
        jsClick(driver.findElement(EDIT_PROFILE_BUTTON));
    }

    @Step("Get birthday in setting")
    public String getBirthdaySettings(String name)  {
        log.info("getting birthday in setting");
        return driver.findElement(By.xpath(String.format(LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS, name))).getText()
                .split(":")[1].trim();
    }

    @Step("Get weight in setting")
    public String getWeightSettings(String name)  {
        log.info("getting weight in setting");
        return driver.findElement(By.xpath(String.format(LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS, name))).getText()
                .split(":")[1].replace(".00 kg", "").trim();
    }

    @Step("Get city in setting")
    public String getCitySettings(String name)  {
        log.info("getting city in setting");
        return driver.findElement(By.xpath(String.format(LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS, name))).getText()
                .split(":")[1].trim();
    }

    @Step("Get postal code in setting")
    public String getPostalCodeSettings(String name)  {
        log.info("getting postal code in setting");
        return driver.findElement(By.xpath(String.format(LOCATOR_FOR_SETTINGS_ELEMENTS_DETAILS, name))).getText()
                .split(":")[1].trim();
    }

    @Step("JavaScript click save changes button")
    public void clickSaveChangesButton()    {
        log.info("javascript click save changes button");
        jsClick(driver.findElement(SAVE_CHANGES_BUTTON));
    }

    public SettingDetailsPage(WebDriver driver) {
        super(driver);
    }
}
