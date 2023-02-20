package models;

import enums.ActivityType;
import enums.ReportView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class Report {
    private String startDate;
    private String endDate;
    private ReportView reportView;
    private ActivityType activityType;

}
