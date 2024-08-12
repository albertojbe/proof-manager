package com.albertojbe.proofmanager.repositories;

import com.albertojbe.proofmanager.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
