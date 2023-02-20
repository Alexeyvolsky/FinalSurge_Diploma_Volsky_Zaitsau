package enums;

public enum Country {
    // TODO: check after settings test value in the site
    ALBANIA("Albania"), ALGERIA("Algeria"), AMERICAN_SAMOA("American Samoa"),
    UNITED_STATE_OF_AMERICAN("United States of America"), ANGUILLA("Anguilla"),
    ANTIGUA_AND_BARBADOS("Antigua and Barbuda"), BELIZE("Belize"), BERMUDA("Bermuda"),
    BRITISH_INDIAN_OCEAN_TERRITORY("British Indian Ocean Territory"), CANADA("Canada");

    private final String name;

    Country(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Country fromString(String value) {
        for (Country country : Country.values()) {
            if (country.getName().equals(value)) {
                return country;
            }
        }
        return null;
    }
}
