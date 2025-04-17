package com.example.task_api.mapper;

import com.example.task_api.dto.TaskDTO;
import com.example.task_api.model.Task;
import com.example.task_api.model.User;

public class TaskMapper {


    public static TaskDTO maskToDTO(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreatedAt(),
                task.getUser().getName());
    }

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
