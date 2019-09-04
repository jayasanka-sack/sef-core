package org.sefglobal.core.partnership.controller;

import org.sefglobal.core.partnership.model.Society;
import org.sefglobal.core.partnership.model.University;
import org.sefglobal.core.partnership.repository.SocietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocietyController {

    @Autowired
    SocietyRepository societyRepository;

    @GetMapping("/universities/{universityId}/societies")
    public List<Society> getAllSocietiesByUniversityId(@PathVariable int universityId, Pageable pageable){
        return societyRepository.findByUniversityId(universityId,pageable);
    }

}
