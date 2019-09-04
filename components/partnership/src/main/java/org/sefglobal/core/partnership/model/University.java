package org.sefglobal.core.partnership.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "university")
public class University extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String ambassadorName;

    @NotNull
    private String ambassadorEmail;

    @NotNull
    @Column(name = "imageUrl", length = 512)
    private String imageUrl;

    @NotNull
    @Column(name = "status", length = 10)
    private String status;

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
