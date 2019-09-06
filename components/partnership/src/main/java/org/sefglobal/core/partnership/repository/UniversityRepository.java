package org.sefglobal.core.partnership.repository;

import org.sefglobal.core.partnership.model.University;
import org.sefglobal.core.partnership.dto.RankedUniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {

    @Transactional(readOnly = true)
    List<RankedUniversity> findById(int id);

    @Transactional(readOnly = true)
    @Query(value = "SELECT u.id as id, u.name as name FROM university u", nativeQuery = true)
    List<RankedUniversity> hululu();
}
