package org.sefglobal.core.partnership.service.api;

import org.sefglobal.core.partnership.beans.University;
import org.sefglobal.core.partnership.dao.UniversityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityManagementAPI {

    @Autowired
    private UniversityDAO universityDAO;

    @GetMapping("/")
    public List<University> getAllUniversities(){
        return universityDAO.getAllUniversities();
    }

    @GetMapping("/{id}")
    public University getUniversity(@PathVariable int id){
        return universityDAO.getUniversity(id);
    }
}
