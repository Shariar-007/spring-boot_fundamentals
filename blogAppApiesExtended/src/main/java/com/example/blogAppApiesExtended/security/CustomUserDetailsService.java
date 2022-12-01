package com.example.blogAppApiesExtended.security;

import com.example.blogAppApiesExtended.entities.User;
import com.example.blogAppApiesExtended.exceptions.ResourceNotFoundException;
import com.example.blogAppApiesExtended.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // loading user from database by username
        User user = userRepo.findByUserName(username).orElseThrow(() -> new ResourceNotFoundException("username ", ": " + username, 0));
        return user;
    }
}
