package models.WorcoutCalculators;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "set")
public class Palladino {
    private String criticalPower;
    private String reserveWorkCapacity;
    private String minutes;
    private String seconds;
    private String shortTest;
    private String longTest;
    private String hours;
    private String raceAvgPower;
}
