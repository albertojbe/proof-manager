package com.albertojbe.proofmanager.models.DTOs;

public record ProofRequest(
        String theme,
        float note,
        String teacherName,
        String disciplineName) {

}
