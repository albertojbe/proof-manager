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

    @CrossOrigin(origins = {"http://localhost:8080", "https://proof-alberto.com.br"})
    @GetMapping
    public ResponseEntity<List<Proof>> getProofs() {
        return ResponseEntity.ok(proofService.getProofs());
    }

    @CrossOrigin(origins = {"http://localhost:8080", "https://proof-alberto.com.br"})
    @PostMapping
    public ResponseEntity<Proof> saveProof(@RequestBody ProofRequest proofRequest) {
        return ResponseEntity.ok(proofService.saveProof(proofRequest));
    }
}
