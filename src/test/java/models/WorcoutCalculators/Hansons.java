package models.WorcoutCalculators;

import enums.DistTypeHansons;
import enums.RaceDist;
import enums.SpeedType;
import enums.TempType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "set")
public class Hansons {
    private String hours;
    private String minutes;
    private String seconds;
    private String temperature;
    private String humidity;
    private String windSpeed;
    private RaceDist raceDist;
    private DistTypeHansons distTypeHansons;
    private TempType tempType;
    private SpeedType speedType;
}
