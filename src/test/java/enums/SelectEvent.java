package enums;

public enum SelectEvent {

    MILE("MILE"), KM5("FIVEK"), KM10("TENK"), HALF_MARATHON("HALFMAR"), MARATHON("MARATHON");

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