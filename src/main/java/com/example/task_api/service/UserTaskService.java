package com.example.task_api.service;

import com.example.task_api.dto.TaskDTO;
import com.example.task_api.dto.UserDTO;
import com.example.task_api.mapper.TaskMapper;
import com.example.task_api.mapper.UserMapper;
import com.example.task_api.model.Task;
import com.example.task_api.model.User;
import com.example.task_api.repository.TaskRepository;
import com.example.task_api.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserTaskService {
    private final UserRepository userRepo;
    private final TaskRepository taskRepo;

    public UserTaskService(TaskRepository taskRepo, UserRepository userRepo){
        this.userRepo = userRepo;
        this.taskRepo = taskRepo;
    }


    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }


    public void createTask(TaskDTO dtoTask){
        User user = userRepo.getById(dtoTask.getUserid());
        Task task = TaskMapper.maskToEntity(dtoTask, user);
        taskRepo.save(task);
    }

    public UserDTO getUserByTaskId(Long id) {
        User user = taskRepo.getById(id).getUser();
        return UserMapper.maskToDTO(user);
    }

    public UserDTO getUserById(Long id) {
        return UserMapper.maskToDTO(userRepo.getById(id));
    }

    public void createUser(UserDTO userDTO) {
        userRepo.save(UserMapper.maskToEntity(userDTO));
    }

    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }

    public UserDTO getUserByEmail(String email) {
        Optional<User> user = userRepo.findByEmail(email);

        return UserMapper.maskToDTO(user.get());
    }
}
