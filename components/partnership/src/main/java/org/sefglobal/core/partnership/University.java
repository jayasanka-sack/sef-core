package org.sefglobal.core.partnership;

import javax.persistence.*;

@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String ambassadorName;
    private String ambassadorEmail;
    private String imageUrl;

    public University() {
    }

    public University(String name, String ambassadorName, String ambassadorEmail, String imageUrl) {
        this.name = name;
        this.ambassadorName = ambassadorName;
        this.ambassadorEmail = ambassadorEmail;
        this.imageUrl = imageUrl;
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
}
