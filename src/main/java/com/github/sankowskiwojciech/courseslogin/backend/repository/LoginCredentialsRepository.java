package com.github.sankowskiwojciech.courseslogin.backend.repository;

import com.github.sankowskiwojciech.courseslogin.model.db.login.LoginCredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginCredentialsRepository extends JpaRepository<LoginCredentialsEntity, Long> {

    Optional<LoginCredentialsEntity> findByEmailAddress(String emailAddress);
}
