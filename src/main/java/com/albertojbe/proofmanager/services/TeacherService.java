package com.albertojbe.proofmanager.services;

import com.albertojbe.proofmanager.models.DTOs.TeacherDTO;
import com.albertojbe.proofmanager.models.Teacher;
import com.albertojbe.proofmanager.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public TeacherDTO getTeacherByName(String name) {
        var entity = repository.findTeacherByName(name);
        return new TeacherDTO(entity.getName());
    }

    public TeacherDTO saveTeacher(TeacherDTO teacherDTO) {
        Teacher entity = new Teacher();
        entity.setName(teacherDTO.name());
        repository.save(entity);
        return teacherDTO;
    }
    public List<Teacher> findAll(){
        return repository.findAll();
    }
}
