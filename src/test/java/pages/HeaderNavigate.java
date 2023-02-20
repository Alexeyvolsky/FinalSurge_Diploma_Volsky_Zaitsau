package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderNavigate extends BasePage    {

    private final static By DASHBOARD_BUTTON = By.xpath("//i[@class='icsw16-home']");
    private final static By CALENDAR_BUTTON = By.xpath("//i[@class='icsw16-day-calendar']");
    private final static By WORKOUT_CALCULATORS_BUTTON = By.xpath("//i[@class='icsw16-stop-watch']");
    private final static By OTHER_CALCULATORS_BUTTON = By.xpath("//i[@class='icsw16-calculator']");
    private final static By REPORTS_AND_STATISTICS_BUTTON = By.xpath("//i[@class='icsw16-graph']");
    private final static By MAILBOX_BUTTON = By.xpath("//i[@class='icsw16-mail']");
    private final static By PRINT_WORKOUT_BUTTON = By.xpath("//i[@class='icsw16-printer']");
    private final static String USER_BOX_BUTTON = "//a[text()='%s']";
    private final static By FINAL_SURGE_LOGO = By.xpath("//img[@alt='Final Surge']");

    public void clickDashboardButton()  {
        driver.findElement(DASHBOARD_BUTTON).click();
    }

    public void clickCalendarButton()  {
        driver.findElement(CALENDAR_BUTTON).click();
    }

    public void clickWorkoutCalculateButton()  {
        driver.findElement(WORKOUT_CALCULATORS_BUTTON).click();
    }

    public void clickOtherCalculatorsButton()  {
        driver.findElement(OTHER_CALCULATORS_BUTTON).click();
    }

    public void clickReportAndStatisticsButton()  {
        driver.findElement(REPORTS_AND_STATISTICS_BUTTON).click();
    }

    public void clickMailboxButton()  {
        driver.findElement(MAILBOX_BUTTON).click();
    }

    public void clickPrintWorkoutButton()  {
        driver.findElement(PRINT_WORKOUT_BUTTON).click();
    }

    public void clickSettingsButton() {
        driver.findElement(By.xpath(String.format(USER_BOX_BUTTON, "Settings"))).click();
    }

    public void clickLogo() {
        driver.findElement(FINAL_SURGE_LOGO).click();
    }

    public void waitSettingButtonPresent()  {
        waitForElementDisplayed(By.xpath(String.format(USER_BOX_BUTTON, "Settings")));
    }

    public HeaderNavigate(WebDriver driver) {
        super(driver);
    }
}
