package enums;

public enum HeightType {

    INCHES("i"), CENTIMETERS("m");

    private final String value;

    HeightType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static HeightType fromString(String value) {
        for (HeightType heightType : HeightType.values()) {
            if (heightType.getValue().equals(value)) {
                return heightType;
            }
        }
        return null;
    }
}
