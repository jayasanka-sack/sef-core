package org.sefglobal.core.partnership.repository;

import org.sefglobal.core.partnership.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {

}
