package com.aventude.patientCareService.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aventude.patientCareService.domain.user.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByEmailAndEnabled(String email, boolean enabled);
}
