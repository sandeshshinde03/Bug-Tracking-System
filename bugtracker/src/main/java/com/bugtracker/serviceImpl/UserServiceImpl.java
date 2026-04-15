package com.bugtracker.serviceImpl;

import com.bugtracker.entity.User;
import com.bugtracker.repository.UserRepository;
import com.bugtracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    // Get users with DEVELOPER role
    @Override
    public List<User> getDevelopers() {

        return userRepository.findByRole("ROLE_DEVELOPER");
    }
    
    // Get user by ID
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
}