package org.sefglobal.core.partnership.model.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class VisitKey implements Serializable {
    @Column(name = "eventId")
    int eventId;

    @Column(name = "societyId")
    int societyId;

    @Column(name = "intervalValue")
    private int intervalValue;

    @Column(name = "ip", length = 39)
    private String ip;

    public VisitKey(int eventId, int societyId, String ip) {
        this.eventId = eventId;
        this.societyId = societyId;
        this.intervalValue = Math.toIntExact(new Date().getTime()/100000);
        this.ip = ip;
    }

    public VisitKey() {
    }

    public int getEventId() {
        return eventId;
    }

    public int getSocietyId() {
        return societyId;
    }

    public int getIntervalValue() {
        return intervalValue;
    }

    public String getIp() {
        return ip;
    }
}
