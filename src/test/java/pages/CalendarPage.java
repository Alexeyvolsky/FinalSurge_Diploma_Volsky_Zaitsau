package pages;

import enums.Day;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CalendarPage extends BasePage{

    private final static String ICON_PLUS = "//td[@data-day='%s']//i[@class='icon-plus']";
    private final static By COPY_DAY_BUTTON = By.xpath("//td[@data-day='10']//a[text()='Copy Day']");
    private final static By QUICK_ADD_BUTTON = By.xpath("//td[@data-day='10']//a[text()='Quick Add']");
    private final static By ADD_WORKOUT_BUTTON = By.id("saveButton");
    private final static String ACTIVITY_NAME = "//td[@data-day='%s']//div[@class='fc-event-activity-title']";
    private final static String NUMBER_OF_WEEK_LOCATOR = "//div[@class='datepicker dropdown-menu' " +
            "and contains (@style, 'display: block;')]//td[@class = 'day ' and contains(text(), '%s')]";

    public boolean isActivityPresent()  {
        try {
            driver.findElement(By.xpath(String.format(ACTIVITY_NAME, Day.TEN_DAY.getName())));
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public void clickPlusButton(Day day)   {
        jsClick(driver.findElement(By.xpath(String.format(ICON_PLUS, day.getName()))));
    }

    public void clickCopyDayButton()    {
        jsClick(driver.findElement(COPY_DAY_BUTTON));
    }

    public void clickQuickAddButton(){
        jsClick(driver.findElement(QUICK_ADD_BUTTON));
    }

    public void clickNeedData(Day day) {
        driver.findElement(By.xpath(String.format(NUMBER_OF_WEEK_LOCATOR, day.getName()))).click();
    }

    public String getActivityForTheTenthDay() {
        return String.valueOf(driver.findElement(By.xpath(String.format(ACTIVITY_NAME, Day.TEN_DAY.getName()))).getText());
    }

    public String getActivityForTheEleventhDay() {
        return String.valueOf(driver.findElement(By.xpath(String.format(ACTIVITY_NAME, Day.ELEVEN_DAY.getName()))).getText());
    }

    public void clickAddWorkoutButton(){
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }

    public CalendarPage(WebDriver driver) {
        super(driver);
    }
}

