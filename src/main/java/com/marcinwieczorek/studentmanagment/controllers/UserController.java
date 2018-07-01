package com.marcinwieczorek.studentmanagment.controllers;

import com.marcinwieczorek.studentmanagment.repositories.UserRepository;
import com.marcinwieczorek.studentmanagment.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userRepository.getOne(id);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return true;
    }

    @PutMapping("/user/")
    public User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PostMapping("/user/")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
}
