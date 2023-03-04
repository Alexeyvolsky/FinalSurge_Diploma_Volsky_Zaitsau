package pages;

import elements.Dropdown;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import models.Report;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutReportPage extends BasePage{
    private final static By VIEW_REPORT_BUTTON = By.id("saveButton");
    private static final By TABLE_ACTIVITY_COLUMN = By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[1]/td[2]");

    @Step("Filling form to report view")
    public void fillformReportView(Report report){
        new Input(driver).clearAndSetValue("WorkoutDate", report.getStartDate());
        new Input(driver).clearAndSetValue("WorkoutDateEnd", report.getEndDate());
        new RadioButton(driver).clickRadiobutton("groupBy", report.getReportView().getValue());
        new Dropdown(driver).selectOptionByText("ActivityType",report.getActivityType().getName());
    }

    @Step("Verify that report button is displayed")
    public boolean reportButtonPresent(){
        return driver.findElement(VIEW_REPORT_BUTTON).isDisplayed();
    }

    @Step("Click report button")
    public void clickReportButton(){
        driver.findElement(VIEW_REPORT_BUTTON).click();
    }

    @Step("Get activity from table")
    public String getActivityFromTable() {
        return driver.findElement(TABLE_ACTIVITY_COLUMN).getText();
    }

    public WorkoutReportPage(WebDriver driver) {
        super(driver);
    }
}
