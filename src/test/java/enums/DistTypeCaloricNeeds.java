package enums;

public enum DistTypeCaloricNeeds {

    MILES("\n" +
            "                                                    miles\n" +
            "                                                "),
    KILOMETERS("\n" +
            "                                                    kilometers\n" +
            "                                                ");

    private final String name;

    DistTypeCaloricNeeds(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static DistTypeCaloricNeeds fromString(String value) {
        for (DistTypeCaloricNeeds distTypeCaloricNeeds : DistTypeCaloricNeeds.values()) {
            if (distTypeCaloricNeeds.getName().equals(value)) {
                return distTypeCaloricNeeds;
            }
        }
        return null;
    }
}
