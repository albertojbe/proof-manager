package com.albertojbe.proofmanager.services;

import com.albertojbe.proofmanager.models.DTOs.DisciplineDTO;
import com.albertojbe.proofmanager.models.Discipline;
import com.albertojbe.proofmanager.repositories.DisciplineRepository;
import com.albertojbe.proofmanager.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {

    DisciplineRepository disciplineRepository;
    TeacherRepository teacherRepository;

    public DisciplineService(DisciplineRepository disciplineRepository, TeacherRepository teacherRepository) {
        this.disciplineRepository = disciplineRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<Discipline> findAll() {
        return disciplineRepository.findAll();
    }

    public Discipline saveDiscipline(DisciplineDTO disciplineDTO){
        Discipline entity = new Discipline();
        entity.setName(disciplineDTO.name());
        entity.setPeriod(disciplineDTO.period());
        entity.setTeacher(teacherRepository.findTeacherByName(disciplineDTO.teacherName()));
        return disciplineRepository.save(entity);
    }
}
