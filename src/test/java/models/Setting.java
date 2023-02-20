package models;

import enums.Country;
import enums.Gender;
import enums.Region;
import enums.WeightType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "set")
public class Setting    {
    private Gender gender;
    private String birthday;
    private String weight;
    private WeightType weightType;
    private Country country;
    private Region region;
    private String city;
    private String postalCode;
}