package models.WorcoutCalculators;

import enums.DistanceMcMillan;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "set")
public class McMillan {
    private DistanceMcMillan distanceMcMillan;
    private String hours;
    private String minutes;
    private String seconds;
}
