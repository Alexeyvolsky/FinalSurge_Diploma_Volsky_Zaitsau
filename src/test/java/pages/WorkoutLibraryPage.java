package pages;

import elements.Dropdown;
import elements.Input;
import enums.ActivityType;
import enums.DistTypeHills;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class WorkoutLibraryPage extends BasePage{
    private final static By ADD_WORKOUT_BUTTON = By.id("saveButton");
    private final static String LIBRARY_ACTIVITY_LOCATOR = "//div[@class='w-box-header']//h4[text()='%s']";
    private final static By ACTUAL_ACTIVITY_TYPE = By.xpath("//table[contains(@class,'table table-condensed table-hover')]/tbody/tr[1]/td[1]");
    private final static By ACTUAL_WORKOUT_NAME = By.xpath("//table[contains(@class,'table table-condensed table-hover')]/tbody/tr[1]/td[2]");
    private final static By ACTUAL_WORKOUT_DESCRIPTION = By.xpath("//table[contains(@class,'table table-condensed table-hover')]/tbody/tr[1]/td[3]");
    private final static By ACTUAL_DISTANCE = By.xpath("//table[contains(@class,'table table-condensed table-hover')]/tbody/tr[1]/td[4]");
    private final static By ACTUAL_DURATION = By.xpath("//table[contains(@class,'table table-condensed table-hover')]/tbody/tr[1]/td[5]");

    @Step("Filling form to print library")
    public void fillformLibrary(WorkoutLibrary workoutLibrary){
        new Dropdown(driver).selectOptionByText("ActivityType",workoutLibrary.getActivityType().getName());
        new Input(driver).setValue("Name",workoutLibrary.getWorkoutName());
        new Input(driver).setValue("Desc",workoutLibrary.getWorkoutDescription());
        new Input(driver).setValue("PDistance",workoutLibrary.getPlannedDistanceInput());
        new Dropdown(driver).selectOptionByText("PDistType",workoutLibrary.getDistTypeHills().getName());
        new Input(driver).setValue("PDuration",workoutLibrary.getPlannedDuration());
    }

    @Step("Get library workout details data")
    public WorkoutLibrary getWorkoutLibraryDetails(){
        log.info("get details workout library");
        WorkoutLibrary workoutLibraryDetails = new WorkoutLibrary();
        workoutLibraryDetails.setActivityType(ActivityType.fromString(getActualActivityType()));
        workoutLibraryDetails.setWorkoutName(getActualWorkoutName());
        workoutLibraryDetails.setWorkoutDescription(getActualWorkoutDescription());
        workoutLibraryDetails.setPlannedDistanceInput(getActualDistanceInput());
        workoutLibraryDetails.setDistTypeHills(DistTypeHills.fromString(getActualDistance()));
        workoutLibraryDetails.setPlannedDuration(getActualDuration());
        return workoutLibraryDetails;
    }

    public boolean addWorkoutButtonPresent(){
        log.debug("verifying that workout button is display ");
        return driver.findElement(ADD_WORKOUT_BUTTON).isDisplayed();
    }

    @Step("Click add workout button")
    public void clickAddWorkoutButton(){
        log.info("clicking add workout button");
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }

    @Step("Click run button")
    public void clickRunButton(){
        log.info("clicking run button");
        driver.findElement(By.xpath(String.format(LIBRARY_ACTIVITY_LOCATOR, "Run"))).click();
    }

    @Step("Get actual activity type")
    public String getActualActivityType(){
        log.info("getting actual activity type");
        return driver.findElement(ACTUAL_ACTIVITY_TYPE).getText();
    }

    @Step("Get actual workout name")
    public String getActualWorkoutName(){
        log.info("getting actual workout name");
        return driver.findElement(ACTUAL_WORKOUT_NAME).getText();
    }

    @Step("Get actual workout description")
    public String getActualWorkoutDescription(){
        log.info("getting actual workout description");
        return driver.findElement(ACTUAL_WORKOUT_DESCRIPTION).getText();
    }

    @Step("Get actual distance input")
    public String getActualDistanceInput(){
        log.info("getting actual distance input");
        return driver.findElement(ACTUAL_DISTANCE).getText().split(" ")[0].trim();
    }

    @Step("Get actual distance")
    public String getActualDistance(){
        log.info("getting actual distance");
        return driver.findElement(ACTUAL_DISTANCE).getText().split(" ")[1].trim();
    }

    @Step("Get actual duration")
    public String getActualDuration(){
        log.info("getting actual duration");
        return driver.findElement(ACTUAL_DURATION).getText();
    }

    public WorkoutLibraryPage(WebDriver driver) {
        super(driver);
    }
}
