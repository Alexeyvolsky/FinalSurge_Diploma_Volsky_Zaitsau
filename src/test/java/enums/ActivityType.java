package enums;

public enum ActivityType {
    RUN("Run"),
    BIKE("Bike"),
    SWIM("Swim"),
    CROSS_TRAINING("Cross Training"),
    WALK("Walk"),
    REST_DAY("Rest Day"),
    STRENGTH_TRAINING("Strength Training"),
    RECOVERY_REHAB("Recovery/Rehab"),
    OTHER("Other"),
    TRANSITION("Transition");

    private final String name;

    ActivityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static ActivityType fromString(String value) {
        for (ActivityType activityType : ActivityType.values()) {
            if (activityType.getName().equals(value)) {
                return activityType;
            }
        }
        return null;
    }
}
