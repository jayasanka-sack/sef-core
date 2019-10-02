package org.sefglobal.core.partnership.service.api;

import org.sefglobal.core.partnership.beans.Event;
import org.sefglobal.core.partnership.beans.RankedSociety;
import org.sefglobal.core.partnership.beans.RankedUniversity;
import org.sefglobal.core.partnership.dao.EngagementDAO;
import org.sefglobal.core.partnership.dao.EventDAO;
import org.sefglobal.core.partnership.exception.PartnershipAPIException;
import org.sefglobal.core.partnership.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://sefglobal.org")
@RestController
public class EngagementManagementAPI {

    @Autowired
    private EngagementDAO engagementDAO;

    @Autowired
    private EventDAO eventDAO;

    @GetMapping("/engagements")
    public List<RankedUniversity> getUniversityRanking(){
        return engagementDAO.getUniversityRanking();
    }

    @PostMapping("/engagements")
    public Event addEngagement(@RequestBody Map<String,String> body) throws PartnershipAPIException {

        int eventId = Integer.parseInt(body.get("eventId"));
        int societyId = Integer.parseInt(body.get("societyId"));
        String ip = body.get("ip");

        return engagementDAO.createEngagement(eventId, societyId, ip);
    }

    @GetMapping("/engagements/university/{id}")
    public RankedUniversity getEngagementByUniversity(@PathVariable int id) throws PartnershipAPIException{
        return engagementDAO.getEngagementByUniversity(id);
    }

}
