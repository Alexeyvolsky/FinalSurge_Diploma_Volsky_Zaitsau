package enums;

public enum HeightType {

    INCHES("\n" +
            "                                                    inches\n" +
            "                                                "),
    CENTIMETERS("\n" +
            "                                                    centimeters\n" +
            "                                                ");

    private final String name;

    HeightType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static HeightType fromString(String value) {
        for (HeightType heightType : HeightType.values()) {
            if (heightType.getName().equals(value)) {
                return heightType;
            }
        }
        return null;
    }
}
