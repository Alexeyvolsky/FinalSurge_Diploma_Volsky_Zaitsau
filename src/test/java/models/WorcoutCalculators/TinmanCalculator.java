package models.WorcoutCalculators;

import enums.DistanceTinman;
import enums.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "set")
public class TinmanCalculator {
    private DistanceTinman distanceTinman;
    private String hours;
    private String minutes;
    private String seconds;
    private Gender gender;
}
