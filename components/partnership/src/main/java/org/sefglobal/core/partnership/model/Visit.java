package org.sefglobal.core.partnership.model;

import org.sefglobal.core.partnership.model.keys.VisitKey;

import javax.persistence.*;

@Entity
@Table(name = "visit")
public class Visit {

    @EmbeddedId
    private VisitKey id;

    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(name = "eventId")
    private Event event;

    @ManyToOne
    @MapsId("societyId")
    @JoinColumn(name = "societyId")
    private Society society;

    public Visit() {}

    public Visit(VisitKey id, Event event, Society society) {
        this.id = id;
        this.event = event;
        this.society = society;
    }


    public VisitKey getId() {
        return id;
    }

    public void setId(VisitKey id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Society getSociety() {
        return society;
    }

    public void setSociety(Society society) {
        this.society = society;
    }
}
