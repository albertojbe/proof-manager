package com.albertojbe.proofmanager.controllers;

import com.albertojbe.proofmanager.models.DTOs.TeacherDTO;
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

    @GetMapping("/{name}")
    public ResponseEntity<TeacherDTO> getTeacherByName(@PathVariable(value = "name") String name){
        return ResponseEntity.ok(teacherService.getTeacherByName(name));
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers(){
        return ResponseEntity.ok(teacherService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherDTO teacherDTO){
        return ResponseEntity.ok(teacherService.saveTeacher(teacherDTO));
    }
}
