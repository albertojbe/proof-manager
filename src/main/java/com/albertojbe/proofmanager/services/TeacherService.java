package com.albertojbe.proofmanager.services;

import com.albertojbe.proofmanager.models.DTOs.TeacherRequest;
import com.albertojbe.proofmanager.models.Teacher;
import com.albertojbe.proofmanager.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public TeacherRequest getTeacherByName(String name) {
        var entity = repository.findTeacherByName(name);
        return new TeacherRequest(entity.getName());
    }

    public TeacherRequest saveTeacher(TeacherRequest teacherRequest) {
        Teacher entity = new Teacher();
        entity.setName(teacherRequest.name());
        repository.save(entity);
        return teacherRequest;
    }
    public List<Teacher> findAll(){
        return repository.findAll();
    }
}
