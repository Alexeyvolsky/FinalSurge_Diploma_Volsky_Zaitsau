package models;

import enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class QuickAdd {
    private String date;
    private String timeOfDay;
    private ActivityType activityType;
    private String workoutName;
    private String workoutDescription;
    private String distanceInput;
    private DistTypeHills distTypeHills;
    private String duration;
    private String pace;
    private PaceType paceType;
    private HowIfelt howIfelt;
    private PerceivedEffort perceivedEffort;
    private String postWorkoutsNotes;
}
