package org.sefglobal.core.partnership.controller;

import org.sefglobal.core.partnership.model.University;
import org.sefglobal.core.partnership.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class UniversityController {

    @Autowired
    UniversityRepository universityRepository;

    @GetMapping("/universities")
    public List<University> getAllUniversities(){
        return universityRepository.findAll();
    }

    @GetMapping("/universities/{id}")
    public University getAllUniversities(@PathVariable int id){
        return universityRepository.findOne(id);
    }

    @PostMapping("/universities")
    public University createUniversity(@RequestBody University university){
        return universityRepository.save(university);
    }

    @PutMapping("/universities/{id}")
    public University updateUniversity(@PathVariable int id, @RequestBody Map<String, String> body){
        University university = universityRepository.findOne(id);
        university.setName(body.get("name"));
        university.setAmbassadorEmail(body.get("ambassadorEmail"));
        university.setAmbassadorName(body.get("ambassadorName"));
        university.setImageUrl(body.get("imageUrl"));
        university.setStatus(body.get("status"));
        return universityRepository.save(university);
    }

    @DeleteMapping("/universities/{id}")
    public ResponseEntity<?> deleteUniversity(@PathVariable int id){
        universityRepository.delete(universityRepository.findOne(id));
        return ResponseEntity.ok().build();
    }

}
