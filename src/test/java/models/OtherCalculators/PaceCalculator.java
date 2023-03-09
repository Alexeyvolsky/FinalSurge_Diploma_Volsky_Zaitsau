package models.OtherCalculators;

import enums.DistTypePaceCalculator;
import enums.RaceDist;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "set")
public class PaceCalculator {
    private String runDistance;
    private DistTypePaceCalculator distTypePaceCalculator;
    private RaceDist raceDist;
    private String hours;
    private String minutes;
    private String seconds;
}
