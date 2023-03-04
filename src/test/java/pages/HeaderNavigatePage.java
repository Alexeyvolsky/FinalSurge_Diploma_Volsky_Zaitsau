package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderNavigatePage extends BasePage    {

    private final static By CALENDAR_BUTTON = By.xpath("//i[contains(@class, 'day-calendar')]");
    private final static By WORKOUT_CALCULATORS_BUTTON = By.xpath("//i[contains(@class, 'stop-watch')]");
    private final static By OTHER_CALCULATORS_BUTTON = By.xpath("//i[contains(@class, 'calculator')]");
    private final static By PRINT_WORKOUT_BUTTON = By.xpath("//i[contains(@class, 'printer')]");
    private final static String USER_BOX_BUTTON = "//a[text()='%s']";

    @Step("Click calendar button")
    public void clickCalendarButton()  {
        driver.findElement(CALENDAR_BUTTON).click();
    }

    @Step("Click workout calendar button")
    public void clickWorkoutCalculateButton()  {
        driver.findElement(WORKOUT_CALCULATORS_BUTTON).click();
    }

    @Step("Click other calculator button")
    public void clickOtherCalculatorsButton()  {
        driver.findElement(OTHER_CALCULATORS_BUTTON).click();
    }

    @Step("Click print workout button")
    public void clickPrintWorkoutButton()  {
        driver.findElement(PRINT_WORKOUT_BUTTON).click();
    }

    @Step("Click settings button")
    public void clickSettingsButton() {
        driver.findElement(By.xpath(String.format(USER_BOX_BUTTON, "Settings"))).click();
    }

    @Step("Wait until setting button is displayed")
    public void waitSettingButtonPresent()  {
        waitForElementDisplayed(By.xpath(String.format(USER_BOX_BUTTON, "Settings")));
    }

    public HeaderNavigatePage(WebDriver driver) {
        super(driver);
    }
}
