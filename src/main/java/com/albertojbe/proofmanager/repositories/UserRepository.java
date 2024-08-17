package com.albertojbe.proofmanager.repositories;

import com.albertojbe.proofmanager.models.security.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
