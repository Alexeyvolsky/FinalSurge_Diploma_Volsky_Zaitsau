package enums;

public enum DistanceTinman {

    KM5("5"), KM10("10"), HALF_MARATHON("21.0974537664"), MARATHON("42.1949075328"),
    METERS400("0.4");

    private final String name;

    DistanceTinman(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static DistanceTinman fromString(String value) {
        for (DistanceTinman distanceTinman : DistanceTinman.values()) {
            if (distanceTinman.getName().equals(value)) {
                return distanceTinman;
            }
        }
        return null;
    }
}