package com.example.task_api.controller;

import com.example.task_api.model.Task;
import com.example.task_api.model.User;
import com.example.task_api.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    private final TaskRepository taskRepo;

    public TaskController(TaskRepository taskRepo){
        this.taskRepo = taskRepo;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepo.findAll();
    }

    @PostMapping()
    public ResponseEntity<Task> createTask(@RequestBody Task task){

        System.out.println("Received user: " + task.getTitle() + ", " + task.getUser().getName());

        taskRepo.save(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public User getByTaskId(@PathVariable Long id){
        Task task = taskRepo.getById(id);
        return task.getUser();
    }


}
