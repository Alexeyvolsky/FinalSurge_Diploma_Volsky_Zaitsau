package enums;

public enum DistTypeCaloricNeeds {

    MILES("m"), KILOMETERS("k");

    private final String value;

    DistTypeCaloricNeeds(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static DistTypeCaloricNeeds fromString(String value) {
        for (DistTypeCaloricNeeds distTypeCaloricNeeds : DistTypeCaloricNeeds.values()) {
            if (distTypeCaloricNeeds.getValue().equals(value)) {
                return distTypeCaloricNeeds;
            }
        }
        return null;
    }
}
