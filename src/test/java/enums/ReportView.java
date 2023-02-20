package enums;

public enum ReportView {
    LIST_VIEW(" List View\n" +
            "                                "), GROUP_BY_WEEK(" Group by Week\n" +
            "                                "), GROUP_BY_MONTH(" Group by Month\n" +
            "                                "), GROUP_BY_ACTIVITY(" Group by Activity\n" +
            "                                "), GROUP_BY_ACTIVITY_SUBTYPE(" Group by Activity Sub-type\n" +
            "                                ");
    private final String name;

    ReportView(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static ReportView fromString(String value) {
        for (ReportView reportView : ReportView.values()) {
            if (reportView.getName().equals(value)) {
                return reportView;
            }
        }
        return null;
    }
}
