package enums;

public enum PaceType {
    MIN_MI("mi"), MIN_KM("km"), MPH("mp"), KPH("kp"), MIN_100M("me"), MIN_100Y("yd"),MIN_1500M("mm") ;
    private final String name;

    PaceType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static PaceType fromString(String value) {
        for (PaceType paceType : PaceType.values()) {
            if (paceType.getName().equals(value)) {
                return paceType;
            }
        }
        return null;
    }
}
