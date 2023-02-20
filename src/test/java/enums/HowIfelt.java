package enums;

public enum HowIfelt {
    GREAT("Great"), GOOD("Good"), NORMAL("Normal"), POOR("Poor"), TERRIBLE("Terrible");
    private final String name;

    HowIfelt(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static HowIfelt fromString(String value) {
        for (HowIfelt howIfelt : HowIfelt.values()) {
            if (howIfelt.getName().equals(value)) {
                return howIfelt;
            }
        }
        return null;
    }
}
