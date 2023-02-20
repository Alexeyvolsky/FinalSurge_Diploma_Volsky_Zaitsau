package modals;

import elements.Dropdown;
import elements.Input;
import elements.RadioButtonWorkouts;
import elements.TextArea;
import models.Hills;
import models.Rest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewWorkoutModal extends BaseModal{
    private final static By ADD_WORKOUT_BUTTON=By.id("saveButton");

    public void fillformRest(Rest workout){
        new Input(driver).clearAndSetValue("WorkoutDate", workout.getDate());
        new Input(driver).setValue("Name", workout.getWorkoutName());
        new TextArea(driver).setValue("Desc", workout.getWorkoutDescription());
    }
    public void fillformHills(Hills hills){
        new Input(driver).clearAndSetValue("WorkoutDate", hills.getDate());
        new Input(driver).setValue("WorkoutTime",hills.getTimeOfDay());
        new Input(driver).setValue("Name", hills.getWorkoutName());
        new TextArea(driver).setValue("Desc", hills.getWorkoutDescription());
        new Input(driver).setValue("Distance", hills.getDistanceInput());
        new Dropdown(driver).selectOption("DistType", hills.getDistTypeHills().getName());
        new Input(driver).setValue("Duration",hills.getDuration());
        new Input(driver).clearAndSetValue("Pace",hills.getPace());
        new Dropdown(driver).selectOption("PaceType",hills.getPaceType().getName());
        new RadioButtonWorkouts(driver).clickRadiobuttonWorkouts(hills.getHowIfelt().getName());
        new Dropdown(driver).selectOption("PerEffort",hills.getPerceivedEffort().getName());
        new Input(driver).setValue("MinHR",hills.getMinHr());
        new Input(driver).setValue("AvgHR",hills.getAvgHr());
        new Input(driver).setValue("MaxHR", hills.getMaxHr());
        new Input(driver).setValue("kCal",hills.getCaloriesBurned());
    }

    public AddNewWorkoutModal(WebDriver driver) {
        super(driver);
    }
    public void clickAddWorkoutButton(){
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }
}
