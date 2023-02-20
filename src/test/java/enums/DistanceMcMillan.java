package enums;

public enum DistanceMcMillan {

    M400("400m"), M600("600m"), M800("800m"), MILE("Mile"), MARATHON("Marathon");

    private final String name;

    DistanceMcMillan(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static DistanceMcMillan fromString(String value) {
        for (DistanceMcMillan distanceMcMillan : DistanceMcMillan.values()) {
            if (distanceMcMillan.getName().equals(value)) {
                return distanceMcMillan;
            }
        }
        return null;
    }
}