package enums;

public enum Gender {

    MALE("m"), FEMALE("k");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
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
