package enums;

public enum WeightType {

    LBS("\n" +
            "                                                    lbs\n" +
            "                                                "),
    KG("kg");

    private final String name;

    WeightType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static WeightType fromString(String value) {
        for (WeightType weightType : WeightType.values()) {
            if (weightType.getName().equals(value)) {
                return weightType;
            }
        }
        return null;
    }
}
