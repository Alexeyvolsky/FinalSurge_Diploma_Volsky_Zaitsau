package pages;

import elements.GetElementValue;
import enums.Country;
import enums.Gender;
import enums.Region;
import models.Setting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingDetailsPage extends BasePage   {

    private final static By USER_ICON = By.cssSelector("UserThumbnail");
    private final static By USER_AVATAR = By.cssSelector(".img-holder .img-avatar");
    private final static By EDIT_PROFILE_BUTTON = By.cssSelector("#ProfileEditLink");
    private final static By SAVE_CHANGES_BUTTON = By.id("saveButtonProfile");
    private final static By CHANGE_IMAGE_BUTTON = By.xpath("//span[@class='btn btn-small btn-file']");
    private final static By UPLOAD_BUTTON = By.id("NextStep");
    private final static By EDIT_PROFILE_PIC_OTHER = By.id("EditProfilePicOther");
    private final static By SELECT_IMG =By.xpath("//input[@name='profilepic']");

    public Setting getSettingsDetails()    {
        Setting.SettingBuilder settings = Setting.builder()
                .setGender(Gender.fromString(new GetElementValue(driver, "Gender:").getValue()))
                .setBirthday(new GetElementValue(driver, "Birthday:").getValue())
                .setWeight(new GetElementValue(driver, "Weight:").getValue())
                .setCountry(Country.fromString(new GetElementValue(driver, "Country:").getValue()))
                .setRegion(Region.fromString(new GetElementValue(driver, "State:").getValue()))
                .setCity(new GetElementValue(driver, "City:").getValue())
                .setPostalCode(new GetElementValue(driver, "Zip/Postal Code:").getValue());
        return settings.build();
    }

    public void waitUserIconPresent()   {
        waitForElementDisplayed(USER_ICON);
    }

    public void waitUSerAvatarPresent() {
        waitForElementDisplayed(USER_AVATAR);
    }

    public void uploadFile(String path)    {
        driver.findElement(EDIT_PROFILE_PIC_OTHER).click();
        WebElement fileUpload = driver.findElement(SELECT_IMG);
        fileUpload.sendKeys(System.getProperty("user.dir") + path);
        driver.findElement(UPLOAD_BUTTON).click();
    }

    public void jsClickEditProfileButton()  {
        jsClick(driver.findElement(EDIT_PROFILE_BUTTON));
    }

    public void clickSaveChangesButton()    {
        driver.findElement(SAVE_CHANGES_BUTTON);
    }
    public SettingDetailsPage(WebDriver driver) {
        super(driver);
    }
}
