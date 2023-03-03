package pages;

import elements.Input;
import models.DailyVitals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DailyVitalsPage extends BasePage{
    private final static By ADD_VITALS_BUTTON = By.xpath("//button[@title='Add Vitals']");
    private final static By CUSTOM_VIEW_BUTTON = By.id("CustomLink");
    private final static By VIEW_BUTTON = By.id("viewButton");
    private final static By WEEKTOTALS = By.xpath("//tbody/tr/td/a");
    private final static By LAST_DATE_IN_TABLE = By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[1]/td[1]");

    public DailyVitalsPage(WebDriver driver) {
        super(driver);
    }
    public void fillformDailyVitals(DailyVitals dailyVitals){
        new Input(driver).clearAndSetValue("CDateStart",dailyVitals.getStartDate());
        new Input(driver).clearAndSetValue("CDateEnd",dailyVitals.getEndDate());
    }
    public boolean isAddVitalsDisplayed() {
        return driver.findElement(ADD_VITALS_BUTTON).isDisplayed();
    }
    public void clickCustomViewButton(){
        driver.findElement(CUSTOM_VIEW_BUTTON).click();
    }
    public void clickViewButton(){
        driver.findElement(VIEW_BUTTON).click();
    }
    public String getLastDate(){
        return driver.findElement(LAST_DATE_IN_TABLE).getText();
    }
    public String getFirstDate(){
        List<WebElement> amountOfDays= driver.findElements(WEEKTOTALS);
        int i = amountOfDays.size();
        return driver.findElement(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr["+(i)+"]/td[1]")).getText();
    }
}
