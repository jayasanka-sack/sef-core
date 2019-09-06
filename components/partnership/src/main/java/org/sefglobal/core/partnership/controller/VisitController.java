package org.sefglobal.core.partnership.controller;

import org.sefglobal.core.partnership.model.Event;
import org.sefglobal.core.partnership.model.Society;
import org.sefglobal.core.partnership.model.Visit;
import org.sefglobal.core.partnership.dto.RankedUniversity;
import org.sefglobal.core.partnership.model.keys.VisitKey;
import org.sefglobal.core.partnership.repository.EventRepository;
import org.sefglobal.core.partnership.repository.SocietyRepository;
import org.sefglobal.core.partnership.repository.UniversityRepository;
import org.sefglobal.core.partnership.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class VisitController {

    @Autowired
    VisitRepository visitRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    SocietyRepository societyRepository;
    @Autowired
    UniversityRepository universityRepository;

    @GetMapping("/visits")
    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    @PostMapping("/visits")
    public Event createVisit(@RequestBody Map<String, String> body) {
        int eventId = Integer.parseInt(body.get("eventId"));
        int societyId = Integer.parseInt(body.get("societyId"));
        String  ip = body.get("ip");
        Event event = eventRepository.findOne(eventId);
        Society society = societyRepository.findOne(societyId);

        Visit visit = new Visit(new VisitKey(eventId, societyId, ip),event,society);
        visitRepository.save(visit);
        return event;
    }

    @GetMapping("/visits/test/{id}")
    public List<RankedUniversity> test(@PathVariable int id){
//        return universityRepository.findById(id);
        List<RankedUniversity> o = universityRepository.hululu();
        return o;
    }
}
