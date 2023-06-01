package com.example.vts2.service;

import com.example.vts2.entity.User;
import com.example.vts2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
