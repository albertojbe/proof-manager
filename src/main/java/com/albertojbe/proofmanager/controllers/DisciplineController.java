package com.albertojbe.proofmanager.controllers;

import com.albertojbe.proofmanager.models.DTOs.DisciplineDTO;
import com.albertojbe.proofmanager.models.Discipline;
import com.albertojbe.proofmanager.services.DisciplineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proofs/discipline")
public class DisciplineController {

    DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }
    @GetMapping("")
    public ResponseEntity<List<Discipline>> getDisciplines() {
        return ResponseEntity.ok(disciplineService.findAll());
    }
    @PostMapping("")
    public ResponseEntity<Discipline> saveDiscipline(@RequestBody DisciplineDTO disciplineDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplineService.saveDiscipline(disciplineDTO));
    }
}
