package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.DailyVitals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
@Log4j2
public class DailyVitalsPage extends BasePage{
    private final static By ADD_VITALS_BUTTON = By.xpath("//button[@title='Add Vitals']");
    private final static By CUSTOM_VIEW_BUTTON = By.id("CustomLink");
    private final static By VIEW_BUTTON = By.id("viewButton");
    private final static By WEEKTOTALS = By.xpath("//tbody/tr/td/a");
    private final static By LAST_DATE_IN_TABLE = By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[1]/td[1]");

    @Step("Filling form to daily vitals")
    public void fillformDailyVitals(DailyVitals dailyVitals){
        new Input(driver).clearAndSetValue("CDateStart",dailyVitals.getStartDate());
        new Input(driver).clearAndSetValue("CDateEnd",dailyVitals.getEndDate());
    }

    @Step("Verify that add vitals is display")
    public boolean isAddVitalsDisplayed() {
        log.info("verifying that add vitals is display");
        return driver.findElement(ADD_VITALS_BUTTON).isDisplayed();
    }

    @Step("Click custom view button")
    public void clickCustomViewButton(){
        log.info("clicking custom view button");
        driver.findElement(CUSTOM_VIEW_BUTTON).click();
    }

    @Step("Click view button")
    public void clickViewButton(){
        log.info("clicking view button");
        driver.findElement(VIEW_BUTTON).click();
    }

    @Step("Get last date")
    public String getLastDate(){
        log.info("getting last date");
        return driver.findElement(LAST_DATE_IN_TABLE).getText();
    }

    @Step("Get first date")
    public String getFirstDate(){
        log.info("getting first date");
        List<WebElement> amountOfDays= driver.findElements(WEEKTOTALS);
        int i = amountOfDays.size();
        return driver.findElement(By.xpath("//table[contains(@class,'table-striped')]/tbody/tr["+(i)+"]/td[1]")).getText();
    }

    public DailyVitalsPage(WebDriver driver) {
        super(driver);
    }
}
