package enums;

public enum Day {
    FIRST_DAY("1"), SECOND_DAY("2"), THIRD_DAY("3"), FOURTH_DAY("4"), FIFTH_DAY("5"),
    SIXTH_DAY("6"), SEVENTH_DAY("7"), EIGHTH_DAY("8"), NINTH_DAY("9"), TEN_DAY("10"),
    ELEVEN_DAY("11");

    private final String name;

    Day(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Day fromString(String value) {
        for (Day day : Day.values()) {
            if (day.getName().equals(value)) {
                return day;
            }
        }
        return null;
    }
}
