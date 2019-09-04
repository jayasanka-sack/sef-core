package org.sefglobal.core.partnership.repository;

import org.sefglobal.core.partnership.model.Society;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocietyRepository extends JpaRepository<Society, Integer> {

    List<Society> findByUniversityId(int universityId, Pageable pageable);

}
