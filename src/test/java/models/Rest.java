package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class Rest {
    private String date;
    private String workoutName;
    private String workoutDescription;


    @Override
    public String toString() {
        return "Workout{" +
                "workoutName='" + workoutName + '\'' +
                ", workoutDescription='" + workoutDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rest workout = (Rest) o;
        return Objects.equals(workoutName, workout.workoutName) && Objects.equals(workoutDescription, workout.workoutDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutName, workoutDescription);
    }
}
