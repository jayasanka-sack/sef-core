package org.sefglobal.core.partnership.service.api;

import org.sefglobal.core.partnership.beans.RankedUniversity;
import org.sefglobal.core.partnership.dao.EngagementDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/engagements")
public class EngagementManagementAPI {

    @Autowired
    private EngagementDAO engagementDAO;

    @GetMapping("/")
    public List<RankedUniversity> getUniversityRanking(){
        return engagementDAO.getUniversityRanking();
    }

    @PostMapping("/")
    public void addEngagement(@RequestBody Map<String,String> body){
        int eventId = Integer.parseInt(body.get("eventId"));
        int societyId = Integer.parseInt(body.get("societyId"));
        String ip = body.get("ip");

        engagementDAO.addEngagement(eventId,societyId,ip);
    }

}
