package com.example.task_api.controller;


import com.example.task_api.model.User;
import com.example.task_api.repository.UserRepository;
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

    @Autowired
    public UserController(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userRepo.getById(id);
    }

    @PostMapping
    public User createUser(User user){
        return userRepo.save(user);
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        Optional<User> temp = userRepo.findById(id);

        if(temp.isPresent()){
            User user = temp.get();

            user.setId(id);
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());

            userRepo.save(user);
        }else{
            updatedUser.setId(id);
            userRepo.save(updatedUser);
        }

        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        if(userRepo.findById(id).isPresent()){
            User deletedUser = userRepo.findById(id).get();
            userRepo.deleteById(id);
            return new ResponseEntity<>(deletedUser, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email){
        Optional<User> user = userRepo.findByEmail(email);

        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
