package com.example.task_api.mapper;

import com.example.task_api.dto.TaskDTO;
import com.example.task_api.model.Task;
import com.example.task_api.model.User;

/**
 * Utility class for mapping between Task entities and TaskDTOs.
 * Handles flattening of the Task → User relationship for clean responses.
 *
 * @author CJL
 */
public class TaskMapper {


    /**
     * Converts a Task entity to a TaskDTO.
     *
     * @param task the Task entity
     * @return the mapped TaskDTO
     */
    public static TaskDTO maskToDTO(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreatedAt(),
                task.getUser().getId());
    }

    /**
     * Converts a TaskDTO and associated User to a Task entity.
     * The User must be retrieved beforehand and passed in.
     *
     * @param taskDTO the TaskDTO
     * @param user the associated User entity
     * @return the mapped Task entity
     */
    public static Task maskToEntity(TaskDTO taskDTO, User user) {
        Task entity = new Task();

        entity.setId(taskDTO.getId());
        entity.setDescription(taskDTO.getDescription());
        entity.setTitle(taskDTO.getTitle());
        entity.setCreatedAt(taskDTO.getCreatedAt());
        entity.setUser(user);

        return entity;
    }
}
