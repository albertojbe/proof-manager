package com.albertojbe.proofmanager.services;

import com.albertojbe.proofmanager.models.DTOs.ProofRequest;
import com.albertojbe.proofmanager.models.Proof;
import com.albertojbe.proofmanager.repositories.DisciplineRepository;
import com.albertojbe.proofmanager.repositories.ProofRepository;
import com.albertojbe.proofmanager.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProofService {

    ProofRepository proofRepository;
    TeacherRepository teacherRepository;
    DisciplineRepository disciplineRepository;

    public ProofService(ProofRepository repository, TeacherRepository teacherRepository, DisciplineRepository disciplineRepository) {
        this.proofRepository = repository;
        this.teacherRepository = teacherRepository;
        this.disciplineRepository = disciplineRepository;
    }

    public List<Proof> getProofs() {
        return proofRepository.findAll();
    }

    public Proof saveProof(ProofRequest proofRequest) {
        Proof entity = new Proof();
        entity.setTheme(proofRequest.theme());
        entity.setNote(proofRequest.note());
        entity.setTeacher(teacherRepository.findTeacherByName(proofRequest.teacherName()));
        entity.setDiscipline(disciplineRepository.findDisciplineByName(proofRequest.DisciplineName()));
        return proofRepository.save(entity);
    }
}
