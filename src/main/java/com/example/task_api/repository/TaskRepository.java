package com.example.task_api.repository;

import com.example.task_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repo interface for Task Entity
 * Provides CRUD for the entity
 *
 * @author CJL
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}
