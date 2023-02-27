package enums;

public enum WeightType {

    LBS("l"), KG("k");

    private final String value;

    WeightType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static WeightType fromString(String value) {
        for (WeightType weightType : WeightType.values()) {
            if (weightType.getValue().equals(value)) {
                return weightType;
            }
        }
        return null;
    }
}
