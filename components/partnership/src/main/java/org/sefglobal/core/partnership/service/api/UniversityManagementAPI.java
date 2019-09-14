package org.sefglobal.core.partnership.service.api;

import org.sefglobal.core.partnership.beans.University;
import org.sefglobal.core.partnership.dao.UniversityDAO;
import org.sefglobal.core.partnership.exception.PartnershipAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("/universities")
public class UniversityManagementAPI {

    @Autowired
    private UniversityDAO universityDAO;

    @GetMapping("/")
    public List<University> getAllUniversities(HttpServletRequest request){
        System.out.println(request.getRemoteAddr());
        return universityDAO.getAllUniversities();
    }

    @GetMapping("/{id}")
    public University getUniversity(@PathVariable int id) throws PartnershipAPIException {
        return universityDAO.getUniversity(id);
    }
}
