package com.example.task_api.controller;


import com.example.task_api.dto.UserDTO;
import com.example.task_api.model.User;
import com.example.task_api.repository.UserRepository;
import com.example.task_api.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserRepository userRepo;
    private final UserTaskService userTaskService;

    @Autowired
    public UserController(UserRepository userRepo, UserTaskService userTaskService){
        this.userTaskService = userTaskService;
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id){
        return userTaskService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){

        System.out.println("Received user: " + userDTO.getName() + ", " + userDTO.getEmail());
        userTaskService.createUser(userDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO updatedUser){

        UserDTO temp = userTaskService.getUserById(id);

        userTaskService.createUser(temp);

        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id){
        userTaskService.deleteUserById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<UserDTO> getUserByEmail(@RequestParam String email){
        UserDTO userDTO = userTaskService.getUserByEmail(email);

        return new ResponseEntity<>(userDTO, HttpStatus.FOUND);
    }
}
