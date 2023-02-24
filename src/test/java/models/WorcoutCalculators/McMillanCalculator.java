package models.WorcoutCalculators;

import enums.DistanceMcMillan;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "set")
public class McMillanCalculator {
    private DistanceMcMillan distanceMcMillan;
    private String hours;
    private String minutes;
    private String seconds;
}
