package pages;

import enums.Day;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
@Log4j2
public class CalendarPage extends BasePage{

    private final static String ICON_PLUS = "//td[@data-day='%s']//i[@class='icon-plus']";
    private final static By COPY_DAY_BUTTON = By.xpath("//td[@data-day='10']//a[text()='Copy Day']");
    private final static By QUICK_ADD_BUTTON = By.xpath("//td[@data-day='10']//a[text()='Quick Add']");
    private final static By ADD_WORKOUT_BUTTON = By.id("saveButton");
    private final static String ACTIVITY_NAME = "//td[@data-day='%s']//div[@class='fc-event-activity-title']";
    private final static String NUMBER_OF_WEEK_LOCATOR = "//div[@class='datepicker dropdown-menu' " +
            "and contains (@style, 'display: block;')]//td[@class = 'day ' and contains(text(), '%s')]";

    public boolean isActivityPresent()  {
        log.debug("verifying that activity present ");
        try {
            driver.findElement(By.xpath(String.format(ACTIVITY_NAME, Day.TEN_DAY.getName()))).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Click plus button in calendar")
    public void clickPlusButton(Day day)   {
        log.info("clicking plus button in calendar");
        jsClick(driver.findElement(By.xpath(String.format(ICON_PLUS, day.getName()))));
    }

    @Step("Click copy day button")
    public void clickCopyDayButton()    {
        log.info("clicking copy day button");
        jsClick(driver.findElement(COPY_DAY_BUTTON));
    }

    @Step("Click quick add button")
    public void clickQuickAddButton(){
        log.info("clicking quick add button");
        jsClick(driver.findElement(QUICK_ADD_BUTTON));
    }

    @Step("Click need data")
    public void clickNeedData(Day day) {
        log.info("clicking need data");
        driver.findElement(By.xpath(String.format(NUMBER_OF_WEEK_LOCATOR, day.getName()))).click();
    }

    @Step("Get activity for the tenth day")
    public String getActivityForTheTenthDay() {
        log.info("getting activity for the tenth day");
        return String.valueOf(driver.findElement(By.xpath(String.format(ACTIVITY_NAME, Day.TEN_DAY.getName()))).getText());
    }

    @Step("Get activity for the eleventh day")
    public String getActivityForTheEleventhDay() {
        log.info("getting activity for the eleventh day");
        return String.valueOf(driver.findElement(By.xpath(String.format(ACTIVITY_NAME, Day.ELEVEN_DAY.getName()))).getText());
    }

    @Step("Click add workout button")
    public void clickAddWorkoutButton(){
        log.info("clicking add workout button");
        scrollIntoView(driver.findElement(ADD_WORKOUT_BUTTON));
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }

    public void waitAddWorkoutButton()   {
        log.debug("waiting for add workout button loaded");
        waitForElementDisplayed(ADD_WORKOUT_BUTTON);
    }

    public CalendarPage(WebDriver driver) {
        super(driver);
    }
}

