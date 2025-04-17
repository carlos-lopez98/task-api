package com.example.task_api.mapper;

import com.example.task_api.dto.TaskDTO;
import com.example.task_api.dto.UserDTO;
import com.example.task_api.model.Task;
import com.example.task_api.model.User;


/**
 * Utility class for mapping between User entities and UserDTOs.
 * Handles conversion logic to keep controllers and services clean.
 *
 * @author CJL
 */
public class UserMapper {

    /**
     * Converts a User entity to a UserDTO.
     *
     * @param user the User entity
     * @return the mapped UserDTO
     */
    public static UserDTO maskToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setId(user.getId());
        return dto;
    }

    /**
     * Converts a UserDTO to a User entity.
     * Note: Does not set createdAt or any related entities.
     *
     * @param dto the UserDTO
     * @return the mapped User entity
     */
    public static User maskToEntity(UserDTO dto) {
        User entity = new User();
        entity.setEmail(dto.getEmail());
        entity.setName(dto.getName());
        entity.setId(dto.getId());
        return entity;
    }
}
