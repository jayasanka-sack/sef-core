package org.sefglobal.core.partnership.controller;

import org.sefglobal.core.partnership.model.Event;
import org.sefglobal.core.partnership.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/events")
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

}
