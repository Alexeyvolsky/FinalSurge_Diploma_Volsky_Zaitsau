package modals;

import elements.Dropdown;
import elements.Input;
import elements.RadioButtonWorkouts;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Hills;
import models.Rest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class AddNewWorkoutModal extends BaseModal{
    private final static By ADD_WORKOUT_BUTTON=By.id("saveButton");

    @Step("Filling form to rest workout modal")
    public void fillformRest(Rest workout){
        new Input(driver).clearAndSetValue("WorkoutDate", workout.getDate());
        new Input(driver).setValue("Name", workout.getWorkoutName());
        new TextArea(driver).setValue("Desc", workout.getWorkoutDescription());
    }

    @Step("Filling form to hills workout modal")
    public void fillformHills(Hills hills){
        new Input(driver).clearAndSetValue("WorkoutDate", hills.getDate());
        new Input(driver).setValue("WorkoutTime",hills.getTimeOfDay());
        new Input(driver).setValue("Name", hills.getWorkoutName());
        new TextArea(driver).setValue("Desc", hills.getWorkoutDescription());
        new Input(driver).setValue("Distance", hills.getDistanceInput());
        new Dropdown(driver).selectOptionByValue("DistType", hills.getDistTypeHills().getName());
        new Input(driver).setValue("Duration",hills.getDuration());
        new Input(driver).clearAndSetValue("Pace",hills.getPace());
        new Dropdown(driver).selectOptionByValue("PaceType",hills.getPaceType().getName());
        new RadioButtonWorkouts(driver).clickRadiobutton(hills.getHowIfelt().getName());
        new Dropdown(driver).selectOptionByValue("PerEffort",hills.getPerceivedEffort().getName());
        new Input(driver).setValue("MinHR",hills.getMinHr());
        new Input(driver).setValue("AvgHR",hills.getAvgHr());
        new Input(driver).setValue("MaxHR", hills.getMaxHr());
        new Input(driver).setValue("kCal",hills.getCaloriesBurned());
    }

    @Step("Click add workout button")
    public void clickAddWorkoutButton(){
        log.info("clicking add workout button");
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }

    public AddNewWorkoutModal(WebDriver driver) {
        super(driver);
    }
}
