package com.albertojbe.proofmanager.repositories;

import com.albertojbe.proofmanager.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
   Teacher findTeacherByName(String name);
}
