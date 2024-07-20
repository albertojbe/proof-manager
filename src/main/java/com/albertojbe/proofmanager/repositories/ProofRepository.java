package com.albertojbe.proofmanager.repositories;

import com.albertojbe.proofmanager.models.Proof;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProofRepository extends JpaRepository<Proof, Long> {
}
