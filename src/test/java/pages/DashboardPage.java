package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
@Log4j2
public class DashboardPage extends BasePage{
    private final static By USER_ICON = By.id("LayoutProfilePic");
    private final static By LOGOUT_BUTTON = By.xpath("//a[text()='Logout']");
    private final static By WORKOUTS_MENU = By.xpath("//a[text()='Workouts']");
    private final static By DAILY_VITALS = By.xpath("//a[text()='Daily Vitals']");
    private final static By VIEW_ADD_VITALS_BUTTON = By.xpath("//a[text()='View & Add Vitals']");
    private final static String WORKOUTS_BUTTONS = "//a[text()='%s']";

    @Step("Verify that user icon is displayed")
    public boolean isUserIconPresent() {
        log.info("verifying that user icon is displayed");
        return driver.findElement(USER_ICON).isDisplayed();
    }

    @Step("Click logout button")
    public void clickLogoutButton(){
        log.info("clicking logout button");
        driver.findElement(LOGOUT_BUTTON).click();
    }

    @Step("Hover to workout menu")
    public void moveToWorkoutsMenu(){
        log.info("hovering to workouts menu");
        Actions actions =new Actions(driver);
        actions.moveToElement(driver.findElement(WORKOUTS_MENU)).perform();
    }

    @Step("Hover to daily vitals menu")
    public void moveToDailyVitalsMenu(){
        log.info("hovering to daily vitals menu");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(DAILY_VITALS)).perform();
    }

    @Step("Click view and add vitals button")
    public void clickViewAndAddVitalsButton(){
        log.info("clicking view and add vitals button");
        driver.findElement(VIEW_ADD_VITALS_BUTTON).click();
    }

    @Step("Click workout button")
       public void clickWorkoutsButton(){
        log.info("clicking workout button");
        driver.findElement(By.xpath(String.format(WORKOUTS_BUTTONS, "Add Workout"))).click();
    }

    @Step("Click workout library button")
        public void clickWorkoutsLibraryButton(){
        log.info("clicking workout library button");
        driver.findElement(By.xpath(String.format(WORKOUTS_BUTTONS,"Workout Library"))).click();
    }

    @Step("Click workout report button")
    public void clickWorkoutsReportButton(){
        log.info("clicking workout report button");
        driver.findElement(By.xpath(String.format(WORKOUTS_BUTTONS, "Reports & Statistics"))).click();
    }

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
}
