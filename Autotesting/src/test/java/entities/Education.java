package entities;

public class Education {
    private String dateStart;
    private String dateEnd;
    private String organization;

    public Education(String dateStart, String dateEnd, String organization) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.organization = organization;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
