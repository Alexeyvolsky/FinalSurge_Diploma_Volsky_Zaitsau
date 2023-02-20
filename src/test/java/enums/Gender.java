package enums;

public enum Gender {

    MALE("  Male", "\n" +
            "                                                    male\n" +
            "                                                "),
    FEMALE(" Female", "\n" +
            "                                                    female\n" +
            "                                                ");

    private final String name;
    private final String nameForCaloricNeeds;

    Gender(String name, String nameForCaloricNeeds) {
        this.name = name;
        this.nameForCaloricNeeds = nameForCaloricNeeds;
    }

    public String getName() {
        return this.name;
    }

    public String getNameForCaloricNeeds()  {
        return this.nameForCaloricNeeds;
    }

    public static Gender fromString(String value) {
        for (Gender gender : Gender.values()) {
            if (gender.getName().equals(value)) {
                return gender;
            }
        }
        return null;
    }

    public static Gender fromStringForCaloricNeeds(String value)    {
        for (Gender gender : Gender.values())   {
            if (gender.getNameForCaloricNeeds().equals(value))   {
                return gender;
            }
        }
        return null;
    }
}
