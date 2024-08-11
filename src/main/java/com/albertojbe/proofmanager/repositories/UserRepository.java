package com.albertojbe.proofmanager.repositories;

import com.albertojbe.proofmanager.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
