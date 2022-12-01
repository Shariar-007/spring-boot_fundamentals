package com.exam.service;

import com.exam.models.User;
import com.exam.models.UserRole;

import java.util.List;
import java.util.Set;


public interface UserService {

    // creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public List<User> getAllUser() throws Exception;

    public User getUser(String userName) throws Exception;

    public void deleteUser(Long id) throws Exception;

    public User updateUser(User user, Long userId) throws Exception;
}
