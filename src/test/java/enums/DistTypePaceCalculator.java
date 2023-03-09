package enums;

public enum DistTypePaceCalculator {

    MILES("mi"), KILOMETERS("km"), METERS("me"), YARDS("yd"), FEET("ft");

    private final String name;

    DistTypePaceCalculator(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static DistTypePaceCalculator fromString(String value) {
        for (DistTypePaceCalculator distTypePaceCalculator : DistTypePaceCalculator.values()) {
            if (distTypePaceCalculator.getName().equals(value)) {
                return distTypePaceCalculator;
            }
        }
        return null;
    }
}