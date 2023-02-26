package pages;

import elements.FormSep;
import enums.Country;
import enums.Gender;
import enums.Region;
import models.Setting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingDetailsPage extends BasePage   {

    private final static String USER_ICON = "%s";
    private final static By EDIT_PROFILE_BUTTON = By.cssSelector("#ProfileEditLink");
    private final static By SAVE_CHANGES_BUTTON = By.id("saveButtonProfile");
    private final static By CHANGE_IMAGE_BUTTON = By.xpath("//span[@class='btn btn-small btn-file']");
    private final static By UPLOAD_BUTTON = By.id("NextStep");
    private final static By EDIT_PROFILE_PIC_OTHER = By.id("EditProfilePicOther");
    private final static By SELECT_IMG =By.xpath("//input[@name='profilepic']");

    private final static By WEIGHT_INPUT = By.id("BDay");

    public Setting getSettingsDetails()    {
        Setting.SettingBuilder settings = Setting.builder()
                .setGender(Gender.fromString(new FormSep(driver, "Gender:").getValue()))
                .setBirthday(new FormSep(driver, "Birthday:").getValue())
                .setWeight(new FormSep(driver, "Weight:").getValue())
                .setCountry(Country.fromString(new FormSep(driver, "Country:").getValue()))
                .setRegion(Region.fromString(new FormSep(driver, "State:").getValue()))
                .setCity(new FormSep(driver, "City:").getValue())
                .setPostalCode(new FormSep(driver, "Zip/Postal Code:").getValue());
        return settings.build();
    }

    public void waitUserIconPresent()   {
        waitForElementDisplayed(By.cssSelector(String.format(USER_ICON, "UserThumbnail")));
    }

    public void waitUserAvatarPresent() {
        waitForElementDisplayed(By.cssSelector(String.format(USER_ICON, ".img-holder .img-avatar")));
    }

//    public void uploadFile()    {
//        driver.findElement(EDIT_PROFILE_PIC_OTHER).click();
//        WebElement fileUpload = driver.findElement(SELECT_IMG);
//        fileUpload.sendKeys(System.getProperty("user.dir") +
//                "/src/img/monkey-selfie_custom-7117031c832fc3607ee5b26b9d5b03d10a1deaca-s1100-c50.jpg");
//        driver.findElement(UPLOAD_BUTTON).click();
//    }

    public void jsClickEditProfileButton()  {
        jsClick(driver.findElement(EDIT_PROFILE_BUTTON));
    }

    public void clickSaveChangesButton()    {
        driver.findElement(SAVE_CHANGES_BUTTON);
    }

    public void jsSendKeys(WebElement element, String value) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.getElementById('element', "+element+").setAttribute('value', "+value+")");
    }

    public void sendWeight()    {
        jsSendKeys(driver.findElement(WEIGHT_INPUT), "18");
    }


    public SettingDetailsPage(WebDriver driver) {
        super(driver);
    }
}
