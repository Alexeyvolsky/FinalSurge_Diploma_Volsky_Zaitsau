package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CalendarPage extends BasePage{

    private final static String ICON_PLUS = "//td[@data-day='%s']//i[@class='icon-plus']";
    private final static By COPY_DAY_BUTTON = By.xpath("//td[@data-day='10']//a[text()='Copy Day']");
    private final static By QUICK_ADD_BUTTON = By.xpath("//td[@data-day='10']//a[text()='Quick Add']");
    private final static String COPY_MOVE_DELETE_BUTTON = "//td[@data-day='10']//a[text()='Copy/Move/Delete']";
    private final static By ADD_WORKOUT_BUTTON = By.id("saveButton");
    private final static String ACTIVITY_NAME = "//td[@data-day='%s']//div[@class='fc-event-activity-title']";
    private final static String NUMBER_OF_WEEK_LOCATOR = "//div[@class='datepicker dropdown-menu' " +
            "and contains (@style, 'display: block;')]//td[@class = 'day ' and contains(text(), '%s')]";
    private final static String COPY_MOVE_DELETE_MODAL_BUTTON = "//div[contains(@style, 'text-align: right; " +
            "font-size: 11px; margin-top: 0px; padding-top: 0px; padding-bottom: 5px;')]//a[text()='%s']";

    public boolean isActivityPresent()  {
        try {
            driver.findElement(By.xpath(String.format(ACTIVITY_NAME, "10")));
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
    public void clickPlusButton(String day)   {
        jsClick(driver.findElement(By.xpath(String.format(ICON_PLUS, day))));
    }

    public void clickCopyDayButton()    {
        jsClick(driver.findElement(COPY_DAY_BUTTON));
    }

    public void clickQuickAddButton(){
        jsClick(driver.findElement(QUICK_ADD_BUTTON));
    }

    public void clickCopyMoveDeleteButton(String day) {
        jsClick(driver.findElement(By.xpath(String.format(COPY_MOVE_DELETE_BUTTON, day))));
    }

    public void clickDeleteModalButton()    {
        driver.findElement(By.xpath(String.format(COPY_MOVE_DELETE_MODAL_BUTTON, "Delete"))).click();
    }

    public void clickNeedData() {
        driver.findElement(By.xpath(String.format(NUMBER_OF_WEEK_LOCATOR, "11"))).click();
    }

    public String getActivityName() {
        return String.valueOf(driver.findElement(By.xpath(String.format(ACTIVITY_NAME, "10"))).getText());
    }

    public String getExpectedActivityName() {
        return String.valueOf(driver.findElement(By.xpath(String.format(ACTIVITY_NAME, "11"))).getText());
    }
    public void clickAddWorkoutButton(){
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }
    public CalendarPage(WebDriver driver) {
        super(driver);
    }
}

