package com.example.task_api.controller;

import com.example.task_api.dto.TaskDTO;
import com.example.task_api.dto.UserDTO;
import com.example.task_api.model.Task;
import com.example.task_api.model.User;
import com.example.task_api.repository.TaskRepository;
import com.example.task_api.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    private final UserTaskService userTaskService;

    @Autowired
    public TaskController(UserTaskService userTaskService, TaskRepository taskRepo) {
        this.userTaskService = userTaskService;
    }

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return userTaskService.getAllTasks();
    }

    @PostMapping()
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO dtoTask) {

        System.out.println("Received user: " + dtoTask.getTitle() + ", " + dtoTask.getUserid());

        userTaskService.createTask(dtoTask);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public UserDTO getUserByTaskId(@PathVariable Long id) {
      return userTaskService.getUserByTaskId(id);
    }
}
