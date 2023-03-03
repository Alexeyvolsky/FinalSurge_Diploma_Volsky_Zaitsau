package enums;

public enum Gender {

    MALE("m", "M"), FEMALE("f", "F");

    private final String value;
    private final String anotherValue;

    Gender(String value, String anotherValue) {
        this.value = value;
        this.anotherValue = anotherValue;
    }

    public String getValue() {
        return this.value;
    }

    public String getAnotherValue() {
        return this.anotherValue;
    }

    public static Gender fromString(String value) {
        for (Gender gender : Gender.values()) {
            if (gender.getValue().equals(value)) {
                return gender;
            }
        }
        return null;
    }
}
