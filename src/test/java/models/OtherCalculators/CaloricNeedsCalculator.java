package models.OtherCalculators;

import enums.DistTypeCaloricNeeds;
import enums.Gender;
import enums.HeightType;
import enums.WeightType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "set")
public class CaloricNeedsCalculator {
    private String weight;
    private WeightType weightType;
    private String height;
    private String age;
    private String runDistance;
    private Gender gender;
    private DistTypeCaloricNeeds distTypeCaloricNeeds;
    private HeightType heightType;
}
