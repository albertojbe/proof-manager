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
        Teacher teacher = new Teacher();
        teacher.setName(teacherDTO.name());
        repository.save(teacher);
        return teacherDTO;
    }
    public List<TeacherDTO> findAll(){
        List<Teacher> teachers = repository.findAll();
        List<TeacherDTO> teacherDTOs = new ArrayList<>();
        for (Teacher teacher : teachers) {
            teacherDTOs.add(new TeacherDTO(teacher.getName()));
        }
        return teacherDTOs;
    }
}
