package org.sefglobal.core.partnership.beans;

import java.util.Date;

public class Event {
    private int id;
    private String name;
    private String link;
    private Date eventDate;
    private String status;

    public Event() {
    }

    public Event(int id, String name, String link, Date eventDate, String status) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.eventDate = eventDate;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
