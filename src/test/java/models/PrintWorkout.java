package models;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder(setterPrefix = "set")
public class PrintWorkout {
    private String startingData;
    private String endingData;
    private String workoutsData;

    public PrintWorkout(PrintWorkoutBuilder printWorkoutBuilder)    {
        this.startingData = printWorkoutBuilder.startingData;
        this.endingData = printWorkoutBuilder.endingData;
        this.workoutsData = printWorkoutBuilder.workoutsData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintWorkout that = (PrintWorkout) o;
        return Objects.equals(workoutsData, that.workoutsData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutsData);
    }

    @Override
    public String toString() {
        return workoutsData;
    }

    public static class PrintWorkoutBuilder {
        public PrintWorkout build()   {
            if (this.workoutsData == null)  {
                String startingData = Objects.isNull(this.startingData) ? "" : this.startingData;
                String endingData = Objects.isNull(this.endingData) ? "" : this.endingData;
                this.workoutsData = ("Workouts: " + startingData + " - " + endingData).trim();
                return new PrintWorkout(this);
            }
            return new PrintWorkout(this);
        }
    }
}