package com.example.task_api.repository;

import com.example.task_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * Repo interface for User Entity
 * Provides CRUD for the entity
 *
 * @author CJL
 */
public interface  UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
