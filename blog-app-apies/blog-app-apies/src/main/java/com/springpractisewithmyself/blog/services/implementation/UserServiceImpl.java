package com.springpractisewithmyself.blog.services.implementation;

import com.springpractisewithmyself.blog.entities.User;
import com.springpractisewithmyself.blog.exceptions.ResourceNotFoundException;
import com.springpractisewithmyself.blog.payloads.UserDto;
import com.springpractisewithmyself.blog.repositories.UserRepo;
import com.springpractisewithmyself.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = dtoToUser(userDto);
        User savedUser = userRepo.save(user);
        return userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto user, Integer userId) {
        User foundedUser = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        foundedUser.setName(user.getName());
        foundedUser.setEmail(user.getEmail());
        foundedUser.setPassword(user.getPassword());
        foundedUser.setAbout(user.getAbout());

        User updatedUser = userRepo.save(foundedUser);
        return userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User foundedUser = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        return userToDto(foundedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User foundedUser = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        userRepo.delete(foundedUser);
    }

    public User dtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }
}
