package models.WorcoutCalculators;

import enums.SelectEvent;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "set")
public class Intensity {
    private String hours;
    private String minutes;
    private String seconds;
    private SelectEvent selectEvent;
}