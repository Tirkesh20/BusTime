public class Service {
    private String CompanyName;
    private String TimeFrom;
    private String TimeTo;

    public Service() {
    }

    public Service(String companyName, String timeFrom, String timeTo) {
        CompanyName = companyName;
        TimeFrom = timeFrom;
        TimeTo = timeTo;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getTimeFrom() {
        return TimeFrom;
    }

    @Override
    public String toString() {
        return "Service{" +
                "CompanyName='" + CompanyName + '\'' +
                ", TimeFrom='" + TimeFrom + '\'' +
                ", TimeTo='" + TimeTo + '\'' +
                "}\n";
    }

    public String getTimeTo() {
        return TimeTo;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setTimeFrom(String timeFrom) {
        TimeFrom = timeFrom;
    }

    public void setTimeTo(String timeTo) {
        TimeTo = timeTo;
    }
}
