package com.practice.user.controllers;

import com.practice.user.models.User;
import com.practice.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("get/{userId}")
    public User getUser(@PathVariable Long userId) {
        return service.getUserById(userId);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PutMapping("update/{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody User user) {
        service.updateUser(user,userId);
    }

    @DeleteMapping("delete/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        service.deleteUser(userId);
    }
}

