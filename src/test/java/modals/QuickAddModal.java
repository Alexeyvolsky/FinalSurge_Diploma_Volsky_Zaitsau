package modals;

import elements.Dropdown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import models.QuickAdd;
import org.openqa.selenium.WebDriver;

public class QuickAddModal extends BaseModal{

    @Step("Filling form to quick add")
    public void fillformQuickAdd(QuickAdd quickAdd){
        new Input(driver).clearAndSetValue("WorkoutDate",quickAdd.getDate());
        new Input(driver).setValue("WorkoutTime",quickAdd.getTimeOfDay());
        new Dropdown(driver).selectOptionByText("ActivityType",quickAdd.getActivityType().getName());
        new Input(driver).setValue("Name",quickAdd.getWorkoutName());
        new TextArea(driver).setValue("Desc",quickAdd.getWorkoutDescription());
        new Input(driver).setValue("Distance",quickAdd.getDistanceInput());
        new Dropdown(driver).selectOptionByText("DistType",quickAdd.getDistTypeHills().getName());
        new Input(driver).setValue("Duration",quickAdd.getDuration());
        new Input(driver).clearAndSetValue("Pace",quickAdd.getPace());
        new Dropdown(driver).selectOption("PaceType",quickAdd.getPaceType().getName());
        new Dropdown(driver).selectOptionByText("HowFeel",quickAdd.getHowIfelt().getName());
        new Dropdown(driver).selectOption("PerEffort",quickAdd.getPerceivedEffort().getName());
        new TextArea(driver).setValue("PostDesc",quickAdd.getPostWorkoutsNotes());
    }

    public QuickAddModal(WebDriver driver) {
        super(driver);
    }
}
