package com.albertojbe.proofmanager.repositories;

import com.albertojbe.proofmanager.models.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    Discipline findDisciplineByName(String name);
}
