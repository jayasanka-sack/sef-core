package org.sefglobal.core.partnership.beans;

public class University {
    private int id;

    private String name;

    private String ambassadorName;

    private String ambassadorEmail;

    private String imageUrl;

    private String status;

    public University() {
    }

    public University(int id, String name, String ambassadorName, String ambassadorEmail, String imageUrl, String status) {
        this.id = id;
        this.name = name;
        this.ambassadorName = ambassadorName;
        this.ambassadorEmail = ambassadorEmail;
        this.imageUrl = imageUrl;
        this.status = status;
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

    public String getAmbassadorEmail() {
        return ambassadorEmail;
    }

    public void setAmbassadorEmail(String ambassadorEmail) {
        this.ambassadorEmail = ambassadorEmail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
