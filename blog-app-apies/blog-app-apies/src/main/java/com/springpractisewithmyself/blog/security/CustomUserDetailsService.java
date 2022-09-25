package com.springpractisewithmyself.blog.security;

import com.springpractisewithmyself.blog.entities.User;
import com.springpractisewithmyself.blog.exceptions.ResourceNotFoundException;
import com.springpractisewithmyself.blog.repositories.UserRepo;
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
        User user = userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("user ", "email : " + username, 0));
        return user;
    }

}
