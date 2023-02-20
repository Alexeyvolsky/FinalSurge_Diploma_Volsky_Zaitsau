package enums;

public enum TempType {

    FORENHEIT("F"), CELSIUS("C");

    private final String name;

    TempType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static TempType fromString(String value) {
        for (TempType tempType : TempType.values()) {
            if (tempType.getName().equals(value)) {
                return tempType;
            }
        }
        return null;
    }
}