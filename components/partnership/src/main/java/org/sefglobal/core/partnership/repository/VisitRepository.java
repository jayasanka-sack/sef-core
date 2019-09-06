package org.sefglobal.core.partnership.repository;

import org.sefglobal.core.partnership.model.Society;
import org.sefglobal.core.partnership.model.Visit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    List<Visit> findBySocietyId(int societyId);
//    List<Visit> findByUniversityId(int societyId);


}
