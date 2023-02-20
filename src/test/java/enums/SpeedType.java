package enums;

public enum SpeedType {

    MOLES_PER_HOUR("mph"), KILOMETERS_PER_HOUR("kph");

    private final String name;

    SpeedType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static SpeedType fromString(String value) {
        for (SpeedType speedType : SpeedType.values()) {
            if (speedType.getName().equals(value)) {
                return speedType;
            }
        }
        return null;
    }
}