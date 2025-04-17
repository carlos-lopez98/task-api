package com.example.task_api.controller;

import com.example.task_api.dto.TaskDTO;
import com.example.task_api.dto.UserDTO;
import com.example.task_api.model.Task;
import com.example.task_api.repository.TaskRepository;
import com.example.task_api.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * REST controller for managing tasks.
 * Provides endpoints to create, retrieve, and query tasks and their associated users.
 *
 * @author CJL
 */
@RestController
@RequestMapping("api/tasks")
public class TaskController {
    private final UserTaskService userTaskService;

    @Autowired
    public TaskController(UserTaskService userTaskService, TaskRepository taskRepo) {
        this.userTaskService = userTaskService;
    }

    /**
     * Retrieves all tasks in the system.
     *
     * @return a list of TaskDTOs
     */
    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return userTaskService.getAllTasks();
    }

    /**
     * Creates a new task and associates it with a user.
     *
     * @param dtoTask the task data to be created
     * @return the created Task
     */
    @PostMapping()
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO dtoTask) {

        System.out.println("Received user: " + dtoTask.getTitle() + ", " + dtoTask.getUserid());

        userTaskService.createTask(dtoTask);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Retrieves the user who is assigned to a given task.
     *
     * @param id the ID of the task
     * @return the UserDTO of the user who owns the task
     */
    @GetMapping("/{id}")
    public UserDTO getUserByTaskId(@PathVariable Long id) {
      return userTaskService.getUserByTaskId(id);
    }
}
