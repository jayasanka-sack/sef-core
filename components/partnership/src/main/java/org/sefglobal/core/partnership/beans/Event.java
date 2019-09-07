package org.sefglobal.core.partnership.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Represent an event in SEF. This can be a event or a campaign
 */
public class Event {

    private int id;
    private String name;
    private String url;
    private Date eventTime;
    private String status;

    public Event() {
    }

    public Event(int id, String name, String url, Date eventTime, String status) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.eventTime = eventTime;
        this.status = status;
    }

    /**
     * Returns a new Event object using SQL result set
     * @param resultSet a SQL result set object containing an event
     */
    public Event(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.name = resultSet.getString("name");
        this.url = resultSet.getString("url");
        this.eventTime = resultSet.getDate("event_time");
        this.status = resultSet.getString("status");
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
