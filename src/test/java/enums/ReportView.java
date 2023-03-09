package enums;

public enum ReportView {
    LIST_VIEW("1"), GROUP_BY_WEEK("2"), GROUP_BY_MONTH("3"), GROUP_BY_ACTIVITY("4"),
    GROUP_BY_ACTIVITY_SUBTYPE("5");
    private final String value;

    ReportView(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static ReportView fromString(String value) {
        for (ReportView reportView : ReportView.values()) {
            if (reportView.getValue().equals(value)) {
                return reportView;
            }
        }
        return null;
    }
}
