package com.example.task_api.service;

import com.example.task_api.dto.TaskDTO;
import com.example.task_api.mapper.TaskMapper;
import com.example.task_api.model.Task;
import com.example.task_api.model.User;
import com.example.task_api.repository.TaskRepository;
import com.example.task_api.repository.UserRepository;

import java.util.List;

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
}
