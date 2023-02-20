package models;

import enums.DistTypeHills;
import enums.HowIfelt;
import enums.PaceType;
import enums.PerceivedEffort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class Hills {
    private String date;
    private String timeOfDay;
    private String workoutName;
    private String workoutDescription;
    private String distanceInput;
    private DistTypeHills distTypeHills;
    private String duration;
    private String pace;
    private PaceType paceType;
    private HowIfelt howIfelt;
    private PerceivedEffort perceivedEffort;
    private String minHr;
    private String avgHr;
    private String maxHr;
    private String caloriesBurned;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hills hills = (Hills) o;
        return Objects.equals(workoutName, hills.workoutName) && Objects.equals(workoutDescription, hills.workoutDescription) && Objects.equals(distanceInput, hills.distanceInput) && distTypeHills == hills.distTypeHills && Objects.equals(duration, hills.duration) && Objects.equals(pace, hills.pace) && howIfelt == hills.howIfelt && Objects.equals(minHr, hills.minHr) && Objects.equals(avgHr, hills.avgHr) && Objects.equals(maxHr, hills.maxHr) && Objects.equals(caloriesBurned, hills.caloriesBurned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutName, workoutDescription, distanceInput, distTypeHills, duration, pace, howIfelt, minHr, avgHr, maxHr, caloriesBurned);
    }

    @Override
    public String toString() {
        return "Hills{" +
                "  workoutName='" + workoutName + '\'' +
                ", workoutDescription='" + workoutDescription + '\'' +
                ", distanceInput='" + distanceInput + '\'' +
                ", distTypeHills=" + distTypeHills +
                ", duration='" + duration + '\'' +
                ", pace='" + pace + '\'' +
                ", howIfelt=" + howIfelt +
                ", minHr='" + minHr + '\'' +
                ", avgHr='" + avgHr + '\'' +
                ", maxHr='" + maxHr + '\'' +
                ", caloriesBurned='" + caloriesBurned + '\'' +
                '}';
    }
}
