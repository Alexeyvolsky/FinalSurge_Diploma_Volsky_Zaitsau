package enums;

public enum Region {
// TODO: check after settings test value in the site
    ARIZONA("Arizona"), ARKANSAS("Arkansas"), CALIFORNIA("California"), COLORADO("Colorado"),
    CONNECTICUT("Connecticut"), FLORIDA("Florida"), HAWAII("Hawaii"), IDAHO("Idaho");

    private final String name;

    Region(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Region fromString(String value) {
        for (Region region : Region.values()) {
            if (region.getName().equals(value)) {
                return region;
            }
        }
        return null;
    }
}
