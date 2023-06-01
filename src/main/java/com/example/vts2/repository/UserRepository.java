package com.example.vts2.repository;

import com.example.vts2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserByLogin(String login);
}
