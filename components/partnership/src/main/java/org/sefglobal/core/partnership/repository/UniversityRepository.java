package org.sefglobal.core.partnership.repository;

import org.sefglobal.core.partnership.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {

}
