package enums;

public enum RaceDist {

    MARATHON("Marathon"), HALF_MARATHON("Half Marathon"), M1500("1500m"), M1600("1600m"),
    MILE_1("1609m");

    private final String name;

    RaceDist(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static RaceDist fromString(String value) {
        for (RaceDist raceDist : RaceDist.values()) {
            if (raceDist.getName().equals(value)) {
                return raceDist;
            }
        }
        return null;
    }
}