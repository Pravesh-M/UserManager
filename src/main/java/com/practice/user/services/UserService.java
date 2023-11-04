package com.practice.user.services;

import com.practice.user.models.User;
import com.practice.user.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public User createUser(User user) {
        // Add validation and password hashing here if needed
        return repo.save(user);
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public void updateUser(User user) {
        // Implement user update logic
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}
