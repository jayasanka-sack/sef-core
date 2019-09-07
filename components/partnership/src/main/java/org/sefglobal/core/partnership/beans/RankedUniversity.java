package org.sefglobal.core.partnership.beans;

public class RankedUniversity {
    private int id;

    private String name;

    private String ambassadorName;

    private String imageUrl;

    private int engagement;

    public RankedUniversity() {
    }

    public RankedUniversity(int id, String name, String ambassadorName, String imageUrl, int engagement) {
        this.id = id;
        this.name = name;
        this.ambassadorName = ambassadorName;
        this.imageUrl = imageUrl;
        this.engagement = engagement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmbassadorName() {
        return ambassadorName;
    }

    public void setAmbassadorName(String ambassadorName) {
        this.ambassadorName = ambassadorName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getEngagement() {
        return engagement;
    }

    public void setEngagement(int engagement) {
        this.engagement = engagement;
    }
}
