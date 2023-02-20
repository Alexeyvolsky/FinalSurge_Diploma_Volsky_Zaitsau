package enums;

public enum SelectEvent {

    MILE(" Mile"), KM5(" 5Km"), KM10(" 10Km"), HALF_MARATHON(" Half Marathon"),
    MARATHON(" Marathon");

    private final String name;

    SelectEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static SelectEvent fromString(String value) {
        for (SelectEvent selectEvent : SelectEvent.values()) {
            if (selectEvent.getName().equals(value)) {
                return selectEvent;
            }
        }
        return null;
    }
}