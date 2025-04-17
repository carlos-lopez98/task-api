package com.example.task_api.controller;


import com.example.task_api.dto.UserDTO;
import com.example.task_api.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing users.
 * Provides endpoints to create, retrieve, update, and delete users,
 * as well as search users by email.
 *
 * @author CJL
 */
@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserTaskService userTaskService;

    @Autowired
    public UserController(UserTaskService userTaskService){
        this.userTaskService = userTaskService;
    }

    /**
     * Retrieves all users in the database.
     *
     * @return a list of UserDTOs
     */
    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userTaskService.getAllUsers();
    }

    /**
     * Retrieves a user by their unique ID.
     *
     * @param id the ID of the user
     * @return the UserDTO if found, or 404 if not
     */
    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id){
        return userTaskService.getUserById(id);
    }

    /**
     * Creates a new user.
     *
     * @param userDTO the user data to be created
     * @return the created UserDTO
     */
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){

        System.out.println("Received user: " + userDTO.getName() + ", " + userDTO.getEmail());
        userTaskService.createUser(userDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Updates a user's information.
     *
     * @param id      the ID of the user to update
     * @param updatedUser the updated user data
     * @return the updated UserDTO if successful, or 404 if the user is not found
     */
    @PostMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO updatedUser){

        UserDTO temp = userTaskService.getUserById(id);

        userTaskService.createUser(temp);

        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    /**
     * Deletes a user by ID.
     *
     * @param id the ID of the user to delete
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id){
        userTaskService.deleteUserById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Retrieves a user by their email address.
     *
     * @param email the email of the user to search for
     * @return the UserDTO if found
     */
    @GetMapping("/search")
    public ResponseEntity<UserDTO> getUserByEmail(@RequestParam String email){
        UserDTO userDTO = userTaskService.getUserByEmail(email);

        return new ResponseEntity<>(userDTO, HttpStatus.FOUND);
    }
}
