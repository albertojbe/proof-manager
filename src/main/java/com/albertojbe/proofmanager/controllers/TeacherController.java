package com.albertojbe.proofmanager.controllers;

import com.albertojbe.proofmanager.models.DTOs.TeacherRequest;
import com.albertojbe.proofmanager.models.Teacher;
import com.albertojbe.proofmanager.services.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proofs/teacher")
public class TeacherController {

    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/{name}") //nao esta funcionando
    public ResponseEntity<TeacherRequest> getTeacherByName(@PathVariable(value = "name") String name){
        return ResponseEntity.ok(teacherService.getTeacherByName(name));
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers(){
        return ResponseEntity.ok(teacherService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<TeacherRequest> saveTeacher(@RequestBody TeacherRequest teacherRequest){
        return ResponseEntity.ok(teacherService.saveTeacher(teacherRequest));
    }
}
