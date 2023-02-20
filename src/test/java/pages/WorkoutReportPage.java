package pages;

import elements.Dropdown;
import elements.Input;
import elements.RadioButtonReport;
import models.Report;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutReportPage extends BasePage{
    private final static By VIEW_REPORT_BUTTON = By.id("saveButton");
    private static final By TABLE_ACTIVITY_COLUMN = By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[1]/td[2]");

    public WorkoutReportPage(WebDriver driver) {
        super(driver);
    }
    public void fillformReportView(Report report){
        new Input(driver).clearAndSetValue("WorkoutDate", report.getStartDate());
        new Input(driver).clearAndSetValue("WorkoutDateEnd", report.getEndDate());
        new RadioButtonReport(driver).clickReportRadiobutton(report.getReportView().getName());
        new Dropdown(driver).selectOptionByText("ActivityType",report.getActivityType().getName());
    }
    public boolean reportButtonPresent(){
        return driver.findElement(VIEW_REPORT_BUTTON).isDisplayed();
    }
    public void clickReportButton(){
        driver.findElement(VIEW_REPORT_BUTTON).click();
    }
    public String getActivityFromTable() {
        return driver.findElement(TABLE_ACTIVITY_COLUMN).getText();
    }
}
