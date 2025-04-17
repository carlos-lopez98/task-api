package com.example.task_api.mapper;

import com.example.task_api.dto.TaskDTO;
import com.example.task_api.dto.UserDTO;
import com.example.task_api.model.Task;
import com.example.task_api.model.User;

public class UserMapper {

    public static UserDTO maskToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setId(user.getId());
        dto.setTasks(user.getTasks());

        return dto;
    }

    public static User maskToEntity(UserDTO dto) {
        User entity = new User();
        entity.setEmail(dto.getEmail());
        entity.setName(dto.getName());
        entity.setId(dto.getId());
        return entity;
    }
}
