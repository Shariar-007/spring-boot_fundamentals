package com.example.blogAppApiesExtended.repositories;

import com.example.blogAppApiesExtended.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String email);
}
