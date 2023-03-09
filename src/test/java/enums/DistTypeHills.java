package enums;

public enum DistTypeHills {
    MILES("mi"), KILOMETERS("km"), METERS("m"), YARD("yd");
    private final String name;

    DistTypeHills(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static DistTypeHills fromString(String value) {
        for (DistTypeHills distTypeHills : DistTypeHills.values()) {
            if (distTypeHills.getName().equals(value)) {
                return distTypeHills;
            }
        }
        return null;
    }

}
