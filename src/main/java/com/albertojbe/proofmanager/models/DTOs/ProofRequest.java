package com.albertojbe.proofmanager.models.DTOs;

import com.albertojbe.proofmanager.models.Proof;
import com.albertojbe.proofmanager.repositories.TeacherRepository;

public record ProofRequest(String theme, float note, String teacherName, String DisciplineName) {

}
