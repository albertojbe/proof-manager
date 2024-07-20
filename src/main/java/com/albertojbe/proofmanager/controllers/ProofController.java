package com.albertojbe.proofmanager.controllers;

import com.albertojbe.proofmanager.models.DTOs.ProofRequest;
import com.albertojbe.proofmanager.models.Proof;
import com.albertojbe.proofmanager.services.ProofService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/proofs")
public class ProofController {

    ProofService proofService;

    public ProofController(ProofService proofService) {
        this.proofService = proofService;
    }

    public ResponseEntity<List<Proof>> getProofs() {
        return ResponseEntity.ok(proofService.getProofs());
    }

    public ResponseEntity<Proof> saveProof(ProofRequest proofRequest) {
        return ResponseEntity.ok(proofService.saveProof(proofRequest));
    }
}
