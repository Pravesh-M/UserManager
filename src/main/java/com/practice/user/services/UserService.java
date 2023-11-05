package com.practice.user.services;

import com.practice.user.models.User;
import com.practice.user.repositories.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    public User createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public User getUserById(Long userId) {
        return repo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with id "+userId+" Not Found"));
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public void updateUser(User user,Long userId) {
        User dbUser = getUserById(userId);
        dbUser.setName(user.getName());
        dbUser.setEmail(user.getEmail());
        dbUser.setPassword(encoder.encode(user.getPassword()));
        dbUser.setRole(user.getRole());
        repo.save(dbUser);
    }

    public void deleteUser(Long userId) {
        repo.deleteById(userId);
    }
}
