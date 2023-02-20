package enums;

public enum PerceivedEffort {
    VERY_LIGHT("1"), LIGHT2("2"), LIGHT3("3"), MODERATE4("4"), MODERATE5("5"),
    MODERATE6("6"),HARD7("7"), HARD8("8"), VARE_HARD("9"), MAX_EFFORT("10") ;
    private final String name;

    PerceivedEffort(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static PerceivedEffort fromString(String value) {
        for (PerceivedEffort perceivedEffort : PerceivedEffort.values()) {
            if (perceivedEffort.getName().equals(value)) {
                return perceivedEffort;
            }
        }
        return null;
    }
}
