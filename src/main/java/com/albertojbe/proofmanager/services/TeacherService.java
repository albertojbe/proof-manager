package com.albertojbe.proofmanager.services;

import com.albertojbe.proofmanager.exceptions.NameNotFoundException;
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

    public Teacher getTeacherByName(String name) throws NameNotFoundException {
        var teacher = repository.findTeacherByName(name);
        if (teacher == null) {
            throw new NameNotFoundException("Teacher with name: " + name + " not found");
        }
        return teacher;
    }

    public Teacher saveTeacher(TeacherRequest teacherRequest) {
        Teacher entity = new Teacher();
        entity.setName(teacherRequest.name());
        repository.save(entity);
        return entity;
    }
    public List<Teacher> findAll(){
        return repository.findAll();
    }
}
