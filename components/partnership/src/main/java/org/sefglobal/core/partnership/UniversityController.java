package org.sefglobal.core.partnership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UniversityController {

    @Autowired
    UniversityRepository universityRepository;

    @GetMapping("/universities")
    public List<University> index(){
        return universityRepository.findAll();
    }

}
