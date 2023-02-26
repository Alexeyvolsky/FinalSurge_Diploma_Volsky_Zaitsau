package models;

import enums.ActivityType;
import enums.DistTypeHills;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class WorkoutLibrary {
    private ActivityType activityType;
    private String workoutName;
    private String workoutDescription;
    private String plannedDistanceInput;
    private DistTypeHills distTypeHills;
    private String plannedDuration;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutLibrary that = (WorkoutLibrary) o;
        return Objects.equals(workoutName, that.workoutName) && Objects.equals(workoutDescription, that.workoutDescription) && Objects.equals(plannedDistanceInput, that.plannedDistanceInput) && distTypeHills == that.distTypeHills && Objects.equals(plannedDuration, that.plannedDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutName, workoutDescription, plannedDistanceInput, distTypeHills, plannedDuration);
    }

    @Override
    public String toString() {
        return "WorkoutLibrary{" +
                "activityType=" + activityType +
                ", workoutName='" + workoutName + '\'' +
                ", workoutDescription='" + workoutDescription + '\'' +
                ", plannedDistanceInput='" + plannedDistanceInput + '\'' +
                ", distTypeHills=" + distTypeHills +
                ", plannedDuration='" + plannedDuration + '\'' +
                '}';
    }
}
