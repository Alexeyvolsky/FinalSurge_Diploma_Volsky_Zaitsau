package pages;

import enums.DistTypeHills;
import enums.HowIfelt;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Hills;
import models.Rest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class WorkoutDetailsPage extends BasePage {

    private final static By VIEW_YOUR_WORKOUT= By.xpath("//span[text()='View and Edit your workout.']");
    private final static By ACTUAL_NAME = By.xpath("//span[@class='activityTypeName']/parent::div/following-sibling::div");
    private final static By ACTUAL_DESCRIPTION = By.xpath("//small[contains(text(),'Description:')]/ancestor::p");
    private final static String ACTUAL_WORKOUT_STATISTICS = "//div[@class='formSep']//span[@class='%s']";
    private final static By ACTUAL_HOW_I_FELT = By.xpath("//span[@class='label label-success']");
    private final static By ACTUAL_FORM_SEP = By.xpath("//p[@class = 'formSep']");
    private final static By ACTUAL_CALORIES_BURNED = By.xpath("//p[@class='formSep']//ancestor-or-self::span");

    @Step("Get workout details rest")
    public Rest getWorkoutDetailsRest(){
        log.info("getting workout details rest");
        Rest workoutDetailsRest = new Rest();
        workoutDetailsRest.setWorkoutName(getActualName());
        workoutDetailsRest.setWorkoutDescription(getActualDescription());
        return workoutDetailsRest;

    }

    @Step("Get workout details hills")
    public Hills getWorkoutDetailsHills(){
        log.info("getting workout details hills");
        Hills workoutDetailsHills = new Hills();
        workoutDetailsHills.setWorkoutName(getActualName());
        workoutDetailsHills.setWorkoutDescription(getActualDescription());
        workoutDetailsHills.setDistanceInput(getActualDistanceInput("label label-info"));
        workoutDetailsHills.setDistTypeHills(DistTypeHills.fromString(getActualDistTypeHills("label label-info")));
        workoutDetailsHills.setDuration(getActualDuration("label label-info"));
        workoutDetailsHills.setPace(getActualPace("label label"));
        workoutDetailsHills.setHowIfelt(HowIfelt.fromString(getActualFelt()));
        workoutDetailsHills.setMinHr(getActualMinHr());
        workoutDetailsHills.setAvgHr(getActualAvgHr());
        workoutDetailsHills.setMaxHr(getActualMaxHr());
        workoutDetailsHills.setCaloriesBurned(getActualCaloriesBurned());
        return workoutDetailsHills;
    }

    @Step("Verify that view your workout is Display")
    public boolean isViewYourWorkoutPresent(){
        log.info("verifying that view your workout is display");
        return driver.findElement(VIEW_YOUR_WORKOUT).isDisplayed();
    }

    @Step("Get actual name")
    public String getActualName(){
        log.info("getting actual name");
        return driver.findElement(ACTUAL_NAME).getText();
    }

    @Step("Get actual description")
    public String getActualDescription(){
        log.info("getting actual description");
        return driver.findElement(ACTUAL_DESCRIPTION).getText().split(":")[1].trim();
    }

    @Step("Get actual distance")
    public String getActualDistanceInput(String clas){
        log.info("getting actual distance");
        return driver.findElement(By.xpath(String.format(ACTUAL_WORKOUT_STATISTICS, clas))).getText().split(" ")[0].trim();
    }

    @Step("Get actual DistType hills")
    public String getActualDistTypeHills(String clas){
        log.info("getting actual disttype hills");
        return driver.findElement(By.xpath(String.format(ACTUAL_WORKOUT_STATISTICS,clas))).getText().split(" ")[1].trim();
    }

    @Step("Get actual duration")
    public String getActualDuration(String clas){
        log.info("getting actual duration");
        return driver.findElement(By.xpath(String.format(ACTUAL_WORKOUT_STATISTICS,clas))).getText().split(" ")[3].trim();
    }

    @Step("Get actual pace")
    public String getActualPace(String clas){
        log.info("getting actual duration");
        return driver.findElement(By.xpath(String.format(ACTUAL_WORKOUT_STATISTICS,clas))).getText().split(" ")[0].trim();
    }

    @Step("Get actual felt")
    public String getActualFelt(){
        log.info("getting actual felt");
        return driver.findElement(ACTUAL_HOW_I_FELT).getText().split(" ")[0].trim();
    }

    @Step("Get actual MinHr")
    public String getActualMinHr(){
        log.info("getting actual Minhr");
        return driver.findElement(ACTUAL_FORM_SEP).getText().split(" ")[2].trim();
    }

    @Step("Get actual AvgHr")
    public String getActualAvgHr(){
        log.info("getting actual Avghr");
        return driver.findElement(ACTUAL_FORM_SEP).getText().split(" ")[8].trim();
    }

    @Step("Get actual MaxHr")
    public String getActualMaxHr(){
        log.info("getting actual Maxhr");
        return driver.findElement(ACTUAL_FORM_SEP).getText().split(" ")[15].trim();
    }

    @Step("Get actual calories burned")
    public String getActualCaloriesBurned(){
        log.info("getting actual calories burned");
        return driver.findElement(ACTUAL_CALORIES_BURNED).getText().split(" ")[2].trim();
    }

    public WorkoutDetailsPage(WebDriver driver) {
        super(driver);
    }
}
