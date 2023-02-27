package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SettingDetailsPage extends BasePage   {

    private final static By EDIT_PROFILE_BUTTON = By.cssSelector("#ProfileEditLink");
    private final static By SAVE_CHANGES_BUTTON = By.id("saveButtonProfile");
    private final static String SETTINGS_DATA = "//small[text()='%s']//ancestor::p";
    private final static By USER_AVATAR =  By.cssSelector(".img-avatar");
    private final static By USER_THUMBNAIL = By.id("UserThumbnail");

    public String getDetailsSetting() {
        return driver.findElement(By.xpath(String.format(SETTINGS_DATA, "City:"))).getText();
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

    public void jsSendKeysInSettings(String name, String value) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.getElementById('"+name+"').value='"+value+"'");
    }

    public void sendKeysInSettings()    {
        jsSendKeysInSettings("BDay", "02/14/2010");
        jsSendKeysInSettings("Weight", "25");
        jsSendKeysInSettings("City", "Minsk");
        jsSendKeysInSettings("Zip", "3463446");
    }

    public void clickSaveChangesButton()    {
        jsClick(driver.findElement(SAVE_CHANGES_BUTTON));
    }

    public SettingDetailsPage(WebDriver driver) {
        super(driver);
    }
}
