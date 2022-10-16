package com.example.blogAppApiesExtended.services;

import com.example.blogAppApiesExtended.payloads.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(Integer userId);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto registerNewUser(UserDto user);

    void deleteUser(Integer userId);
}
