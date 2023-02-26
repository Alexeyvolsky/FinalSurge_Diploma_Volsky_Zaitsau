package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarPage extends BasePage{

    private final static By ICON_PLUS = By.xpath("//td[@data-day='10']//i[@class='icon-plus']");
    private final static By COPY_DAY_BUTTON = By.xpath("//td[@data-day='10']//a[text()='Copy Day']");
    private final static String ACTIVITY_NAME = "//td[@data-day='%s']//div[@class='fc-event-activity-title']";
    private final static String NUMBER_OF_WEEK_LOCATOR = "//div[@class='datepicker dropdown-menu' " +
            "and contains (@style, 'display: block;')]//td[@class = 'day ' and contains(text(), '%s')]";


    public void clickPlusButton()   {
        jsClick(driver.findElement(ICON_PLUS));
    }

    public void clickCopyDayButton()    {
        jsClick(driver.findElement(COPY_DAY_BUTTON));
    }
//    TODO: разобаться с календарем
    public void clickNeedData() {
        driver.findElement(By.xpath(String.format(NUMBER_OF_WEEK_LOCATOR, "11"))).click();
    }

    public String getActivityName() {
        WebElement activityName = driver.findElement(By.xpath(String.format(ACTIVITY_NAME, "10")));
        return String.valueOf(activityName);
    }

    public String getExpectedActivityName() {
        WebElement expectedActivityName = driver.findElement(By.xpath(String.format(ACTIVITY_NAME, "11")));
        return String.valueOf(expectedActivityName);
    }

    public CalendarPage(WebDriver driver) {
        super(driver);
    }
}
