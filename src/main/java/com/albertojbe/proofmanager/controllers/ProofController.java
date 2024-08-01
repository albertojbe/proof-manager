package com.albertojbe.proofmanager.controllers;

import com.albertojbe.proofmanager.models.DTOs.ProofRequest;
import com.albertojbe.proofmanager.models.Proof;
import com.albertojbe.proofmanager.services.ProofService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proofs")
public class ProofController {

    ProofService proofService;

    public ProofController(ProofService proofService) {
        this.proofService = proofService;
    }

    @GetMapping
    public ResponseEntity<List<Proof>> getProofs() {
        return ResponseEntity.ok(proofService.getProofs());
    }

    @PostMapping
    public ResponseEntity<Proof> saveProof(@RequestBody ProofRequest proofRequest) {
        return ResponseEntity.ok(proofService.saveProof(proofRequest));
    }
}
