package pages;

import enums.DistTypeHills;
import enums.HowIfelt;
import io.qameta.allure.Step;
import models.Hills;
import models.Rest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        Rest workoutDetailsRest = new Rest();
        workoutDetailsRest.setWorkoutName(getActualName());
        workoutDetailsRest.setWorkoutDescription(getActualDescription());
        return workoutDetailsRest;

    }

    @Step("Get workout details hills")
    public Hills getWorkoutDetailsHills(){
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
        return driver.findElement(VIEW_YOUR_WORKOUT).isDisplayed();
    }

    @Step("Get and split actual name")
    public String getActualName(){
        return driver.findElement(ACTUAL_NAME).getText();
    }

    @Step("Get and split actual description")
    public String getActualDescription(){
        return driver.findElement(ACTUAL_DESCRIPTION).getText().split(":")[1].trim();
    }

    @Step("Get and split actual distance")
    public String getActualDistanceInput(String clas){
        return driver.findElement(By.xpath(String.format(ACTUAL_WORKOUT_STATISTICS, clas))).getText().split(" ")[0].trim();
    }

    @Step("Get and split actual DistType hills")
    public String getActualDistTypeHills(String clas){
        return driver.findElement(By.xpath(String.format(ACTUAL_WORKOUT_STATISTICS,clas))).getText().split(" ")[1].trim();
    }

    @Step("Get and split actual duration")
    public String getActualDuration(String clas){
        return driver.findElement(By.xpath(String.format(ACTUAL_WORKOUT_STATISTICS,clas))).getText().split(" ")[3].trim();
    }

    @Step("Get and split actual pace")
    public String getActualPace(String clas){
        return driver.findElement(By.xpath(String.format(ACTUAL_WORKOUT_STATISTICS,clas))).getText().split(" ")[0].trim();
    }

    @Step("Get and split actual file")
    public String getActualFelt(){
        return driver.findElement(ACTUAL_HOW_I_FELT).getText().split(" ")[0].trim();
    }

    @Step("Get and split actual MinHr")
    public String getActualMinHr(){
        return driver.findElement(ACTUAL_FORM_SEP).getText().split(" ")[2].trim();
    }

    @Step("Get and split actual AvgHr")
    public String getActualAvgHr(){
        return driver.findElement(ACTUAL_FORM_SEP).getText().split(" ")[8].trim();
    }

    @Step("Get and split actual MaxHr")
    public String getActualMaxHr(){
        return driver.findElement(ACTUAL_FORM_SEP).getText().split(" ")[15].trim();
    }

    @Step("Get and split actual calories burned")
    public String getActualCaloriesBurned(){
        return driver.findElement(ACTUAL_CALORIES_BURNED).getText().split(" ")[2].trim();
    }

    public WorkoutDetailsPage(WebDriver driver) {
        super(driver);
    }
}
